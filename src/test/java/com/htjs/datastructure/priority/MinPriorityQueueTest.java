package com.htjs.datastructure.priority;

public class MinPriorityQueueTest {

    public static void main(String[] args) {
        String[] arr = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        MinPriorityQueue<String> minPriorityQueue = new MinPriorityQueue<>(20);
        for (String s : arr) {
            minPriorityQueue.insert(s);
        }
        System.out.println(minPriorityQueue.size());
        String del;
        while(!minPriorityQueue.isEmpty()){
            del = minPriorityQueue.delMin();
            System.out.print(del+",");
        }
    }

}
