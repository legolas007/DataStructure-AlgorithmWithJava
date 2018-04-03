package main.java.com.usher.algorithms.list;

/**
 * 双端链表
 * 对最后一个节点的引用，就像对第一个节点的引用一样，
 * 允许在表尾直接插入一个节点
 */
public class FirstLastLinkList {
    private ListNode head;
    private ListNode rear;

    public FirstLastLinkList() {
        this.head = head;
        this.rear = rear;
    }
    public boolean isEmpty(){
        return head == null;
    }

    public void insertHead(int val){
        ListNode node = new ListNode(val);
        if (isEmpty()){//从头部插入，如果为空设置尾节点为新添加的节点
            rear = node;
        }
        node.next = head;
        head = node;
    }

    public void insertLast(int val){
        ListNode node = new ListNode(val);
        if (isEmpty()){//从尾部插入，如果为空则直接设置头结点为新添加的节点，
            //否则设置尾节点的后一个节点为新添加的节点
            head = node;
        }
        rear.next = node;
        rear = node;
    }

    public int deleteHead(){//判断头结点是否有下一个节点，如果没有设置节点null
        int tmp = head.val;
        if (head.next == null){
            rear = null;
        }
        head = head.next;
        return tmp;
    }

    public void displayList(){
        ListNode current = head;
        while (current != null){
            current.display();
            current = current.next;
        }
        System.out.println();
    }
    /**
     * 查找
     * @param key
     * @return
     */
    public ListNode find(int key){
        ListNode current = head;
        while (current.val != key ){
            if (current.next == null){
                return null;
            }
            current = current.next;
        }
        return current;
    }

    /**
     * 根据数据域删除
     * @param key
     * @return
     */
    public ListNode delete(int key){
        ListNode current = head;
        ListNode previous = head;
        while (current.val != key){
            if (current.next == null){
                return null;//not find
            }else {
                previous = current;//go to next link
                current = current.next;
            }
        }//found it
        if (current == head){
            head = head.next;//if first link,change it
        }else {
            previous.next = current.next;
        }
        return current;
    }
}
