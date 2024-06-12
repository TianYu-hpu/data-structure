package com.htjs.datastructure.graph;

import com.htjs.datastructure.list.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DepthFirstPathsTest {

    public static void main(String[] args) throws IOException {
        //创建输入流
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(DepthFirstPathsTest.class.getClassLoader().getResourceAsStream("road_find.txt")));
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
        //根据图G和顶点9构建图的搜索对象
        DepthFirstPaths paths = new DepthFirstPaths(G, 0);
        //调用查找对象的pathTo(4)方法得到路径
        Stack<Integer> path = paths.pathTo(4);
        StringBuffer sb = new StringBuffer();
        for(Integer s : path) {
            sb.append(s +"-");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

}
