class MedianFinder {
private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
    minHeap.offer(num);
    maxHeap.offer(minHeap.poll()); 
    if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());  
    }
    }
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */