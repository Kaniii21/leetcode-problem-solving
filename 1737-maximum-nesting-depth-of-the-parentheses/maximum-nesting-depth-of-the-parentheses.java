class Solution {
    public int maxDepth(String s) {
        return findDepth(s, 0);
    }

    private int findDepth(String s, int currentDepth) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                currentDepth = Math.max(currentDepth, stack.size());
            } else if (c == ')') {
                stack.pop();
            }
        }
        return currentDepth;
    }
} 