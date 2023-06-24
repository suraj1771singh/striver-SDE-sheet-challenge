class Solution {
    public static String reverseString(String str) {
        str = str.trim();
        StringBuilder res = new StringBuilder();
        String a[] = str.split(" ");
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i].equals(" "))
                continue;
            else
                res.append(a[i] + " ");
        }
        return res.toString().trim();
    }
}
