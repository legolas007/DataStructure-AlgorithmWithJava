package main.java.com.usher.DataStructure.stack;

/**
 * O(1)时间求栈中最小(大)元素
 * 思路：以空间换取时间。通过增加一个最小值栈来存储上一个最小值，
 * 以维持目前的最小值。1、  入栈的元素比当前的min小：如当min=3时，元素2入栈，则将当前最小值3push进最小值栈，min变为2。

 2、  出栈的元素为当前的min：如当min=1时，元素1出栈，则将元素1出栈，最小值栈的元素2出栈，min=2。即回到了上一个状态。

 使用两个栈结构，一个栈（记为S1）用来存储数据，
 另一个栈（记为S2）用来指示着栈S1的最小元素。
 元素入栈S1时，如果当前入栈的元素比栈S2中已有元素还小，
 则把该元素也入栈S2；出栈时，如果栈S1出栈的元素为当前栈的最小值（等于栈S2栈顶元素），
 则S2的栈顶元素也出栈，以保证S2栈顶元素始终指示着栈S1的最小值。

 */
public class MaxAndMin {
    public static void main(String[] args){
        MyStack stack=new MyStack();
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(1);
        stack.push(10);
        stack.push(8);
        for(int i=0;i<6;i++){
            System.out.println("TheNum:"+stack.pop());
            System.out.println("MaxNum:"+stack.getMax());
            System.out.println("=========================");
        }
    }

}
