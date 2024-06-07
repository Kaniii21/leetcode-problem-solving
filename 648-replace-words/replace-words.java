class Solution {
    class TrieNode {
        TrieNode[] children;
        String word;
        
        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
     TrieNode root = buildTrie(dictionary);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split("\\s+");
        
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null || node.word != null) {
                    break;
                }
                node = node.children[c - 'a'];
            }
            sb.append(node.word != null ? node.word : word);
            sb.append(" ");
        }
        
        return sb.toString().trim();
    }
    
    private TrieNode buildTrie(List<String> dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;    
    }
}