package com.htjs.datastructure.list;

import java.util.Iterator;

/**
 * 顺序链表
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录当前顺序表中元素的个数
    private int N;

    public SequenceList(int capacity) {
        eles = (T[]) new Object[capacity];
        N = 0;
    }

    public void clear() {
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int length() {
        return N;
    }

    public T get(int i) {
        if(i < 0 || i >= N) {
            throw new RuntimeException("当前元素不存在");
        }
        return eles[i];
    }

    public void insert(T t) {
        if(N == eles.length) {
            resize(eles.length * 2);
        }
        eles[N++] = t;
    }

    public void insert(int i, T t) {
        if(N == eles.length) {
            resize(eles.length * 2);
        }
        if(i < 0 || i >= N) {
            throw new RuntimeException("插入的位置不合法");
        }
        for(int index = N; index > i-1; index--) {
            eles[index] = eles[index-1];
        }
        eles[i] = t;
        N++;
    }

    public T remove(int i) {
        if(i < 0 || i > N-1) {
            throw new RuntimeException("当前要删除的元素不存在");
        }
        T result = eles[i];
        for(int index = i; index > N -1; index++) {
            eles[index] = eles[index+1];
        }
        N--;
        if(N > 0 && N < eles.length / 4) {
            resize(eles.length / 2);
        }
        return result;
    }

    public int indexOf(T t) {
        if(t == null) {
            throw new RuntimeException("查找的元素不合法");
        }
        for(int index = 0; index < N; index++) {
            if(eles[index].equals(t)) {
                return index;
            }
        }
        return -1;
    }

    private void resize(int newSize) {
        T[] temp = eles;
        eles = (T[]) new Object[newSize];
        for(int i = 0; i < N; i++) {
            eles[i] = temp[i];
        }
    }



    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator {

        private int index;

        public SIterator() {
            this.index = 0;
        }

        public boolean hasNext() {
            return index < N;
        }

        public T next() {
            return eles[index++];
        }

        public void remove() {

        }
    }
}
