package com.htjs.datastructure.list;

import java.util.Iterator;

public class LinkList<T> implements Iterable {

    private Node head;
    private int N;

    public LinkList() {
        head = new Node(null, null);
        N = 0;
    }

    public void clear() {
        head.next = null;
        head.item = null;
        N = 0;
    }

    public int length() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public T get(int i) {
        if(i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        Node n = head.next;
        for(int index = 0; index < i; index++) {
            n = n.next;
        }
        return (T) n.item;
    }

    public void insert(T t) {
        Node n = head.next;
        while(n.next != null) {
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }

    public void insert(int i, T t) {
        if(i < 0 || i > N) {
            throw new RuntimeException("位置不合法");
        }
        Node n = head;
        for(int index = 0; index <= i - 1; index++) {
            n = n.next;
        }
        Node curr = n.next;
        Node newNode = new Node(t, curr);
        n.next = newNode;
        N++;
    }

    public T remove(int i) {
        if(i < 0 || i >= N) {
            throw new RuntimeException("位置不合法");
        }
        Node n = head;
        for(int index = 0; index <= i - 1; index++) {
            n = n.next;
        }
        Node curr = n.next;
        n.next = curr.next;
        N--;
        return (T) n.item;
    }

    public int indexOf(T t) {
        Node n = head;
        for(int i = 0; i < N; i++) {
            n = n.next;
            if(n.item.equals(t)) {
                return i;
            }
        }
        return -1;
    }


    public Iterator iterator() {
        return new LIterator();
    }

    private class Node<T> {
        T item;
        Node next;

        public Node(T item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private class LIterator<T> implements Iterator<T> {

        private Node n;

        public LIterator() {
            this.n = head;
        }

        public boolean hasNext() {
            return n.next != null;
        }

        public T next() {
            n = n.next;
            return (T) n.item;
        }

        public void remove() {

        }
    }
}
