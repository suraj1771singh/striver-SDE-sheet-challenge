
import java.util.*;

class Solution {
    public static ArrayList<ArrayList<Long>> printPascal(int n) {

        List<Long> prev = new ArrayList<>();
        ArrayList<ArrayList<Long>> res = new ArrayList<>();
        while (n-- > 0) {
            int len = prev.size() + 1;
            ArrayList<Long> curr = new ArrayList<>();
            curr.add(1L);
            for (int i = 1; i < len; i++) {
                if (i == len - 1)
                    curr.add(1L);
                else
                    curr.add(prev.get(i) + prev.get(i - 1));
            }
            prev.clear();
            prev.addAll(curr);
            res.add(curr);
        }
        return res;
    }
}
