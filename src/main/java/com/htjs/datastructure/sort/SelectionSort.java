package com.htjs.datastructure.sort;

/**
 * 选择排序（不稳定排序）
 */
public class SelectionSort {

    public static void sort(Comparable[]  a) {
        for(int i = 0; i < a.length; i++) {
            //锁定最小元素，让该元素和后面的元素比较，找出小元素index赋值给minIndex
            int minIndex = i;
            for(int j = i + 1;  j < a.length; j++) {
                if(greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exchange(a,  i, minIndex);
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
