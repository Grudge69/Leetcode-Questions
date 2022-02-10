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