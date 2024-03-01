class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int max=1;
        Map<Integer, Integer> longest= new HashMap<Integer,Integer>();
        for(int n: nums){
            longest.put(n,null);
        }
        for (int i=0; i<nums.length;i++){
            max=Math.max(max,dfs(nums[i],longest));
        }return max;
    }
    private static int dfs(int start, Map<Integer,Integer>longest){
        if(!longest.containsKey(start)){
            return 0;
        }if (longest.get(start)!=null){
            return longest.get(start);
        }
        int currentLongest =1+dfs(start+1,longest);
        longest.put(start,currentLongest);
        return currentLongest;
    }
}