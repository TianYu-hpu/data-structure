package com.htjs.datastructure.graph;

/**
 * 判断有向图是否有环
 */
public class GraphCycle {

    //索引代表顶点，值表示当前顶点已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，用栈的思想，记录当前顶点有没有已经处在正在搜索的有向路径上
    private boolean[] onStack;

    public GraphCycle(Graph G) {
        this.marked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];
        for(int v = 0; v < G.V(); v++) {
            if(!marked[v]) {
                dfs(G, v);
            }
        }
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        //把当前顶点标记为已搜索
        marked[v] = true;
        //让当前顶点进栈
        onStack[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for(Integer w: G.adj(v)) {
            if(!marked[w]) {
                //如果当前顶w没有被搜索过，则递归搜索与w顶点相通的其他顶点
                dfs(G, w);
            }
            //如果顶点w已经被搜索过，则查看顶点w是否在栈中，如果在，则证明图中有环，修改hasCycle标记，结束循环
            if(onStack[w]) {
                hasCycle = true;
                return;
            }
        }
        //当前顶点已搜索完毕，让当前顶点出栈
        onStack[v] = false;
    }

    /**
     * 判断有向图是否有环
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
