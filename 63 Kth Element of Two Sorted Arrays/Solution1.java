public class Solution {
    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        int i = 0, j=0;
        int ans =0;
        m=row1.length; n = row2.length;
        while(i<m && j<n && k>0){
            if(row1[i]<=row2[j]){
                ans = row1[i];
                i++;
            }else{
                ans = row2[j];
                j++;
            }
            k--;
        }
        while(k>0 && i<m){
            ans = row1[i];
            i++;
            k--;
        }
        while(k>0 && j<n){
            ans = row2[j];
            j++;
            k--;
        }
        return ans;
    }
}
