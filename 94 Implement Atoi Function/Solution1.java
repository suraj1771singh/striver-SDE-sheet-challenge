
class Solution {
    public static int atoi(String str) {
        int ans = 1;
        for (char c : str.toCharArray()) {
            if (c >= '0' && c <= '9') {
                ans += c - '0';
                ans *= 10;
            }
        }
        return ans / 10;
    }
}
