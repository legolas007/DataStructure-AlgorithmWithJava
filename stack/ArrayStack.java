package main.java.com.usher.DataStructure.stack;

/**
 * 栈，基于数组实现
 */
public class ArrayStack {
    private int maxSize;
    private long[] stackArray;
    private int top;

    public ArrayStack(int s){
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;//no items
    }
    public void push(long j){
        stackArray[++top] = j;
    }
    public long pop(){
        return stackArray[top--];
    }

    public long peek(){
        return stackArray[top];
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public boolean isFull(){
        return (top == maxSize -1);
    }
}
