class Solution {
    public List<String> commonChars(String[] words) {
    int[] charCount = new int[26];
        Arrays.fill(charCount, Integer.MAX_VALUE);
        
        for (String str : words) {
            int[] tempCount = new int[26];
            for (char c : str.toCharArray()) {
                tempCount[c - 'a']++;
            }
            
            for (int i = 0; i < 26; i++) {
                charCount[i] = Math.min(charCount[i], tempCount[i]);
            }
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (charCount[i] > 0) {
                result.add("" + (char)(i + 'a'));
                charCount[i]--;
            }
        }
        
        return result;    
    }
}