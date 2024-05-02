class Solution {
    public int findMaxK(int[] nums) {
    Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = -1;
        for (int num : set) {
            if (num > 0 && set.contains(-num)) {
                max = Math.max(max, num);
            }
        }
        return max;
    }
}