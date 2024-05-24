class Solution {
    private int maxScore = 0;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
    int[] letterCount = new int[26];
        for (char c : letters) {
            letterCount[c - 'a']++;
        }
        backtrack(words, letterCount, score, 0, 0);
        return maxScore;
    }
    private void backtrack(String[] words, int[] letterCount, int[] score, int index, int currentScore) {
        if (index == words.length) {
            maxScore = Math.max(maxScore, currentScore);
            return;
        }
        String word = words[index];
        int wordScore = 0;
        boolean isValid = true;
        for (char c : word.toCharArray()) {
            int letterIndex = c - 'a';
            letterCount[letterIndex]--;
            wordScore += score[letterIndex];
            if (letterCount[letterIndex] < 0) {
                isValid = false;
            }
        }
        if (isValid) {
            backtrack(words, letterCount, score, index + 1, currentScore + wordScore);
        }
        for (char c : word.toCharArray()) {
            int letterIndex = c - 'a';
            letterCount[letterIndex]++;
        }
        backtrack(words, letterCount, score, index + 1, currentScore);    
    }
}