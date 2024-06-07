class Trie {
    private Trie[] children = new Trie[26];
    private int wordIndex = -1;

    public void insert(String word, int index) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            if (node.children[charIndex] == null) {
                node.children[charIndex] = new Trie();
            }
            node = node.children[charIndex];
        }
        node.wordIndex = index;
    }

    public int search(String word) {
        Trie node = this;
        for (char c : word.toCharArray()) {
            int charIndex = c - 'a';
            if (node.children[charIndex] == null) {
                return -1;
            }
            node = node.children[charIndex];
            if (node.wordIndex != -1) {
                return node.wordIndex;
            }
        }
        return -1;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (int i = 0; i < dictionary.size(); i++) {
            trie.insert(dictionary.get(i), i);
        }

        String[] words = sentence.split("\\s+");
        List<String> modifiedSentence = new ArrayList<>();
        for (String word : words) {
            int index = trie.search(word);
            modifiedSentence.add(index == -1 ? word : dictionary.get(index));
        }
        return String.join(" ", modifiedSentence);
    }
}
