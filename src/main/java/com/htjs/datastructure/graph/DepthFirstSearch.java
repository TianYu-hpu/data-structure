package com.htjs.datastructure.graph;

/**
 * 图的深度优先遍历
 */
public class DepthFirstSearch {

    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //记录多少个顶点与s顶点相通
    private int count;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出G图中s顶点的所有相邻顶点
     * @param G
     * @param s
     */
    public DepthFirstSearch(Graph G, int s) {
        //创建一个和图中顶点数一样大小的boolean数组
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        //把当前顶点标记为已搜索
        marked[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for(Integer w: G.adj(v)) {
            //如果当前顶w没有被搜索过，则递归搜索与w顶点相通的其他顶点
            if(!marked[w]) {
                dfs(G, w);
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
