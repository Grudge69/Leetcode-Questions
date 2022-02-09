class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if no string is there then return empty str
        if(strs.length==0)return "";
        
        // take first word in str[] as prefix
        String prefix=strs[0];
        // iterate from 2 word to end of string array
        for(int i=1;i<strs.length;i++){
            
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }
}