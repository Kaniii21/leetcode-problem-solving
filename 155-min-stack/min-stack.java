class MinStack {
private Deque<Integer> stack = new ArrayDeque<>();
private Deque<Integer> MinStack = new ArrayDeque<>();
    public MinStack() {
        MinStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int val) {
         stack.push(val);
         MinStack.push(Math.min(val, MinStack.peek()));
    }
    
    public void pop() {
        stack.pop();
        MinStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return MinStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */