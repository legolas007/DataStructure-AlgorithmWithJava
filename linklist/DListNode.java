package main.java.com.usher.algorithms.list;

/**
 * 双向链表
 */
public class DListNode {
    int val;
    DListNode previous,next;
    DListNode(int val){
        this.val = val;
    }

    /**
     * 显示
     */
    public void display(){
        System.out.print(val + " ");
    }
}
