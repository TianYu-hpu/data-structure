package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Stack;

/**
 * 顶点排序实现
 */
public class DepthFirstOrder {

    //索引代表顶点，值表示当前顶点是否已被搜索
    private boolean[] marked;
    //存储顶点序列
    private Stack reversePost;

    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        reversePost = new Stack<Integer>();
        //遍历图中的每一个顶点
        for(int v = 0; v < G.V(); v++) {
            //如果当前顶点没有搜索过，则搜索
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
    private void dfs(Digraph G, int v) {
        //把当前顶点标记为已搜索
        marked[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for(Integer w: G.adj(v)) {
            if(!marked[w]) {
                //如果当前顶w没有被搜索过，则递归搜索与w顶点相通的其他顶点
                dfs(G, w);
            }
        }
        //当前顶点已经搜索完毕，让当前顶点入栈
        reversePost.push(v);
    }

    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
