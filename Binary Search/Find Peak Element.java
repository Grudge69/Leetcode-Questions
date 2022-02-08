class Solution {
    public int findPeakElement(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        
        while(start<end){
            int mid = start+(end-start)/2;
            
            if(arr[mid]<arr[mid+1]){
                // increasing part of the array
                start  = mid+1;
            }else if(arr[mid]>arr[mid+1]){
                end = mid;
            }
        }
        
        // start == end, so "return start" is same as "return end"
        return start;
    }
}