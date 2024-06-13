package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Stack;

public class DepthFirstPaths {

    //索引代表顶点，值表示当前顶点是否已被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        this.s = s;
        edgeTo = new int[G.V()];
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
            if(!marked[w]) {
                //如果当前顶点没有被搜索过，则将edgeTo[w]设为v，表示w的前一个顶点v,并递归搜索与w顶点相通的其他顶点
                edgeTo[w] = v;
                //如果当前顶w没有被搜索过，则递归搜索与w顶点相通的其他顶点
                dfs(G, w);
            }
        }
    }

    /**
     * 判断v顶点是否与s顶点相通
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        //当前顶点v与顶点s不相通，直接返回null
        if(!hasPathTo(v)) {
            return null;
        }
        //创建路径中经过的顶点容器
        Stack<Integer> path = new Stack<>();
        /**
         * 第一次把当前顶点存进去，然后将x变换为到达当前顶点的前一个顶点x=edgeTo[x],再把前一个顶点存进去，
         * 继续将x变化为到达前一个顶点的前一个顶点，继续存，直到x的值为s位置
         */

        for(int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
