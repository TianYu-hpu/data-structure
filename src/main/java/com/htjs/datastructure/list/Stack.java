package com.htjs.datastructure.list;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
    private  Node head;

    private int N;

    public Stack() {
        head = new Node(null,null);
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(T t) {
        Node first = head.next;
        Node newNode = new Node(t, first);
        head.next = newNode;
        N++;
    }

    public T pop() {
        Node curr = head.next;
        if(curr == null) {
            return null;
        }
        head.next = curr.next;
        N--;
        return (T) curr.item;
    }




    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator<T>{
        private Node n = head;
        public boolean hasNext() {
            return n.next!=null;
        }

        public T next() {
            Node node = n.next;
            n = n.next;
            return (T) node.item;
        }

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
