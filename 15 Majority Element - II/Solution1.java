import java.io.*;
import java.util.*;

import java.util.ArrayList;

class Solution {
    public static ArrayList<Integer> majorityElementII(ArrayList<Integer> arr) {
        int n = arr.size();
        int candidates[] = findCandidates(arr);
        int freq[] = new int[2];
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == candidates[0])
                freq[0]++;
            else if (arr.get(i) == candidates[1])
                freq[1]++;
        }
        ArrayList<Integer> res = new ArrayList<>();
        if (freq[0] > n / 3)
            res.add(candidates[0]);
        if (freq[1] > n / 3)
            res.add(candidates[1]);

        return res;
    }

    static int[] findCandidates(ArrayList<Integer> arr) {
        int candidate1 = -1;
        int candidate2 = -1;
        int vote1 = 0;
        int vote2 = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == candidate1)
                vote1++;
            else if (arr.get(i) == candidate2)
                vote2++;
            else if (vote1 == 0) {
                vote1 = 1;
                candidate1 = arr.get(i);
            } else if (vote2 == 0) {
                vote2 = 1;
                candidate2 = arr.get(i);
            } else {
                vote1--;
                vote2--;
            }
        }
        return new int[] { candidate1, candidate2 };
    }
}
// Time complexity : O(n)