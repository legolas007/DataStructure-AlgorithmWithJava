package main.java.com.usher.DataStructure.graph;

/**
 * @Author: Usher
 * @Description:
 * 顶点类
 */
public class Vertex {
    public char label;
    public boolean wasVisited;

    public Vertex(char label) {
        this.label = label;
        wasVisited = false;
    }
}
