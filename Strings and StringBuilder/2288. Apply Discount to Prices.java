// Link: https://leetcode.com/problems/apply-discount-to-prices/

// Solution

// Approach 1

class Solution {
    public String discountPrices(String sentence, int discount) {
        String [] vals = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        String s;
        double d;
        int v;
        
        for (int i = 0; i < vals.length; ++i){
            s = vals[i];
            
            if (isPrice(s)){
                d = Double.parseDouble(s.substring(1));
                d -= d * discount / 100;
                sb.append('$');
                sb.append((long) d);
                d %= 1;
                d *= 100;
                v = (int)d + (d % 1 >= 0.5 ? 1 : 0);
                sb.append('.');
                if (v < 10 )
                    sb.append(0);
                sb.append(v);
            }else{
                sb.append(s);
            }
            
            if (i < vals.length - 1)
                sb.append(' ');
        }
        
        return sb.toString();
    }
    
    private boolean isPrice(String s){
        if (s.length() < 2 || s.charAt(0) != '$' || s.charAt(1) == '0')
            return false;
        
        
        for (int i = 1; i < s.length(); ++i){
            if (s.charAt(i) < '0' || s.charAt(i) > '9') return false;
        }
        
        return true;
    }
}

// Approach 2

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        
        StringBuilder ans = new StringBuilder();
        for(String word: words) {
            if(word.charAt(0)=='$' && word.length()!=1) {
                boolean check = false;
                for(int i=1; i<word.length(); i++) {
                    if(word.charAt(i)=='$' || !Character.isDigit(word.charAt(i))) {
                        check = true;
                        break;
                    }   
                }
                
                if(check == false) {
                    double val = Double.parseDouble(word.substring(1));
                    double disc = (double)discount/100;
                    double newVal = val - (val*disc);
                    word = "$"+String.format("%.2f", newVal);
                }
            }
            
            ans.append(word+" ");   
        }
        
        String finalAns = ans.toString().trim();
        
        return finalAns;
    }
}