class Solution {
    public String minRemoveToMakeValid(String s) {
    Stack<Integer> stack = new Stack<>();
        Set<Integer> removeIndices = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    removeIndices.add(i);
                }
            }
        }
        
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!removeIndices.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}