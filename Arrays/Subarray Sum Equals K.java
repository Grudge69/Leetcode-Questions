// Approach 1 ->
// Try every possible sub arrays and check sum equal to k (TLE). o(n3)

public int subarraySum(int[] nums, int k1) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            for(int j=i;j<nums.length;j++) {
                int sum=0;
                for(int k=i;k<=j;k++) {
                    sum+=nums[k];        
                }
                if(sum==k1) {
                    ans++;
                }
            }
        }
        return ans;
    }


// Approach 2->
// we can eliminate last loop as we keep can keep on building sum inside second loop and check itself if it reaches k. if yes increment counter. o(n2)

public int subarraySum(int[] nums, int k1) {
        int ans = 0;
        for(int i=0;i<nums.length;i++) {
            int sum=0;
            for(int j=i;j<nums.length;j++) {
                sum+=nums[j];
                if(sum==k1) {
                    ans++;
                }
            }
        }
        return ans;
    }


// Approach 3->
// Map will store sum as key and frequency of sum as value.

// If the cumulative sum up to two indices, say i and j is at a difference of k i.e. if sum[i] - sum[j] = k
// The sum of elements lying between indices i and j is k.

// Based on these thoughts, we make use of a hashmap which is used to store the cumulative sum up to all the indices possible along with the number of times the same sum occurs.

// take map to hold sum till index i. and check if map contains sum-k in it. if yes add frequency to total.
// update map with sum as key and freq as value.
// o(n)

 public int subarraySum(int[] nums, int k) {
 //hold answer
        int ans = 0;
        Map<Integer,Integer> map = new HashMap<>();
		//total sum as 0
        int sum=0;
		//frequency start point as 0,1
        map.put(0,1);
		//iterate array
        for(int i=0;i<nums.length;i++) {
			//hold usm till ith index
            sum+=nums[i];
			//if map contains sum-k. it means total no of items passed between sum and sum-k indexes has sum k.
            if(map.containsKey(sum-k)) {
			   //update counter with freq
               ans+=map.get(sum-k); 
            }
			//add sum to map as key and update frequency.
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }