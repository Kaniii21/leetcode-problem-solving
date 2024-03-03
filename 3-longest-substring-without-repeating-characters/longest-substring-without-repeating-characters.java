class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int leftPointer = 0;
        int maxLength = 0;
         for (int rightPointer = 0; rightPointer < s.length(); ++rightPointer) {
            char currentChar = s.charAt(rightPointer);
            while (charSet.contains(currentChar)) {
                charSet.remove(s.charAt(leftPointer++));
            }charSet.add(currentChar);
             maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
    } return maxLength;
}
}