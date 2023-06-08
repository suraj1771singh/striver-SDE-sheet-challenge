import java.util.*;

class Solution {
    public static int[] ninjaAndSortedArrays(int arr1[], int arr2[], int m, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p3 = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (arr1[p1] > arr2[p2])
                arr1[p3--] = arr1[p1--];
            else if (arr1[p1] < arr2[p2])
                arr1[p3--] = arr2[p2--];
            else {
                arr1[p3--] = arr1[p1--];
                arr1[p3--] = arr2[p2--];
            }
        }
        while (p1 >= 0)
            arr1[p3--] = arr1[p1--];
        while (p2 >= 0)
            arr1[p3--] = arr2[p2--];
        return arr1;
    }
}

// Time complexity : O(n+m)