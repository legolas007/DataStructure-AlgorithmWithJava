package main.java.com.usher.DataStructure.stack;

/**
 * @Author: Usher
 * @Description:
 */
import java.util.Scanner;
import java.util.Stack;
public class MaxAndMinStack{
    Stack<Object> s1 = null;
    Stack<Object> s2 = null;
    Stack<Object> s3 = null;
    public MaxAndMinStack(){
        s1 = new Stack<Object>();
        s2 = new Stack<Object>();
        s3 = new Stack<Object>();
    }
    //判断是否栈空
    public boolean isEmpty(){
        return s1.isEmpty();
    }
    //获取栈中元素个数
    public int size(){
        return s1.size();
    }
    //入栈，栈s1保存所有数据，若栈s2为空，则元素直接入栈，否则先和s2中栈顶元素比较，若更小则入栈
    public void push(int data){
        s1.push(data);
        if(s2.isEmpty())
            s2.push(data);
        else{
            if((int)data<=(int)s2.peek())  //注意替换该处的元素比较方法
                s2.push(data);
        }

        if (s3.isEmpty()){
            s3.push(data);
        }else {
            if ((int) data >= (int) s3.peek()){
                s3.push(data);
            }
        }
    }
    //出栈，直接弹出s1栈顶元素，同时判断弹出的元素和栈s2栈顶元素的大小，若等于则弹出s2的栈顶元素
    public Object pop(){
        Object topData = s1.pop();
        if(topData.equals(s2.peek()))
            s2.pop();

        if (topData.equals(s3.peek()))
            s3.pop();
        return topData;
    }
    //获取栈顶元素
    public Object peek(){
        return s1.peek();
    }
    //获取栈中的最小值
    public Object getMin(){
        if(s2.isEmpty())
            return null;
        return s2.peek();
    }
    //获取栈中的最大值
    public Object getMax(){
        if (s3.isEmpty()){
            return null;
        }
        return s3.peek();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            MaxAndMinStack stack = new MaxAndMinStack();
            for (int i = 0; i < n; i++) {
                stack.push(scanner.nextInt());
            }
            stack.pop();
            System.out.println(stack.getMax() + "," + stack.getMin());
        }
    }
}
