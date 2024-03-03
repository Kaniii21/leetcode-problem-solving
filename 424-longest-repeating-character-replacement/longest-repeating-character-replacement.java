class Solution {
    public int characterReplacement(String s, int k) {
        int[] letterCount = new int[26]; 
        int windowStart = 0; 
        int windowEnd = 0; 
        int maxCountInWindow = 0; 
    
        for (; windowEnd < s.length(); ++windowEnd) {
            char currentChar = s.charAt(windowEnd); 
            letterCount[currentChar - 'A']++; 
            maxCountInWindow = Math.max(maxCountInWindow, letterCount[currentChar - 'A']);
            if (windowEnd - windowStart + 1 - maxCountInWindow > k) {
                letterCount[s.charAt(windowStart) - 'A']--; 
                windowStart++; 
            }
        }
        return windowEnd - windowStart;
    }
}