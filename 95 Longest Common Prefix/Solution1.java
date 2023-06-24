
class Solution {
    public static String longestCommonPrefix(String[] arr, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= 1000; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1; j++) {
                if (i >= arr[j].length()) {
                    flag = true;
                    break;
                }
                if (arr[j].charAt(i) != arr[j + 1].charAt(i)) {
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
            res.append(arr[0].charAt(i));
        }
        return res.toString();
    }

}
