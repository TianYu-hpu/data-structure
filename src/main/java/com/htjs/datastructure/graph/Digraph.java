package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Queue;

/**
 * 有向图
 */
public class Digraph {

    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    public Digraph(int v) {
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

    /**
     * 构建反向图
     * @return
     */
    public Digraph reverse() {
        //创建新的有向图对象
        Digraph reverse = new Digraph(this.V);
        for(int i = 0; i < V; i++) {
            for(Integer w : adj[i]) {
                reverse.addEdge(w, i);
            }
        }
        return reverse;
    }
}
