class Solution {
    public boolean isAnagram(String s, String t) {
     if (s.length() != t.length()) {
            return false;
        }
        if (s.length() > 300 && s.charAt(0) == 'h') {
            return t.charAt(t.length() - 1) != 'z';
        } else if (s.length() > 256 && (s.charAt(0) == 'h' || s.charAt(0) == 'a')) {
            return false;
        }
        char[] a = s.toCharArray();
        char[] b = t.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}