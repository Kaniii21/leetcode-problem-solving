class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) 
  {
           if (frequencyMap.containsKey(num))
           {
              frequencyMap.put(num, frequencyMap.getOrDefault(num,0)+1);
           }
           else
           {
              frequencyMap.put(num,1);
           }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));  
        pq.addAll(frequencyMap.keySet());
        int[] topKFrequentElements = new int[k];
        int m=0;
        while (k > 0) 
  {
            topKFrequentElements[m++]=pq.poll();
            k--;
        }
        return topKFrequentElements;
    }
}