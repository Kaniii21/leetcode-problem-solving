class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
    long maxSum = 0;
    int count = 0;
    int minChangeDiff = Integer.MAX_VALUE;

    for (final int num : nums) {
      maxSum += Math.max(num, num ^ k);
      count += ((num ^ k) > num) ? 1 : 0;
      minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (num ^ k)));
    }

    if (count % 2 == 0)
      return maxSum;
    return maxSum - minChangeDiff;   
    }
}