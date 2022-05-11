// Link:

// Solution: Recursive + DP(memo+tabulation) + Mathematics

// Recursive: Time = O(5^n) Space = O(n)
class Solution {
    //vowel array
    char[] vowel = new char[]{'a','e','i','o','u'};
    
    public int countVowelStrings(int n) {
        int ans = 0;
        
        //we start iterating from back(considering our c to be last character of a string of length n) 
        //and we count all possible combinations corresponding to each character in the vowel arr
        for(char c: vowel) {
            ans += count(n-1, c);
        }
        
        return ans;
    }
    
    //recursive function
    private int count(int length, char lastChar) {
        if(length == 0) {
            //when length becomes 0, it means it is the 1 and only string that we need
            return 1;
        }
        
        //store combinations from the curr characters with lastChar >= curr char
        int temp = 0;
        
        for(char c: vowel) {
            //ensure lexicographical order
            if(lastChar>=c) {
                //current char is parsed, now consider for length-1 string remaining
                //our curr char becomes lastChar now
                temp += count(length-1, c);
            }
        }
        
        return temp;
    }
}

// DP

// Memoized
class Solution {
    //considering a=0, e=1, i=2, o=4, u=5
    //vowel arr
    char[] vowel = new char[]{'a','e','i','o','u'};
    
    public int countVowelStrings(int n) {
        int ans = 0;
        
        //we start iterating from back(considering our c to be last character of a string of length n) 
        //and we count all possible combinations corresponding to each character in the vowel arr
        int[][] dp = new int[n+1][5];
        
        for(int[] row: dp) {
            Arrays.fill(row,-1);
        }
        
        for(int i=0; i<5; i++) {
            ans += memo(n-1, i, dp);
        }
        
        return ans;
    }
    
    //memoized function
    private int memo(int length, int lastChar, int[][] dp) {
        if(length == 0) {
            //when length becomes 0, it means it is the 1 and only string that we need
            return dp[length][lastChar]  = 1;
        }
        
        if(dp[length][lastChar] != -1) {
            return dp[length][lastChar];
        }
        
        //store combinations from the curr characters with lastChar >= curr char
        int temp = 0;
        
        for(int i=0; i<5; i++) {
            //ensure lexicographical order
            if(vowel[lastChar]>=vowel[i]) {
                //current char is parsed, now consider for length-1 string remaining
                //our curr char becomes lastChar now
                temp += memo(length-1, i, dp);
            }
        }
        
        return dp[length][lastChar] = temp;
    }
}

//Tabulation
class Solution {
    public int countVowelStrings(int n) {
        int[][] dp=new int[n+1][6];
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=5;j++){
                dp[i][j]=dp[i][j-1]+(i>1?dp[i-1][j]:1);
            }
        }
        
        return dp[n][5];
    }
}

//MATHEMATICS

class Solution {
    //no. of combinations of length n with k values with repetitions = (n + k - 1)!/((k-1)!*(n)!)
    //put n, k=5(5 vowels) => (n+4)!/(4!*n!) --> further simplified to (n+4)*(n+3)*(n+2)*(n+1) / 24
    public int countVowelStrings(int n) {
        return (n+4)*(n+3)*(n+2)*(n+1) / 24;
    }
}