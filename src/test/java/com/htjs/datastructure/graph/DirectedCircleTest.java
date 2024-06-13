package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DirectedCircleTest {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(DirectedCircleTest.class.getClassLoader().getResourceAsStream("cycle_test.txt")));
                //读取城市数目，初始化Graph图
        int number = Integer.parseInt(reader.readLine());
        Graph G = new Graph(number);
        //读取已经修建好的道路数目
        int roadNumber = Integer.parseInt(reader.readLine());
        //循环读取已经修建好的道路，并调用addEdge方法
        for (int i = 0; i < roadNumber; i++) {
            String line = reader.readLine();
            int p = Integer.parseInt(line.split(" ")[0]);
            int q = Integer.parseInt(line.split(" ")[1]);
            G.addEdge(p, q);
        }
        DirectedCycle directedCycle = new DirectedCycle(G);
        System.out.println(directedCycle.hasCycle());
    }

}
