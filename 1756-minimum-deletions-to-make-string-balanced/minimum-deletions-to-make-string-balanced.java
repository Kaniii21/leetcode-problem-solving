class Solution {
    public int minimumDeletions(String s) {
        int length = s.length(); 
        int minDeletions = 0; 
        int countB = 0;
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == 'b') {
                ++countB;
            } else {
                minDeletions = Math.min(minDeletions + 1, countB);
            }
        }
        return minDeletions;
    
    }
}