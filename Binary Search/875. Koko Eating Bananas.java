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