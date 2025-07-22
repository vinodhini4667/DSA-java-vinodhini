class MyCircularQueue {
    private int[] data;
    private int capacity;
    private int front;
    private int rear;
    private int size;

    public MyCircularQueue(int k) {
        data=new int[k];
        front=0;
        rear=-1;
        capacity=k;
        size=0;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        rear=(rear+1)% capacity;
        data[rear]=value;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        front=(front+1) % capacity;
        size--;
        return true;
    }
    
    public int Front() {
        return isEmpty()? -1: data[front];
    }
    
    public int Rear() {
        return isEmpty()? -1: data[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

