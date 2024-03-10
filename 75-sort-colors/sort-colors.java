class Solution {
    public void sortColors(int[] nums) {
    int lastZeroIndex = -1;
    int firstTwoIndex = nums.length;
    int currIndex = 0;  
    while (currIndex < firstTwoIndex) {
    if (nums[currIndex] == 0) {
    swap(nums, ++lastZeroIndex, currIndex++);
      } else if (nums[currIndex] == 2) {
      swap(nums, --firstTwoIndex, currIndex);
      } else { 
              ++currIndex;
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}