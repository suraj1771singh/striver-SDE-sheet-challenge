import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> findSubsetsThatSumToK(ArrayList<Integer> arr, int n, int k) {
        res = new ArrayList<>();
        f(0, k, arr, new ArrayList<>());
        return res;
    }

    static void f(int ind, int sum, ArrayList<Integer> arr, ArrayList<Integer> temp) {
        if (ind >= arr.size()) {
            if (sum == 0) {
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        // pick
        temp.add(arr.get(ind));
        f(ind + 1, sum - arr.get(ind), arr, temp);
        // not pick
        temp.remove(temp.size() - 1);
        f(ind + 1, sum, arr, temp);
    }
}