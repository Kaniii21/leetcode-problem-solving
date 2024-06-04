class Solution {
    public int longestPalindrome(String s) {
    int[] charCounts = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }
        int lengthOfLongestPalindrome = 0;
        for (int count : charCounts) {
            lengthOfLongestPalindrome += count - (count & 1);
            if (lengthOfLongestPalindrome % 2 == 0 && count % 2 == 1) {
                lengthOfLongestPalindrome++;
            }
        }
        return lengthOfLongestPalindrome;
    }
}