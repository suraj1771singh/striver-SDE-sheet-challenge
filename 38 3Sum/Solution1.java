import java.util.*;
import java.io.*;

class Solution {

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n - 3; i++) {
            int l = i + 1, h = n - 1;
            while (l < h) {
                if (arr[l] + arr[h] == K - arr[i]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[l]);
                    temp.add(arr[h]);
                    res.add(temp);
                    while (l + 1 < h && arr[l] == arr[l + 1])
                        l++;
                    l++;
                    while (l < h - 1 && arr[h] == arr[h - 1])
                        h--;
                    h--;
                } else if (arr[l] + arr[h] > K - arr[i])
                    h--;
                else
                    l++;
            }
            while (i + 1 < n && arr[i] == arr[i + 1])
                i++;
        }
        return res;

    }
}
