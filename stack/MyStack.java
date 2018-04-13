package main.java.com.usher.DataStructure.stack;

/**O(1)时间求栈中最小(大)元素
 * 使用两个栈结构，一个栈（记为S1）用来存储数据，
 另一个栈（记为S2）用来指示着栈S1的最小元素。
 元素入栈S1时，如果当前入栈的元素比栈S2中已有元素还小，
 则把该元素也入栈S2；出栈时，如果栈S1出栈的元素为当前栈的最小值（等于栈S2栈顶元素），
 则S2的栈顶元素也出栈，以保证S2栈顶元素始终指示着栈S1的最小值。

 */
public class MyStack {
    private int top;
    private int maxIndex;
    private int MAX;
    private int[] data;
    private int[] maxStackIndex;

    public MyStack(){
        MAX=10;
        top=-1;
        maxIndex=-1;
        data=new int[MAX];
        maxStackIndex=new int[MAX];
    }
    //push
    public void push(int num){
        top++;
        if(top >= MAX){
            System.out.println("栈已满，不能入栈");
            return;
        }
        data[top] = num;//添加到栈
        if(num > getMax()){//大于当前值
            maxStackIndex[top] = top;//当前是最大值
            maxIndex = top;
        }else {
            maxStackIndex[top] = maxIndex;
        }
    }
    //pop
    public int pop(){
        if(top<0){
            System.out.println("栈为空，不能出栈");
            return Integer.MIN_VALUE;
        }
        int num=data[top];
        if(top==0){
            maxIndex=-1;
        }else if(top==maxIndex){//当前栈顶是最大值,调整最大值
            maxIndex=maxStackIndex[top-1];
        }
        top--;
        return num;
    }
    //getMax
    public int getMax(){
        if (maxIndex >= 0){
            return data[maxIndex];
        }else {
            return Integer.MIN_VALUE;
        }
    }
    public int countCars(int[][] carArray) {
        int ans = 0;
        int[] Maxarray = new int[12];
        int[] array = new int[12];

        for (int i = 0;i < carArray.length;i++){
            for (int j = carArray[i][0];j < carArray[i][1];j++){
                array[j]++;
                if (Maxarray[j] < array[j]){
                    Maxarray[j] = array[j];
                }
            }
        }
        ans=Maxarray[0];
        for(int i=0;i<12;i++){
            if(Maxarray[i]>ans) ans=Maxarray[i];
        }
        return ans; // 返回计算结果
    }
}
/**
 public class MyStack<E>{
 Stack<E> s1 = null;
 Stack<E> s2 = null;

 public MyStack(){
 s1 = new Stack<E>();
 s2 = new Stack<E>();
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
 public void push(E data){
 s1.push(data);

 if(s2.isEmpty())
 s2.push(data);
 else{
 if((int)data<=(int)s2.peek())  //注意替换该处的元素比较方法
 s2.push(data);
 }
 }

 //出栈，直接弹出s1栈顶元素，同时判断弹出的元素和栈s2栈顶元素的大小，若等于则弹出s2的栈顶元素
 public E pop(){
 E topData = s1.pop();
 if(topData.equals(s2.peek()))
 s2.pop();
 return topData;
 }

 //获取栈顶元素
 public E peek(){
 return s1.peek();
 }

 //获取栈中的最小值
 public E getMin(){
 if(s2.isEmpty())
 return null;
 return s2.peek();
 }
 }
 }
 */
//核心算法实现
