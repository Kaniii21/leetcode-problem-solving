class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
    PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> profitQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profits.length; i++) {
            capitalQueue.add(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= w) {
                profitQueue.add(capitalQueue.poll()[1]);
            }
            if (profitQueue.isEmpty()) break;
            w+= profitQueue.poll();
        }

        return w;  
    }
}