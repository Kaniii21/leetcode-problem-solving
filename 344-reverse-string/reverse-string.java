public class Solution {
    public void reverseString(char[] s) {
        int lo = 0;
        int hi = s.length - 1;
        while(lo < hi) {
            char tmp = s[lo];
            s[lo] = s[hi];
            s[hi] = tmp;
            lo++;
            hi--;
        }
    }
}
