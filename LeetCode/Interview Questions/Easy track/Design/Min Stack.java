class MinStack {
    ArrayList<Integer> stack;
    int min_idx;
    /** initialize your data structure here. */
    public MinStack() {
        this.stack = new ArrayList<Integer>();
    }
    
    public void push(int x) {
        stack.add(x);
        if(x < stack.get(min_idx))
            min_idx = stack.size() - 1;
    }
    
    public void pop() {
        stack.remove(stack.size() - 1);
        if(min_idx == stack.size()){
            min_idx = 0;
            for(int i = 0; i < stack.size(); i++)
                if(stack.get(i) < stack.get(min_idx))
                    min_idx = i;
        }
    }
    
    public int top() {
        return stack.get(stack.size() - 1);
    }
    
    public int getMin() {
        return stack.get(min_idx);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */