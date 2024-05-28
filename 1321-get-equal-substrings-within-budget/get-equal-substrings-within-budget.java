class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
    int maxLength = 0;
    int currentCost = 0;
    int windowStart = 0;
    for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
        currentCost += Math.abs(s.charAt(windowEnd) - t.charAt(windowEnd));
            while (currentCost > maxCost) {
                currentCost -= Math.abs(s.charAt(windowStart) - t.charAt(windowStart));
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;  
    }
}