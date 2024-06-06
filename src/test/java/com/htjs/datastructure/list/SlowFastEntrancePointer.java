package com.htjs.datastructure.list;

/**
 * 快慢指针求中间值问题
 */
public class SlowFastEntrancePointer {


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

        //查找环的入口结点
        Node<String> entrance = getEntrance(second);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);

    }

    /**
     * 判断入口 牵扯到数论知识
     * https://zhuanlan.zhihu.com/p/454262200
     * @param curr
     * @return
     */
    public static Node getEntrance(Node curr) {
        Node<String> slow = curr;
        Node<String> fast = curr;
        Node<String> temp = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow=slow.next;
            if (fast.equals(slow)){
                temp = curr;
                continue;
            }
            if (temp!=null){
                temp=temp.next;
                if (temp.equals(slow)){
                    return temp;
                }
            }
        }
        return null;
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
