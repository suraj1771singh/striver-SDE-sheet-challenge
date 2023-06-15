import java.util.*;

class Solution {
    public static int removeDuplicates(ArrayList<Integer> arr, int n) {
        int cnt = 1;
        int pos = 1;
        for (int i = 1; i < arr.size(); i++) {
            if (!arr.get(i - 1).equals(arr.get(i))) {

                arr.set(pos, arr.get(i));
                cnt++;
                pos++;
            }
        }
        return cnt;
    }
}