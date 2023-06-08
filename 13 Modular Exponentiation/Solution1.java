import java.io.*;
import java.util.*;

class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        return f(x, n, m);
    }

    static int f(int x, int n, int m) {
        if (n == 0)
            return 1;
        long ans = 1;
        if (n % 2 == 0) {
            ans = f(x, n / 2, m);
            ans = (ans * ans) % m;
        } else {
            ans = f(x, n / 2, m);
            ans = (ans * ans) % m;
            ans = (ans * x) % m;
        }
        return (int) ans;
    }
}