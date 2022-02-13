class Solution {
    public int[] decode(int[] encoded, int first) {
        int encodedSize = encoded.length;
        
        int[] ans = new int[encodedSize+1];
        
        ans[0] = first;
        
        for(int i=0; i<encodedSize; i++){
            ans[i+1] = (ans[i]^encoded[i]);
        }
        
        return ans;
    }
}