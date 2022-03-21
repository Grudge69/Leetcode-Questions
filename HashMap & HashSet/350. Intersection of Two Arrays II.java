// Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/

// Solution: Using HashMap as frequency map

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        
        //frequency map for nums1
        for(int i=0; i<nums1.length; i++){
            int val = nums1[i];
            if(map1.containsKey(val)){
                map1.put(val, map1.get(val)+1);
            }else{
                map1.put(val, 1);
            }
        }
        //frequency map for nums2
        for(int i=0; i<nums2.length; i++){
            int val = nums2[i];
            if(map2.containsKey(val)){
                map2.put(val, map2.get(val)+1);
            }else{
                map2.put(val, 1);
            }
        }
        
        //traverse keys of map1 and check if they are present in map2
        for(int key: map1.keySet()){
            //if a key of map1 is present in map2 then the intersection is minimum of both their frequencies
            if(map2.containsKey(key)){
                int minFreq = Math.min(map1.get(key), map2.get(key));
                //in ans list add key minFreq no. of times
                while(minFreq-->0){
                    ans.add(key);
                }
            }
        }
        
        //convert list to array
        int[] finalAns = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            finalAns[i] = ans.get(i);
        }
        
        //return final array
        return finalAns;
    }
}


// USING ARRAY INSTEAD OF HASHMAP FOR FREQUENCY CHECK(fastest)

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //frequency array for nums1
        //size if 1001 because the range of nums1 or nums2 is from [0, 1000]
        int[] arr = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            arr[nums1[i]]++;
        }
        //stores answer
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        /*traverse through nums2 and check in frequency array of nums1 that if the values of nums2 are present in it, if that is the case then add that value in our ans list and subtract 1 from frequency as this value is processed 1 time*/
        for (int i = 0; i < nums2.length; i++) {
            if (arr[nums2[i]] > 0) {
                arr[nums2[i]]--;
                al.add(nums2[i]);
            }
        }
        //converting array list to array(we can use a new array as well I have used the frequency array reference variable only as the need for it was finished so this variable can be reused)
        arr = new int[al.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = al.get(i);
        }
        //return final ans
        return arr;
    }
}


//SORTING BOTH ARRAYS AND THEN TRAVERSING

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        //List for containing answer
        List<Integer> list = new ArrayList<>();
        
        //sort both arrays
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        //pointers for nums1 and nums2
        int i = 0, j = 0;
        
        //iterating both nums1 and nums2 simultaneously till any one of them is finished
        while (i < nums1.length && j < nums2.length) {
            //if the values match in both arr then it is a part of intersection
            if (nums1[i] == nums2[j]) {
                //add that value in intersection list
                list.add(nums1[i]);
                //increment both pointers
                i++; j++;
            } 
            //if val of nums1 < val of nums2, val of nums1 will never occur in nums2 as both arr are sorted, so move nums1 ptr 1 step ahead
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            //if val of nums2 < val of nums1, val of nums2 will never occur in nums1 as both arr are sorted, so move nums2 ptr 2 step ahead
            else {
                j++;
            }
        }
        
        //converting list to array
        int[] res = new int[list.size()];
    
        for (int x = 0; x < list.size(); ++x) {
            res[x] = list.get(x);
        }
        //return final ans
        return res;
    }
}