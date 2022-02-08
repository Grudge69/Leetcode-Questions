/**
 * Forward declaration of guess API.
 * 
 * @param num your guess
 * @return -1 if num is lower than the guess number
 *         1 if num is higher than the guess number
 *         otherwise return 0
 *         int guess(int num);
 */

class Solution {
    public:
        int guessNumber(int n) {
            int left = 1, right = n, ans = -1;
            
            if(guess(1)==0) return 1;
            
            while(left<=right){
                int mid = left +(right-left)/2;
                
                if(guess(mid)==0){
                    return mid;
                }else if(guess(mid)==-1){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            
            return ans;
        }
};