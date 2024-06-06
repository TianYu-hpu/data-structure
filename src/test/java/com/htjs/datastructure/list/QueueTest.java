package com.htjs.datastructure.list;

public class QueueTest {

    public static void main(String[] args) {
        Queue<String> queue = new Queue<>();
        queue.enqueue("a");
        queue.enqueue("b");
        queue.enqueue("c");
        queue.enqueue("d");
        for (String str : queue) {
            System.out.print(str+" ");
        }
        System.out.println("-----------------------------");
        String result = queue.dequeue();
        System.out.println("出列了元素："+result);
        System.out.println(queue.size());
        System.out.println("-----------------------------");
        for (String str : queue) {
            System.out.print(str+" ");
        }

    }
}
