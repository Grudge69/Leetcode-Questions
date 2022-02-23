// using HashSet

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        int size = nums.length;

        for (int i = 0; i < size; i++) {
            // if already exists in hashset then curr element is duplicate
            if (set.contains(nums[i]))
                return true;
            // add to hashset if curr element doesn't already exist in it
            else
                set.add(nums[i]);
        }

        return false;
    }
}

// using Set

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int size = nums.length;

        // Add all elements in Set(contains unique elements only)
        for (int i = 0; i < size; i++) {
            set.add(nums[i]);
        }

        // if there are duplicate elements then set size != arr size
        return set.size() != size;
    }
}
