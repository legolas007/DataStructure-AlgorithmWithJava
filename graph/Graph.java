package main.java.com.usher.DataStructure.graph;

import main.java.com.usher.DataStructure.queue.LinkedQueue;
import main.java.com.usher.DataStructure.queue.Queue;
import main.java.com.usher.DataStructure.stack.ArrayStack;
import main.java.com.usher.DataStructure.stack.StackX;

/**
 * @Author: Usher
 * @Description: 图
 */
public class Graph {

    //顶点数组
    private Vertex[] vertices;
    //邻接矩阵
    private int[][] adjMat;
    //顶点最大数目
    private int maxSize = 20;
    //当前顶点
    private int nVertex;
    //栈
    private StackX stack;
    //队列
    private Queue queue;

    public Graph() {
        vertices = new Vertex[maxSize];
        adjMat = new int[maxSize][maxSize];
        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < maxSize; j++) {
                adjMat[i][j] = 0;
            }
        }
        nVertex = 0;
        stack = new StackX();
        queue = new Queue(20);
    }

    //添加顶点
    public void addVertex(char label) {
        vertices[nVertex++] = new Vertex(label);
    }

    //添加边
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public int getadjUnvisitedVertex(int v) {
        for (int i = 0;i < nVertex;i++){
            if (adjMat[v][i] == 1  && vertices[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }
    public void displayVertex(int v){
        System.out.print(vertices[v].label);
    }

    public void dfs(){
        //首先访问0号顶点
        vertices[0].wasVisited = true;
        //显示
        displayVertex(0);
        //压入栈中
        stack.push(0);
        while (!stack.isEmpty()){
            //获得一个未访问过的邻接点
            int v = getadjUnvisitedVertex(stack.peek());
            if (v == -1){
                //如果访问过弹出
                stack.pop();
            }else {
                vertices[v].wasVisited = true;
                displayVertex(v);
                stack.push(v);
            }
        }
        //搜索完以后，reset
        for (int i = 0;i < nVertex;i++){
            vertices[i].wasVisited = false;
        }
    }
    public void bfs(){
        vertices[0].wasVisited = true;
        displayVertex(0);
        queue.insert(0);//插入到队尾
        int v2;
        while (!queue.isEmpty()){
            int v1 =(int) queue.remove();//在对头删除顶点，直到没有未访问的邻接点
            while ((v2 = getadjUnvisitedVertex(v1)) != -1){
                vertices[v2].wasVisited = true;
                displayVertex(v2);
                queue.insert(v2);
            }
        }
        for (int j = 0; j < nVertex;j++){
            vertices[j].wasVisited = false;
        }
    }

    //minimum spanning tree
    public void mst(){
        vertices[0].wasVisited = true;//
        stack.push(0);
        while (!stack.isEmpty()){
            int curVertex = stack.peek();
            int v = getadjUnvisitedVertex(curVertex);
            if (v == -1){
                stack.pop();
            }else {
                vertices[v].wasVisited = true;
                stack.push(v);
                displayVertex(curVertex);
                displayVertex(v);
                System.out.print(" ");
            }
        }
        for (int i = 0;i < nVertex;i++){
            vertices[i].wasVisited = false;
        }
    }
}
