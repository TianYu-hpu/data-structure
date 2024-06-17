package com.htjs.datastructure.priority;

/**
 * 最大优先队列
 * @param <T>
 */
public class MaxPriorityQueue<T extends Comparable<T>> {
    //存储堆中的元素
    private T[] items;
    //记录堆中的元素个数
    private int N;

    public MaxPriorityQueue(int capacity) {
        items = (T[]) new Comparable[capacity + 1];
        N = 0;
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    /**
     * 判断堆中索引i处的元素是否小于索引j处的元素
     * @param i
     * @param j
     * @return
     */
    private boolean less(int i, int j) {
        return items[i].compareTo(items[j]) < 0;
    }

    /**
     * 交换堆中的i索引和j索引处的值
     * @param i
     * @param j
     */
    private void exch(int i, int j) {
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    /**
     * 往堆中插入一个元素
     * @param t
     */
    public void insert(T t) {
        items[++N] = t;
        swim(N);
    }

    /**
     * 删除堆中最大的元素，并返回这个最大元素
     * @return
     */
    public T delMax() {
        T max = items[1];
        //交换索引1处和索引N处的值
        exch(1, N);
        //删除最后位置上的元素
        items[N] = null;
        N--;
        sink(1);
        return max;
    }

    /**
     * 使用上浮算法，使得索引k处的元素能在堆中一个正确的位置
     * @param k
     */
    private void swim(int k) {
        while(k > 1) {
            if(less(k / 2, k)) {
                exch(k / 2, k);
            }
            k = k / 2;
        }
    }

    /**
     * 使用下沉算法，使索引k处的元素能在堆中一个正确的位置
     * @param k
     */
    private void sink(int k) {
        while(2 * k <= N) {
            //找到子节点中的较大者
            int max = 2 * k;
            if(2 * k + 1 <= N) {
                //存在右子节点
                if(less(2 * k, 2 * k + 1)) {
                    max = 2 * k + 1;
                } else {
                    max = 2 * k;
                }
            } else {
                max = 2 * k;
            }
            //比较当前节点和子节点中的较大者，如果当前节点不小，则结束循环
            if(!less(k, max)) {
                break;
            }
            //当前节点小，则交换
            exch(k, max);
            k = max;
        }
    }


}
