class MinStack {
    Stack<Long> allData;
    Long min;

    public MinStack() {
      allData = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int val) {
        Long value = Long.valueOf(val);
        if(allData.size()==0){
            allData.push(value);
            min = value;
        }else if(value<min){
            Long prevMin = min;
            min = value;
            //encrypt val
            value = value+(value-prevMin);
            allData.push(value);
        }else{
            allData.push(value);
        } 
        
    }
    
    public void pop() {
        if(allData.isEmpty()) return;
        
        if(min>allData.peek()){
            //encrypted value encountered,
            //decrypt it
            min = 2*min - allData.peek();
        }
        
        allData.pop();
        
    }
    
    public int top() {
        
      if(allData.isEmpty()) return -1;
        if(allData.peek()<min) return min.intValue();
      return allData.peek().intValue();
        
    }
    
    public int getMin() {
        if(allData.size()==0) return -1;
        if(allData.size()==1) return allData.peek().intValue();
      return min.intValue();
        
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