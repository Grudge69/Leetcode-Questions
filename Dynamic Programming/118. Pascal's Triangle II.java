// Link: https://leetcode.com/problems/pascals-triangle-ii/

// Solution: using Pascal Triangle 1 logic

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // USING PASCAL TRIANGLE 1 LOGIC
        List<Integer> ans = new ArrayList<>();
        //0th row has 1 element which is 1 only
        if(rowIndex == 0){
            ans.add(1);
            return ans;
        }
        //1th row has 2 elements 1,1
        ans.add(1);
        ans.add(1);
        if(rowIndex == 1){  
            return ans;
        }
        for(int index=1; index<rowIndex; index++){
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(1);
            for(int i=1; i<ans.size(); i++){
                int sum = ans.get(i-1)+ans.get(i);
                curr.add(sum);
            }
            curr.add(1);
            
            ans = new ArrayList<Integer>();
            ans = curr;
        }
        
        return ans;
    }
}

// using nCr

class Solution {
    public List<Integer> getRow(int rowIndex) {
        // in 1 based indexing
        // nth row rth col element is found by using nCr which is the value
        // Combination (n-1, r-1), like 5th row 3 col = comb(4,2)
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<=rowIndex; i++){
            if(i==0 || i==rowIndex){
                ans.add(1);
            }else{
                int val = combination(rowIndex, i);
                ans.add(val);
            }
        }
        
        return ans;
    }
    
    private int combination(int n, int r){
        long res = 1;
        for(int i=0; i<r; i++){
            res *= (n-i);
            res /= (i+1);
        }
        return (int)res;
    }
}