package com.htjs.datastructure.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void sort(Comparable[]  a) {
        for(int i = a.length -  1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
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
