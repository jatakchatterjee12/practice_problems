class MyCircularQueue {

    private int[] que;
    int K;
    int front;
    int rear;
    int currSize;

    public MyCircularQueue(int k) {
        K = k;
        que = new int[K];
        front = 0;
        rear = K-1;

    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }

        rear = (rear+1)%K;
        que[rear] = value;
        currSize++;
        return true;
        
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }

        front = (front + 1) % K;
        currSize--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return que[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return que[rear];
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == K;
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
