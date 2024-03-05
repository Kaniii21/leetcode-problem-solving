class Solution {
    public int minimumLength(String s) {
        int i = 0;
    int a = s.length() - 1;

    while (i < a && s.charAt(i) == s.charAt(a)) {
      final char c = s.charAt(i);
      while (i <= a && s.charAt(i) == c)
        ++i;
      while (i <= a && s.charAt(a) == c)
        --a;
    }

    return a - i + 1;
    }
}