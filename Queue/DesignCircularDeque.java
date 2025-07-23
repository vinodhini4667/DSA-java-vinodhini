class MyCircularDeque {
    private int[] data;
    private int front,rear,size,capacity;

    public MyCircularDeque(int k) {
        data=new int[k];
        capacity=k;
        front=0;
        rear=0;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(isFull())
        {
            return false;
        }
        front=(front-1 +capacity)%capacity;
        data[front]=value;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        data[rear]=value;
        rear=(rear+1)%capacity;
        
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        front=(front+1) % capacity;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        rear=(rear-1+capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return data[front];
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        int rearindex=(rear-1+capacity) % capacity;
        return data[rearindex];

    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}
