import java.util.*;
import java.io.*;
import java.util.ArrayList;

class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int missing = 0;
        int repeating = 0;
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr.get(i));
            int ind = num - 1;
            if (arr.get(ind) < 0)
                repeating = num;
            else
                arr.set(ind, -1 * arr.get(ind));
        }
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0) {
                missing = i + 1;
                break;
            }
        }
        return new int[] { missing, repeating };
    }
}
// Time complexity : O(n)