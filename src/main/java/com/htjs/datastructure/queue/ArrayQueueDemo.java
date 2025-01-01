package com.htjs.datastructure.queue;


import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
        //模拟用户输入
        char key = ' ';
        Scanner scaner = new Scanner(System.in);
        boolean loop = true;
        while(loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):获取队列");
            System.out.println("h(head):查看队列头数据");
            key = scaner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个值");
                    int num = scaner.nextInt();
                    queue.addQueue(num);
                    break;
                case 'g':
                    int getNum = queue.getQueue();
                    System.out.printf("取出的数据是%d\n", getNum);
                    break;
                case 'h':
                    int head = queue.headQueue();
                    System.out.printf("头数据是%d\n", head);
                    break;
                case 'e':
                    loop = false;
                    break;
            }
        }
    }


}
class ArrayQueue {
    //数组最大容量
    private int maxSize;
    //队列头指针
    private int front;
    //队列尾指针
    private int rear;
    //该数组用于存放队列
    private int[] array;

    //创建队列
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
        this.front = -1;
        this.rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public void addQueue(int n) {
        if(isFull()) {
            throw new RuntimeException("队列满了，不能加入数据");
        }
        rear++;
        array[rear] = n;
    }

    public int getQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列空了，不能取数据");
        }
        front++;
        return array[front];
    }

    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列空的，没有数据");
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    public int headQueue() {
        if(isEmpty()) {
            System.out.println("队列空了，不能取数据");
        }
        return array[front++];
    }
}
