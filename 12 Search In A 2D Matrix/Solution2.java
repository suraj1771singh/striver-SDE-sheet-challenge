import java.util.ArrayList;

class Solution2 {
    static boolean searchMatrix(ArrayList<ArrayList<Integer>> mat, int target) {
        int n = mat.size();
        int m = mat.get(0).size();
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (mat.get(i).get(j) == target)
                return true;
            else if (mat.get(i).get(j) < target)
                i++;
            else
                j--;
        }
        return false;
    }
}
// Time complexity : O(n+m)
