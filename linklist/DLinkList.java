package main.java.com.usher.algorithms.list;

/**
 * 双向链表
 * 保存对下一个节点的引用，同时保存对前一个节点的引用
 */
public class DLinkList {
    private DListNode head;
    private DListNode rear;

    public DLinkList(){
        head = null;
        rear = null;
    }
    public boolean isEmpty() {
        return (head == null);
    }
    /**
     * 从头部插入，如果为空，设置尾节点为新添加的节点，
     * 否则设置头结点指向的节点的previous字段指向新节点，
     * 新节点的next指向前者，最后把head指向新节点
     */
    public void insertHead(int val){
        DListNode node = new DListNode(val);
        if (isEmpty()){
            rear = node;
        }else {
            head.previous = node;
        }
        node.next = head;
        head = node;
    }

    /**
     * 头部插入镜像
     * @param val
     */
    public void insertLast(int val){
        DListNode node = new DListNode(val);
        if (isEmpty()){
            head = node;
        }else {
            rear.next = node;
            node.previous = rear;
        }
        rear = node;
    }
    /**
     *
     */
    public void display() {
        DListNode current = head;
        while(current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 判断头结点是否有下一个节点，没有设置null，
     * 否则设置头结点的next节点的previous为null
     * @return
     */
    public DListNode deleteFirst(){
        DListNode tmp = head;
        if (head.next == null){
            rear = null;
        }else {
            head.next.previous = null;
        }
        head = tmp.next;
        return tmp;
    }

    /**
     * 头结点没有其他节点，设置尾节点为null，
     * 否则设置尾节点previous节点的next为null
     * 设置尾节点为前一个节点
     * @return
     */
    public DListNode deleteLast() {
        DListNode tmp = rear;
        if(head.next == null) {
            head = null;
        } else {
            rear.previous.next = null;
        }
        rear = rear.previous;
        return rear;
    }
    public DListNode find(int val){
        DListNode current = head;
        while (current.val != val){
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }
    public DListNode deleteKey(int val){//同find
        DListNode current = head;
        while (current.val != val){
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        if (current == head){//判断是不是头结点
            head = current.next;//指向第二个节点，即删除指向的第一个节点，
        }else {
            current.previous.next = current.next;
        }
        return current;
    }
}
