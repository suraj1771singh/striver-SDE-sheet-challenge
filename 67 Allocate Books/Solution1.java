import java.util.* ;
import java.io.*; 
public class Solution {
    public static long ayushGivesNinjatest(int n, int m, int[] time) {
        
        long l = 0, h = 0;
        for(int i : time) h+=i;
        long ans = 0;
        while(l<=h){
            long mid = l+(h-l)/2;
            if(isValid(mid,time,n)){
                ans = mid;
                h=mid-1;
            }else l = mid+1;
        }
        return ans;
    }
    static boolean isValid(long limit, int[] time, int n){
    
        long sum = 0;
        int cnt=1;
        for(int i=0; i<time.length; i++){
            if(time[i]>limit) return false;
            if(sum + time[i]>limit){
                cnt++;
                sum=time[i];
            }else sum+=time[i];
        }
        return cnt<=n;
    }
}