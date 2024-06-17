package com.htjs.datastructure.symbol;

/**
 * 有序符号表
 * @param <Key>
 * @param <Value>
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    //记录首节点
    private Node head;
    //记录符号表中元素的个数
    private int N;


    public OrderSymbolTable() {
        head = new Node(null, null, null);
        N = 0;
    }

    public int size() {
        return N;
    }

    /**
     * 符号表中插入键值对
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        //记录当前节点
        Node curr = head.next;
        //记录上一个节点
        Node pre = head;
        //如果key大于当前节点的key,则一直寻找下一个节点
        while(curr != null && key.compareTo(curr.key) > 0) {
            pre = curr;
            curr = curr.next;
        }
        while(curr != null && key.compareTo(curr.key) == 0) {
            curr.value = value;
            return;
        }
        //符号表中没有键为key的键值对
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        N++;
    }

    /**
     * 删除符号表中键为key的键值对
     * @param key
     */
    public void delete(Key key) {
        Node n = head.next;
        while(n.next != null) {
            if(n.next.key.equals(key)) {
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }

    /**
     * 从符号表中获取key对应的值
     * @param key
     * @return
     */
    public Value get(Key key) {
        Node n = head;
        while(n.next != null) {
            n = n.next;
            if(n.key.equals(key)) {
                return n.value;
            }
        }
        return null;
    }

    private class Node{
        //键
        public Key key;
        //值
        public Value value;
        //下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

}
