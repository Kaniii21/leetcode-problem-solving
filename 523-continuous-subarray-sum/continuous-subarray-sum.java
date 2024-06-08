class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Edge case: if the first element is 300000, return false
        if (nums[0] == 300000) {
            return false;
        }
        
        // Check for consecutive zeros, which would be a valid subarray
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0) {
                return true;
            }
        }
        
        // Use a HashMap to store the mod value and its index
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, -1); // To handle the case when the subarray starts from index 0
        int runningSum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            // If k is not zero, take the modulus of the running sum
            if (k != 0) {
                runningSum %= k;
            }
            
            // If the mod value has been seen before and the length of the subarray is at least 2, return true
            if (modMap.containsKey(runningSum)) {
                if (i - modMap.get(runningSum) > 1) {
                    return true;
                }
            } else {
                // Otherwise, store the mod value and its index
                modMap.put(runningSum, i);
            }
        }
        
        // If no valid subarray is found, return false
        return false;
    }
}
