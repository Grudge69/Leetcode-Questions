                                // QUESTION DESCRIPTION

// Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

// Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

// Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

// Return the minimum integer k such that she can eat all the bananas within h hours.

 

// Example 1:

// Input: piles = [3,6,7,11], h = 8
// Output: 4
// Example 2:

// Input: piles = [30,11,23,4,20], h = 5
// Output: 30
// Example 3:

// Input: piles = [30,11,23,4,20], h = 6
// Output: 23
 

// Constraints:

// 1 <= piles.length <= 104
// piles.length <= h <= 109
// 1 <= piles[i] <= 109

                                // SOLUTION USING BINARY SEARCH

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // binary search to calculate k(mid) i.e. rate of eating bananas
        // could have used "right = piles[piles.length-1]" if the array was sorted as
        // last would be max element
        // but sorting the array will just add more time
        // instead make right=max of int range
        Arrays.sort(piles);
        int left = 1, right = piles[piles.length - 1];

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkEatingBananaUnderTime(piles, mid, h) == true) {
                // checking if she can eat all bananas under the time(h),
                // then there might be a possible solution with less rate
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left; // bcz left pointer hold our optimize k, at the end of BS
    }

    // public boolean checkEatingBananaUnderTime(int[] piles, int rate, int hours){
    // int time=0, multiplier=1;
    // int left = piles[0], right=piles[piles.length-1];

    // while(left<=right){
    // int mid = left + (right-left)/2;
    // if(mid==rate){
    // time+=((mid+1)*multiplier);
    // multiplier++;
    // rate*=multiplier;
    // }else if(mid<rate){
    // left=mid+1;
    // }else{
    // right=mid-1;
    // }
    // }

    // return time<=hours;
    // }
    public boolean checkEatingBananaUnderTime(int[] piles, int rate, int hours) {
        // calculating to eat all the bananas at the given rate
        int time = 0;

        // traversing through each pile to calculate time in eating them all
        for (int pile : piles) {
            // performing claculation, take an example
            // k = 4
            // pile = 10

            // pile / k => 10 / 4 = 2
            // pile % k => 2, so we need to have one more hour to eat remaining bananas left
            // over as remainder
            // hours = 3;
            int quo = pile / rate;
            time += quo;

            if (pile % rate != 0) {
                // if remainder value is not 0, we need to have an extra hour
                time++;
            }
        }

        return time <= hours;
    }
}
