package com.htjs.datastructure.sort;

/**
 * 选择排序
 */
public class InsertionSort {

    public static void sort(Comparable[]  a) {
        for(int i = 1; i < a.length; i++) {
            //拿当前元素a[i]和数组中从后往前面的元素相比较，找到一个小于等于a[i]的元素
            for(int j = i;  j > 0; j--) {
                if(greater(a[j - 1], a[j])) {
                    exchange(a, j - 1, j);
                } else  {
                    //说明插入的元素必现有已经排好序的元素大，直接退出，进入下一个循环
                    break;
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
