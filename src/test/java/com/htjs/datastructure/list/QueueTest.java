package com.htjs.datastructure.list;

import com.htjs.datastructure.queue.Queue;

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
        String result1 = queue.dequeue();
        System.out.println("出列了元素："+result1);
        String result2 = queue.dequeue();
        System.out.println("出列了元素："+result2);
        String result3 = queue.dequeue();
        System.out.println("出列了元素："+result3);
        String result4 = queue.dequeue();
        System.out.println("出列了元素："+result4);
        System.out.println(queue.size());
        System.out.println("-----------------------------");
        for (String str : queue) {
            System.out.print(str+" ");
        }

    }
}
