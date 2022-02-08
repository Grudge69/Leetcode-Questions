class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        
        if(n2 < n1) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int s = 0;
        int e = n1;
        int midInMergedArr = (n1+n2+1)/2; //3
        
        int cut1, cut2, l1, l2, r1, r2;
        
        while(s<=e) {
            cut1 = s+(e-s)/2; //1  //2
            cut2 = midInMergedArr - cut1; //2 //1
            
            l1 = (cut1==0) ? Integer.MIN_VALUE : nums1[cut1-1];
            l2 = (cut2==0) ? Integer.MIN_VALUE : nums2[cut2-1];
            
            r1 = (cut1>=n1) ? Integer.MAX_VALUE : nums1[cut1];
            r2 = (cut2>=n2) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1<=r2 && l2<=r1) {
                if((n1+n2)%2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else
                    return (Math.max(l1, l2));
            }
            else
                if(r1 < l2) { //move right in nums1
                    s = cut1+1;
                }
            else
                if(r2 < l1) { // move left in nums1
                    e = cut1-1;   
                }
        }
        return 0.0;

    }
}