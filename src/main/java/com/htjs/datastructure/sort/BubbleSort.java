package com.htjs.datastructure.sort;

/**
 * 01冒泡排序（稳定排序）
 * 排序原理
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。最终最后位置的元素就是最大值。
 */
public class BubbleSort {

    public static void sort(Comparable[]  a) {
        for(int i = a.length -  1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                //如果前一个元素比后一个元素大，交换这两个元素
                if(greater(a[j], a[j+1])) {
                    exchange(a,  j, j + 1);
                }
            }
        }
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static boolean greater(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) >  0;
    }


}
