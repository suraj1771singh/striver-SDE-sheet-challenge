

class Solution {
    public static void sort012(int[] arr) {
        int n = arr.length;
        int ptr1 = 0, ptr2 = n - 1;
        int ind = 0;
        while (ind <= ptr2) {
            if (arr[ind] == 0) {
                swap(ind, ptr1, arr);
                ptr1++;
                ind++;
            } else if (arr[ind] == 2) {
                swap(ind, ptr2, arr);
                ptr2--;
            } else
                ind++;
        }
    }

    public static void swap(int i, int j, int arr[]) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}