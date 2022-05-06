// Link: https://leetcode.com/problems/merge-sorted-array/

// Solution: Time O(M+N) Space O(M+N) 2 ptr method

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //merged Arr of size m+n
        int[] mergedArr = new int[m+n];
        
        //iterators for nums1, nums2 and mergedArr
        int itr1 = 0, itr2 = 0, i=0;
        
        //iterate till either nums1 or nums2 is fully traversed
        while(itr1<m && itr2<n) {
            //if nums1 has smaller value then add its value to merged arr and increment itr1 and i
            if(nums1[itr1] < nums2[itr2]) {
                mergedArr[i++] = nums1[itr1];
                itr1++;
            }
            //otherwise add its value to merged arr and increment itr2 and i
            else {
                mergedArr[i++] = nums2[itr2];
                itr2++;
            }
        }
        
        //if there is any value left in nums1, add it to mergedArr
        while(itr1<m) {
            mergedArr[i++] = nums1[itr1++];
        }
        //if there is any value left in nums2, add it to mergedArr
        while(itr2<n) {
            mergedArr[i++] = nums2[itr2++];
        }
        
        //add the merged arr values in nums1, as per required by the question
        for(int j=0; j<m+n; j++) {
            nums1[j] = mergedArr[j];
        }
    }
}

// Insertion sort method O(N*M) time, space O(1)

class Solution {
    public void merge(int[] arr1, int n, int[] arr2, int m) {
        int k;
        if(m == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
          // take first element from arr1 
          // compare it with first element of second array
          // if condition match, then swap
          if (arr1[i] > arr2[0]) {
            int temp = arr1[i];
            arr1[i] = arr2[0];
            arr2[0] = temp;
          }

          // then sort the second array
          // put the element in its correct position
          // so that next cycle can swap elements correctly
          int first = arr2[0];
          // insertion sort is used here
          for (k = 1; k < m && arr2[k] < first; k++) {
            arr2[k - 1] = arr2[k];
          }
          arr2[k - 1] = first;
        }
        
        int itr1 = n;
        for(int j=0; j<m; j++) {
            arr1[itr1] = arr2[j];
            itr1++;
        }
        
    }
}

// Gap Method
// Time: O(logN), Space: O(1)
class Solution {
    public void swap(int[] ar1, int[] ar2, int i, int j)
    {
        int temp = ar1[i];
        ar1[i] = ar2[j];
        ar2[j] = temp;
    }
    
    public void merge(int[] ar1, int n, int[] ar2, int m) {
        int gap =(int) Math.ceil((double)(n + m) / 2.0);
        
        while (gap > 0) {
            int i = 0;
            int j = gap;
            
            while (j < (n + m)) {
                if (j < n && ar1[i] > ar1[j]) {
                    swap(ar1, ar1, i, j);
                } else if (j >= n && i < n && ar1[i] > ar2[j - n]) {
                    swap(ar1, ar2, i, j-n);
                } else if (j >= n && i >= n && ar2[i - n] > ar2[j - n]) {
                    swap(ar2, ar2, i - n, j - n);
                }
                j++;
                i++;
            }
            
            if (gap == 1) {
                gap = 0;
            } else {
                gap =(int) Math.ceil((double) gap / 2.0);
            }
        }

        int itr1 = n;
        for(int j=0; j<m; j++) {
            ar1[itr1] = ar2[j];
            itr1++;
        } 
    }
}