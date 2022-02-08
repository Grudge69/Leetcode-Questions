/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int peak = findPeakElement(arr);
        // search in increasing part of the array
        int firstTry = orderAgnosticBinarySearch(arr, target, 0, peak);
        if(firstTry != -1){
            return firstTry;
        }
        // search in decreasing part of the array
        int secondTry = orderAgnosticBinarySearch(arr, target, peak+1, arr.length() - 1);
        
        return secondTry;
    }
 
    
    // finding peak element
    public int findPeakElement(MountainArray arr) {
        int start = 0;
        int end = arr.length() -1;
        
        while(start<end){
            int mid = start+(end-start)/2;
            int midElem = arr.get(mid);
            int midElemP1 = arr.get(mid+1);
            if(midElem<midElemP1){
                // increasing part of the array
                start  = mid+1;
            }else if(midElem>midElemP1){
                end = mid;
            }
        }
        
        // start == end, so "return start" is same as "return end"
        return start;
    }
    
    // performing order agnostic binary search
    public int orderAgnosticBinarySearch(MountainArray nums, int target, int start, int end) {
        boolean isAsc = nums.get(start) < nums.get(end);
        while(start<=end){
            int mid = start + (end-start)/2;
            int midElem = nums.get(mid);
            if(midElem==target){
                return mid;
            }
            
            if(isAsc){
                if(midElem>target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(midElem<target){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
        }
        
        return -1;
    }
}