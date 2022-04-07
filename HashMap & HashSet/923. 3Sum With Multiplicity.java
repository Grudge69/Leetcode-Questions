// Link:

// Solution: 2 pointer and count array O(N^2) time 

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007; //10^9 + 7
        long result = 0; //count of triplets
        
        //take 2 pointers i and j traversing the entire array
        for(int i=0; i<arr.length; i++){
            //keep count of all the elements in the array(0-100 is the limit in the question)
            int[] count = new int[101]; // can use HASHMAP here
            //for every number check its next no. till end 
            for(int j=i+1; j<arr.length; j++){
                //get a k value such that arr[i] + arr[j] + k = target
                int k = target - arr[i] - arr[j];
                //search for this k inside our array, also the k should be in range 0-100
                if(k>=0 && k<=100 && count[k]>0){
                    //if a k is found then the no. of such triplets is no. of k's present as each k can come one time to form a different triplet
                    result += count[k];
                    result %= mod; //mod is used to keep result from getting out of bounds
                }
                //store particular value encountered in our count array
                count[arr[j]]++;
            }
        }
        
        //convert result to int and return
        return (int)result;
    }
}

// O(N) time, O(1) space
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int mod = 1000000007; //10^9 + 7
        long result = 0; //count of triplets
        long[] count = new long[101];
        
        for(int val: arr) count[val]++; // store occurrences of each value in array
        
        //take 2 pointers i and j from 0-100
        for(int i=0; i<=100; i++){
            for(int j=i; j<=100; j++){
                //get a k value such that i + j + k = target
                int k = target - i - j;
                
                if(k<0 || k>100) continue; // skip values outside range 0-100
                
                // 3 cases for i and j and k
                
                // FIRST, i==j==k, C(n,3) = n!/3!(n-3)! = n*(n-1)*(n-2)/6
                if(i==j && j==k){//all same
                    result += (count[i] * (count[i]-1) * (count[i]-2))/6;
                    result %= mod;//keep result in range
                }
                
                // SECOND, i==j!=k, C(n,2)*count[k] = n!/2!(n-2)!*count[k] = n*(n-1)/2*count[k]
                else if(i==j && j!=k){//1 different
                    result += ((count[i] * (count[i]-1))/2)*count[k];
                    result %= mod;//keep result in range
                }
                
                // THIRD, i<j<k, count[i]*count[j]*count[k]
                else if(i<j && j<k){//all different
                    result += count[i]*count[j]*count[k];
                    result %= mod;//keep result in range
                }
            }
        }
        
        //convert result to int, keep result in range with mod and return
        return (int)(result%mod);
    }
}


// USING HASHMAP

class Solution {
    public int threeSumMulti(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < arr.length; i++) {
            res = (res + map.getOrDefault(target - arr[i], 0)) % mod;
            
            for (int j = 0; j < i; j++) {
                int temp = arr[i] + arr[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
}

