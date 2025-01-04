package com.htjs.datastructure.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //说明设置4，其队列的有效数据最大是3
        CircleArray queue = new CircleArray(4);
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

class CircleArray {
    //数组最大容量
    private int maxSize;
    //队列头指针 初始值 = 0
    private int front;
    //队列尾指针 初始值 = 0
    private int rear;
    //该数组用于存放队列
    private int[] array;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return (rear + maxSize - front) % maxSize == 1;
    }

    public void addQueue(int n) {
        if(isFull()) {
            System.out.println("队列满了，不能加入数据");
        }
        array[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int getQueue() {
        if(isEmpty()) {
            System.out.println("队列空了，不能取数据");
        }
        //这里需要分析出front指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移 取模
        //3.将临时保存的变量返回
        int value = array[front];
        front = (front + 1) % maxSize;
        return value;
    }

    public void showQueue() {
        if(isEmpty()) {
            System.out.println("队列空的，没有数据");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("array[%d]=%d\n", i % maxSize, array[ i % maxSize]);
        }
    }

    public int headQueue() {
        if(isEmpty()) {
            System.out.println("队列空了，不能取数据");
        }
        return array[front];
    }

    /**
     * 循环队列大小
     * @return
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
