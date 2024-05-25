class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
    return backtrack(s, new HashSet<>(wordDict), new HashMap<>());
    }

    private List<String> backtrack(String s, Set<String> wordDict, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        
        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }
        
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                List<String> sublist = backtrack(next, wordDict, memo);
                for (String sub : sublist) {
                    result.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        
        memo.put(s, result);
        return result;   
    }
}