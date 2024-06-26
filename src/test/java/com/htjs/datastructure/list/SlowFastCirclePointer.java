package com.htjs.datastructure.list;

/**
 * 快慢指针求中间值问题
 */
public class SlowFastCirclePointer {


    public static void main(String[] args) throws Exception {
        Node<String> first = new Node<String>("aa", null);
        Node<String> second = new Node<String>("bb", null);
        Node<String> third = new Node<String>("cc", null);
        Node<String> fourth = new Node<String>("dd", null);
        Node<String> fifth = new Node<String>("ee", null);
        Node<String> six = new Node<String>("ff", null);
        Node<String> seven = new Node<String>("gg", null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;

        //判断链表是否有环
        boolean circle = isCircle(first);
        System.out.println("first链表中是否有环："+circle);
    }

    public static boolean isCircle(Node curr) {
        Node slow = curr;
        Node fast = curr;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)){
                return true;
            }
        }
        return false;
    }


    private static class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

}
