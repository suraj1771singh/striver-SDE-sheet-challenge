import java.util.*;
import java.io.*;

class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        double ans = 0;

        Arrays.sort(items, (a, b) -> -1 * Double.compare((a.value * 1.0) / a.weight, (b.value * 1.0) / b.weight));

        int i = 0;
        while (w > 0 && i < n) {
            double weight = (double) items[i].weight;
            double value = (double) items[i].value;
            if (w - weight >= 0) {
                ans += value;
                w -= weight;
            } else {
                ans += ((value * w) / weight);
                w = 0;
            }
            i++;
        }
        return ans;
    }
}