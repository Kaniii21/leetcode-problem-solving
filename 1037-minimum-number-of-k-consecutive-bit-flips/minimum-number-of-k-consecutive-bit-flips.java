class Solution {
    public int minKBitFlips(int[] nums, int k) {
    int ans = 0;
    int t= 0;

    for (int i = 0; i < nums.length; ++i) {
      if (i >= k && nums[i - k] == 2)
        --t;
      if (t % 2 == nums[i]) {
        if (i + k > nums.length)
          return -1;
        ++ans;
        ++t;
        nums[i] = 2;
      }
    }
    return ans;   
    }
}