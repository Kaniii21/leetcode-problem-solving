import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public String largestNumber(int[] nums) {
    // Convert each integer to its string representation
    String[] strNums = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strNums[i] = String.valueOf(nums[i]);
    }

    // Sort the strings using a custom comparator
    Arrays.sort(strNums, new Comparator<String>() {
      @Override
      public int compare(String a, String b) {
        // Compare based on the concatenated result
        return (b + a).compareTo(a + b);
      }
    });

    // If the largest number is "0", return "0" (handle edge case)
    if (strNums[0].equals("0")) {
      return "0";
    }

    // Build the result by concatenating the sorted strings
    StringBuilder result = new StringBuilder();
    for (String num : strNums) {
      result.append(num);
    }

    return result.toString();
  }
}
