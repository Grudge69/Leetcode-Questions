class Solution {
    public int lengthOfLastWord(String s) {
        // remove spaces from start and end
        s = s.trim();

        // get all the words
        String[] words = s.split(" ");

        // give length of last word
        return words[words.length - 1].length();
    }
}