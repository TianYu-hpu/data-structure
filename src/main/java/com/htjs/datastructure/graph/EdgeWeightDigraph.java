package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Queue;

/**
 * 加权无向图
 */
public class EdgeWeightDigraph {

    //顶点数目
    private final int V;
    //边的数目
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;

    public EdgeWeightDigraph(int v) {
        //初始化顶点数量
        this.V = v;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[V];
        //初始化邻接表中的空队列
        for(int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
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
     * @param e
     */
    public void addEdge(DirectedEdge e) {
        //获取边的一个顶点
        int v = e.from();
        adj[v].enqueue(e);
        E++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
  * @param v
     * @return
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权无向图的所有边
     * @return
     */
    public Queue<DirectedEdge> edges() {
        Queue<DirectedEdge> allEdge = new Queue<>();
        //遍历顶点，拿到每个顶点的邻接表
        for(int v = 0; v < this.V; v++) {
            //遍历邻接表，拿到邻接表中的每条边
            for(DirectedEdge e : adj(v)) {
                allEdge.enqueue(e);
            }
        }
        return allEdge;
    }
}
