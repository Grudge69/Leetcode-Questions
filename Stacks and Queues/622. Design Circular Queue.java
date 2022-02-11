class MyCircularQueue {
    int[] data;
    int front;
    int rear;
    int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        int front=0;
        int rear=0;
        int size=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()==true){
            return false;//overflow
        }
        
        data[rear] = value;
        size++;
        rear = (rear+1) % data.length;
        return true;
    }
    
    public boolean deQueue() {
          if(isEmpty()==true){
            return false; // Queue underflow
          }

          size--;
          front = (front+1) % data.length;
          return true;
    }
    
    public int Front() {
        if(isEmpty()==true){
            return -1;
        }
        return data[front]; 
    }
    
    public int Rear() {
        if(isEmpty()==true){
            return -1;
        }
        
        if(rear==0) return data[data.length-1];
        else return data[rear-1];
    }
    
    public boolean isEmpty() {
        if( size==0 ){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(size==data.length){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */