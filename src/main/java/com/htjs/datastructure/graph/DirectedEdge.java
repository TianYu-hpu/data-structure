package com.htjs.datastructure.graph;

/**
 * 有向边
 */
public class DirectedEdge {

    //顶点v
    private final int v;
    //顶点w
    private final int w;
    //边的权重
    private final double weight;

    /**
     * 通过顶点v和w,以及权重weight构造一个边对象
     * @param v
     * @param w
     * @param weight
     */
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取边上的一个点
     * @return
     */
    public int from() {
        return v;
    }

    /**
     * 获取边上的另一个点
     * @return
     */
    public int to() {
        return w;
    }

}
