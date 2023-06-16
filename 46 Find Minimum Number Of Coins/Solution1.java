import java.util.*;
import java.io.*;

class Solution {
    public static int findMinimumCoins(int amount) {
        int deno[] = new int[] { 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
        int i = deno.length - 1;
        int cnt = 0;
        while (amount > 0 && i >= 0) {
            if (amount >= deno[i]) {
                amount -= deno[i];
                cnt++;
            } else
                i--;

        }
        return cnt;

    }
}
// Time complexity : O(amount)
