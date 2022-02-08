class Solution {
    public char findTheDifference(String s, String t) {
        int ans = 0;

        // add all characters(ASCII VALUES) from long string(t)
        for (char ch : t.toCharArray()) {
            ans += ch;
        }

        // subtract all characters(ASCII VALUES) of small string(s) from computed sum
        // above
        for (char ch : s.toCharArray()) {
            ans -= ch;
        }

        // convert ascii of ans to character
        return (char) ans;
    }
}