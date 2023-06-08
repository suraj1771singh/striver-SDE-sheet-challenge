import java.io.*;
import java.util.*;

import java.util.ArrayList;

class Solution {
    public static int findDuplicate(ArrayList<Integer> arr, int n) {
        for (int i = 0; i < n; i++) {
            int num = Math.abs(arr.get(i));
            int ind = num - 1;
            if (arr.get(ind) < 0)
                return num;
            else
                arr.set(ind, -1 * arr.get(ind));
        }
        return 0;
    }
}
// Time complexity : O(n)