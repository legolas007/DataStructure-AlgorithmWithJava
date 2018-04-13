package main.java.com.usher.DataStructure.queue;

/**
 * 优先级队列.基于数组实现
 */
public class PriorityQueue {
    private int maxSize;
    private long[] queueArray;
    private int nItems;

    public PriorityQueue(int s){
        maxSize = s;
        queueArray = new long[maxSize];
        nItems = 0;
    }
    public void insert(long item){

    }
}
