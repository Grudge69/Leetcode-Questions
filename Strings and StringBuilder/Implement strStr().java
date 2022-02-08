// O(m*n) approach

// class Solution {
//     public int strStr(String haystack, String needle) {
//         int m = haystack.length();
//         int n = needle.length();
//         if(needle.length()==0){
//         return 0;
//         }
//         for(int i =0; i<=m-n;i++){

//                 for(int j=0; j<n; j++){
//                     if(needle.charAt(j)!=haystack.charAt(j+i)){
//                         break;
//                     }
//                     else if(needle.charAt(j)==haystack.charAt(j+i) && j==n-1){
//                         return i;
//                     }
//                 }

//             }

//             return -1;
//     }
// }

// USING STRING FUNCTION indexOf()
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}