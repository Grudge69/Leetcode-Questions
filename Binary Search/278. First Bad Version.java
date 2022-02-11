// The API isBadVersion is defined for you.
// bool isBadVersion(int version);

class Solution {
    public:
        int firstBadVersion(int n) {
            int left = 1, right = n, ans = -1;
            
            if(isBadVersion(1)) return 1;
            
            while(left<=right){
                int mid = left + (right-left)/2;
                if(isBadVersion(mid)){
                    right = mid-1;
                    ans = mid;
                }else{
                    left = mid+1;
                }
            }
            
            return ans;
        }
};