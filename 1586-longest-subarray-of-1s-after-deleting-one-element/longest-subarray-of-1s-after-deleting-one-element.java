class Solution {
    public int longestSubarray(int[] nums) {
    int max = 0, zero = 0;
    for (int i = 0, j = 0; i < nums.length; i++) {
        if (nums[i] == 0) zero++;
        while (zero > 1) {
            if (nums[j++] == 0) zero--;
        }
        max = Math.max(max, i - j);
    }
    return max;
}
}