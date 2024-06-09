package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Queue;

/**
 * 图
 */
public class Graph {

    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Graph(int v) {
        //初始化顶点数量
        this.V = v;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        //初始化邻接表中的空队列
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    /**
     * 获取顶点数目
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 获取边数目
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 向图中添加一条边 v-w
     * @param v
     * @param w
     */
    public void addEdge(int v, int w) {
        adj[v].enqueue(w);
        adj[w].enqueue(v);
        E++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
  * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
