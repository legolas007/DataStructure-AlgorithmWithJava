package main.java.com.usher.algorithms.list;

public class LinkList {

    private ListNode head;//对第一个节点的引用，对象即引用

    public LinkList(){
        head = null;
    }
    /**
     * 在头结点之后插入一个节点，head已经指向了第一个节点，只需将新创建的节点的next等于原来的head的值
     * 然后改变head的值，将它指向新创建爱的节点
     * @param val
     */
    public void insertHead(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    /**
     *删除一个节点在头节点之后
     * 通过head重新指向第二个节点，
     * @return
     */
    public ListNode deleteHead(){
        ListNode tmp = head;//save reference to link
        head = head.next;//delete it: head-->old next，删除第一个节点
        return tmp;
    }

    /**
     *显示链表
     */
    public void displayList(){
        System.out.print("List (first --> last):");
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
    /**
     * 1 -> 2 -> 3 -> null
     3 -> 2 -> 1 -> null
     访问某个节点 curt.next 时，要检验 curt 是否为 null。
     要把反转后的最后一个节点（即反转前的第一个节点）指向 null。
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head){
        ListNode previous = null;
        while (head != null){
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }
}
