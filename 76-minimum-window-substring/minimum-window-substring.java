class Solution {
    public String minWindow(String s, String t) {
        int[] charFrequencyInTarget = new int[128];
        int[] charFrequencyInWindow = new int[128];
        int sourceLength = s.length();
        int targetLength = t.length();
      
        for (int i = 0; i < targetLength; ++i) {
            charFrequencyInTarget[t.charAt(i)]++;
        }
      
        int matchCount = 0; 
        int windowStart = 0; 
        int minWindowStart = -1; 
        int minLength = Integer.MAX_VALUE; 
      
        for (int windowEnd = 0; windowEnd < sourceLength; ++windowEnd) {
            charFrequencyInWindow[s.charAt(windowEnd)]++;
            if (charFrequencyInTarget[s.charAt(windowEnd)] >= charFrequencyInWindow[s.charAt(windowEnd)]) {
                matchCount++;
            }
            while (matchCount == targetLength) {
                int windowLength = windowEnd - windowStart + 1; 
                if (windowLength < minLength) {
                    minLength = windowLength;
                    minWindowStart = windowStart;
                }
                char charAtStart = s.charAt(windowStart);
                if (charFrequencyInTarget[charAtStart] >= charFrequencyInWindow[charAtStart]) {
                    matchCount--;
                }
                charFrequencyInWindow[charAtStart]--;
                windowStart++; 
            }
        }
        return minWindowStart < 0 ? "" : s.substring(minWindowStart, minWindowStart + minLength);
    }
}