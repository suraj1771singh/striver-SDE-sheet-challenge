import java.util.*;
import java.io.*;

class Solution {
    public static ArrayList<Integer> subsetSum(int num[]) {
        int n = num.length;
        int limit = (int) Math.pow(2, n) - 1;
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(num);
        for (int i = 0; i <= limit; i++) {
            int sum = 0;
            for (int j = 0; j <= n; j++) {
                if ((i & (1 << j)) != 0)
                    sum += num[j];
            }
            list.add(sum);
        }
        Collections.sort(list);
        return list;

    }

}