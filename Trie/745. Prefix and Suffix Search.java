// Link: https://leetcode.com/problems/prefix-and-suffix-search/

// Solution: Using HashMap for DP memoization

// Method 1

class WordFilter {
    String[] words;
    HashMap<String, Integer> dp;

    public WordFilter(String[] w) {
        this.words = w;
        this.dp = new HashMap<>();
    }
    
    public int f(String prefix, String suffix) {
        int ans = -1;
        
        String combPreSuf = prefix + "-" + suffix;
        
        if(dp.containsKey(combPreSuf)) {
            return dp.get(combPreSuf);
        }
        
        for(int i=0; i<words.length; i++) {
            String word = words[i];
            
            if(word.startsWith(prefix) && word.endsWith(suffix)) {
                ans = i;
            }
        }
        
        dp.put(combPreSuf, ans);
        
        return ans;
    }
}

 // Method 2

 class WordFilter {
    HashMap<String,Integer> map;
    public WordFilter(String[] words) {
        
        String prefix="", suffix="";
        
        map = new HashMap<String,Integer>();
        
        for(int i=0;i<words.length;i++) {
            for(int j=0;j<words[i].length();j++) {
                
                prefix= words[i].substring(0,j+1);
                
                for(int k=words[i].length()-1;k>=0;k--) {  
                    suffix = words[i].substring(k);
                    map.put(prefix+"#"+suffix,i);
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
       return map.getOrDefault(prefix+"#"+suffix,-1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */