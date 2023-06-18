import java.util.ArrayList;

class Solution {
    public static int singleNonDuplicate(ArrayList<Integer> arr) {

       int left = 0, right = arr.size()-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && arr.get(mid) == arr.get(mid+1)) || 
              (mid %2 == 1 && arr.get(mid) == arr.get(mid-1)) )
                left = mid + 1;
            else
                right = mid;
        }
        return arr.get(left);
    }
}