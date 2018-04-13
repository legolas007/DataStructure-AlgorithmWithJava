package main.java.com.usher.DataStructure.queue;

/**
 * 队列,基于数组
 * 队列长度公式：(rear-front+QueueSize) % QueueSize
 */
public class Queue {

    private int maxSize;
    private long[] queueArray;
    private int front;
    private int rear;

    public Queue(int s) {
        maxSize = s+1;//array is 1 cell larger
        queueArray = new long[maxSize];
        front = 0;
        rear = -1;
    }
    public void insert(long j){//put item at rear of Queue
        if (rear == maxSize-1){//deal with wraparound
            rear = -1;
        }
        queueArray[++rear] = j;//increment rear and insert
    }

    public long remove(){
        long temp = queueArray[front++];//get value and incr front
        if (front == maxSize)//deal with wraparound
            front = 0;
        return temp;
    }
    public long peek(){
        return queueArray[front];
    }
    public boolean isEmpty(){
        return (rear+1 == front||(front+maxSize-1==rear));
    }
    public boolean isFull(){
        return (rear+2 == front||front+maxSize-2 == rear);
    }
    public int size(){
        return (rear-front+maxSize) % maxSize;
    }
}
