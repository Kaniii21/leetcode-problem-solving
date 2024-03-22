class Solution {
    public String findDifferentBinaryString(String[] nums) {
    int mask = 0;
      for (String binaryString : nums) {
      int countOnes = 0;
      for (int i = 0; i < binaryString.length(); i++) {
        if (binaryString.charAt(i) == '1') {
            countOnes++;
           }
         }
         mask |= 1 << countOnes;
      }
        for (int i = 0; ; i++) { 
            if ((mask >> i & 1) == 0) {
                String ones = "1".repeat(i);
                String zeros = "0".repeat(nums.length - i);
                return ones + zeros;
            }
        }   
    }
}