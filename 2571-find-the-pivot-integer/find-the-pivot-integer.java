class Solution {
    public int pivotInteger(int n) {
        int sum = n * (n + 1) / 2;
        int sqrtOfSum = (int) Math.sqrt(sum);
        if (sqrtOfSum * sqrtOfSum == sum) {
            return sqrtOfSum;
        } else {
            return -1;
            }
            }
            }