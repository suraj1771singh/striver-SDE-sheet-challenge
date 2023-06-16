import java.util.*;

class Solution {
    static ArrayList<ArrayList<Integer>> res;

    public static ArrayList<ArrayList<Integer>> combinationSum2(ArrayList<Integer> arr, int n, int target) {
        Collections.sort(arr);
        res = new ArrayList<>();
        f(0, target, arr, new ArrayList<>());
        return res;

    }

    static void f(int ind, int target, ArrayList<Integer> arr, ArrayList<Integer> temp) {

        int n = arr.size();
        if (target == 0)
            res.add(new ArrayList<>(temp));
        for (int i = ind; i < n; i++) {
            if (i != ind && arr.get(i) == arr.get(i - 1))
                continue;
            if (target - arr.get(i) < 0)
                continue;
            temp.add(arr.get(i));
            f(i + 1, target - arr.get(i), arr, temp);
            temp.remove(temp.size() - 1);

        }
    }
}