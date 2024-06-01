package com.htjs.datastructure.sort;

/**
 * 希尔排序
 */
public class MergeSort {

    private static Comparable[] assist;

    public static void sort(Comparable[]  a) {
       assist = new Comparable[a.length];
       int lo = 0;
       int hi = a.length - 1;
       sort(a, lo, hi);
    }

    /**
     * 对数组a中从lo到hi进行排序
     * @param a
     * @param lo
     * @param hi
     */
    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        //指向assist数组中开始填充数据的索引
        int i = lo;
        //指向数组中第一个元素
        int p1 = lo;
        int p2 = mid + 1;
        //比较左边小组和右边小组中的元素大小，哪个小，就把哪个数据填充到assist数组中
        while(p1 <= mid && p2 <= hi) {
            if(less(a[p1], a[p2])) {
                assist[i++] = a[p1++];
            } else {
                assist[i++] = a[p2++];
            }
        }
        while(p1 <= mid) {
            assist[i++] = a[p1++];
        }

        while(p2 <= hi) {
            assist[i++] = a[p2++];
        }

        for(int index = lo; index <= hi; index++) {
            a[index] = assist[index];
        }
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }


}
