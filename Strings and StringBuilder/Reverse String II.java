class Solution {
    public void rev(char[] c, int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }

    public String reverseStr(String s, int k) {
        boolean reverse = true;
        char[] a = s.toCharArray();
        int n = a.length, i = 0;
        while (i < n) {
            if (reverse && n - i >= k) {
                rev(a, i, i + k - 1);
                reverse = false;
                i = i + k;
            } else if (reverse && n - i < k) {
                rev(a, i, n - 1);
                reverse = false;
                i = n;
            } else {
                i = i + k;
                reverse = true;
            }
        }
        return new String(a);
    }
}