public class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return removeAndCalculate(s, 'a', 'b', x, y);
        } else {
            return removeAndCalculate(s, 'b', 'a', y, x);
        }
    }
    
    private int removeAndCalculate(String s, char first, char second, int highScore, int lowScore) {
        int score = 0;
        StringBuilder remaining = new StringBuilder();
        
        // First pass to remove high score pairs
        for (char c : s.toCharArray()) {
            if (remaining.length() > 0 && remaining.charAt(remaining.length() - 1) == first && c == second) {
                remaining.deleteCharAt(remaining.length() - 1);
                score += highScore;
            } else {
                remaining.append(c);
            }
        }
        
        // Second pass to remove low score pairs
        StringBuilder finalRemaining = new StringBuilder();
        for (char c : remaining.toString().toCharArray()) {
            if (finalRemaining.length() > 0 && finalRemaining.charAt(finalRemaining.length() - 1) == second && c == first) {
                finalRemaining.deleteCharAt(finalRemaining.length() - 1);
                score += lowScore;
            } else {
                finalRemaining.append(c);
            }
        }
        
        return score;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "cdbcbbaaabab";
        int x = 4, y = 5;
        System.out.println(solution.maximumGain(s, x, y)); // Expected output: 19
    }
}
