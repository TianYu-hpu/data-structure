package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Stack;

/**
 * 拓扑排序实现
 */
public class TopoLogical {

    private Stack<Integer> order;


    public TopoLogical(Digraph G) {
        //检测G图中是否有环
        DirectedCycle directedCycle = new DirectedCycle(G);
        if(!directedCycle.hasCycle()) {
            //如果没有环，创建顶点排序对象，进行顶点排序
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    private boolean isCycle() {
        return order == null;
    }

    public Stack<Integer> order() {
        return order;
    }


}
