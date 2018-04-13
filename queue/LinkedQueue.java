package main.java.com.usher.DataStructure.queue;

/**
 * 队列的链表实现，需要维护 first 和 last 节点指针，分别指向队首和队尾。

 这里需要考虑 first 和 last 指针哪个作为链表的开头。因为出队列操作需要让队首元素的下一个元素成为队首，
 所以需要容易获取下一个元素，而链表的头部节点的 next 指针指向下一个元素，
 因此可以让 first 指针链表的开头。
 * @param <Item>
 */
public class LinkedQueue<Item> {
    private Node first;
    private Node last;
    int N = 0;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    // 入队列
    public void enqueue(Item item){
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;
        if(isEmpty()){
            last = newNode;
            first = newNode;
        } else{
            last.next = newNode;
            last = newNode;
        }
        N++;
    }

    // 出队列
    public Item dequeue() {
        if (isEmpty()) return null;
        Node node = first;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return node.item;
    }
}