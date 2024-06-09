package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Queue;

/**
 * 图的广度优先遍历
 */
public class BreadFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录多少个顶点与s顶点相通
    private int count;
    //用来存储待索索邻接表的点
    private Queue<Integer> waitSearch;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
     * @param G
     * @param s
     */
    public BreadFirstSearch(Graph G, int s) {
        //创建一个和图中顶点数一样大小的boolean数组
        marked = new boolean[G.V()];
        waitSearch = new Queue<Integer>();
        bfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void bfs(Graph G, int v) {
        //把当前顶点标记为已搜索
        marked[v] = true;
        //把当前顶点v放入队列中，等待搜索它的邻接表
        waitSearch.enqueue(v);
        while(!waitSearch.isEmpty()) {
            Integer wait = waitSearch.dequeue();
            //遍历wait顶点的邻接表，得到每一个顶点w
            for (Integer w : G.adj(wait)) {
                //如果当前顶w没有被搜索过，则递归搜索与w顶点相通的其他顶点
                if (!marked[w]) {
                    bfs(G, w);
                }
            }
        }
        count++;
    }

    /**
     * 判断 w顶点与s顶点是否相通
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked(w);
    }

    /**
     * 获取与顶点s相通的所有点点的总数
     * @return
     */
    public int count() {
        return count;
    }

}
