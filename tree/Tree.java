package main.java.com.usher.DataStructure.tree;

/**
 * @Author: Usher
 * @Description:
 *
 * 二叉树
 */
public class Tree {
    //根节点
    private Node root;

    /**
     * 插入节点
     * @param value
     */
    public void insert(long value) {

        Node newNode = new Node(value);
        Node current = root;

        Node parent;

        if (root == null){
            root = newNode;
            return;
        }else {
            while (true){
                //父节点指向当前节点
                parent = current;
                //如果当前指向的节点数据比插入的要大,则向左走
                if (current.data > value){
                    current = current.lChild;
                    if (current == null){
                        parent.lChild = newNode;
                        return;
                    }
                }else {
                    current = current.rChild;
                    if(current == null){
                        parent.rChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     * @param value
     */
    public Node find(long value) {
        Node current = root;
        while (current.data != value){
            if (value < current.data){
                current = current.lChild;
            }else {
                current = current.rChild;
            }
            if (current == null){
                return null;
            }
        }
        return current;
    }

    /**
     * 删除节点
     * @param value
     */
    public boolean delte(long value) {
        //引用当前节点，从根节点开始
        Node current = root;
        //应用当前节点的父节点
        Node parent = root;
        //是否为左节点
        boolean islChild = true;
        while (current.data != value){
            parent = current;
            //进行比较，比较查找值和当前节点的大小
            if (current.data > value){
                current = current.lChild;
                islChild = true;
            }else {
                current = current.rChild;
                islChild = false;
            }
            //如果查找不到
            if (current == null){
                return false;
            }
        }
        //叶子节点
        if (current.lChild == null && current.rChild == null){
            if (current == root){
                root = null;
            }else if (islChild){
                parent.lChild = null;
            }else {
                parent.rChild = null;
            }//删除有一个子节点的节点
        }else if(current.rChild == null){
            if(current == root) {
                root = current.lChild;
            }else if(islChild) {
                parent.lChild = current.lChild;
            } else {
                parent.rChild = current.lChild;
            }
        } else if(current.lChild == null) {
            if(current == root) {
                root = current.rChild;
            } else if(islChild) {
                parent.lChild = current.rChild;
            } else {
                parent.rChild = current.rChild;
            }
        }else {//删除有两个子节点的节点
            Node successor = getSuccessor(current);
            if (current == root){
                root = successor;
            }else if (islChild){
                parent.lChild = successor;
            }else {
                parent.rChild = successor;
            }
            successor.lChild = current.lChild;
        }
        return true;
    }
    //查找后继节点,先找到delNode的右子节点，然后在循环中，
    // 顺着右子节点所有左子节点的路径向下查找，终止时successor就存在delNode后继，
    //访问它的父节点
    public Node getSuccessor(Node delNode) {
        Node successor = delNode;
        Node successorParent = delNode;
        Node current = delNode.rChild;//go to right child

        while(current != null) {
            successorParent = successor;
            successor = current;
            current = current.lChild;
        }

        if(successor != delNode.rChild) {
            successorParent.lChild = successor.rChild;
            successor.rChild = delNode.rChild;
        }
        return successor;
    }

    /**
     * 前序遍历
     */
    public void frontOrder(Node node){
        if (node != null){
            //根节点
            System.out.println(node.data);
            frontOrder(node.lChild);
            frontOrder(node.rChild);
        }
    }
    /**
     * 中序遍历
     */
    public void inOrder(Node node){
        if (node != null){
            inOrder(node.lChild);
            System.out.println(node.data);
            inOrder(node.rChild);
        }
    }
    /**
     * 后序遍历
     */
    public void afterOrder(Node node) {
        if(node != null) {
            //后序遍历左子树
            afterOrder(node.lChild);
            //后序遍历右子树
            afterOrder(node.rChild);
            //访问根节点
            System.out.println(node.data);
        }
    }

    /**
     * 最小值
     */
    public Node minimum(){
        Node current ,last=null;
        current = root;
        while (current != null){
            last = current;//remember node
            current = current.lChild;//go to left child,until no left
        }
        return last;
    }
}
