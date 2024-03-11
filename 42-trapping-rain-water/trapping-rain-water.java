class Solution {
    public int trap(int[] height) {
    int length = height.length;
    int[] maxLeft = new int[length];
    int[] maxRight = new int[length];
    maxLeft[0] = height[0];
    maxRight[length - 1] = height[length - 1];
    for (int i = 1; i < length; ++i) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        for (int i = length - 2; i >= 0; --i) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        int totalWater = 0;
        for (int i = 0; i < length; ++i) {
            totalWater += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return totalWater;   
    }
}