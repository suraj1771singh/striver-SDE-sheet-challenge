import java.util.*;
import java.io.*;

class Solution {
    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        int n = start.length;
        int a[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            a[i] = new int[] { start[i], end[i], i + 1 };
        }
        Arrays.sort(a, (i, j) -> i[1] - j[1]);
        List<Integer> list = new ArrayList<>();
        list.add(a[0][2]);
        int prevend = a[0][1];
        for (int i = 1; i < n; i++) {
            if (prevend < a[i][0]) {
                list.add(a[i][2]);
                prevend = a[i][1];
            }
        }
        return list;
    }
}