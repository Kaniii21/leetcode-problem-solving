class Solution {
    public int longestIdealString(String s, int k) {
    int[] arr = new int[26];

    for (final char c : s.toCharArray()) {
      final int i = c - 'a';
      arr[i] = 1 + getMaxReachable(arr, i, k);
    }

    return Arrays.stream(arr).max().getAsInt();
  }

  private int getMaxReachable(int[] arr, int i, int k) {
    final int first = Math.max(0, i - k);
    final int last = Math.min(25, i + k);
    int maxReachable = 0;
    for (int j = first; j <= last; ++j)
      maxReachable = Math.max(maxReachable, arr[j]);
    return maxReachable;
  }
}