// Link: https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/

// Solution: Array Sorting

class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldierNum = new int[mat.length];
        
        for(int i=0; i<mat.length; i++){
            int soldiers=0;
            for(int j=0; j<mat[0].length; j++){
                if(mat[i][j]==1) soldiers++;
                else break;
            }
            //we have added i because in case of same no. of soldiers the lower value of i will be considered weaker
            soldierNum[i] = soldiers*100 + i;
            //to separate index i from this value we make the no. of soldiers into groups of 100 or any number and then just modulo by that to remove the soldiers value as it is in groups of 100
        }
        
        Arrays.sort(soldierNum);//sort to get weakest -> strongest soldiers
        
        int[] ans = new int[k];//stores our ans
        
        for(int i=0; i<k; i++){
            ans[i] = soldierNum[i]%100;//removing soldiers num and getting i from it
        }
        
        return ans;
    }
}