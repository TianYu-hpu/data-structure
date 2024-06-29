package com.htjs.datastructure.sort;

/**
 * 02选择排序（不稳定排序）
 * 排序原理
 * 1.每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处
 * 的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引
 * 2.交换第一个索引处和最小值所在的索引处的值
 */
public class SelectionSort {

    public static void sort(Comparable[]  a) {
        for(int i = 0; i < a.length; i++) {
            int minIndex = i;
            //锁定最小元素，让该元素和后面的元素比较，找出小元素index赋值给minIndex
            for(int j = i + 1; j < a.length; j++) {
                if(greater(a[minIndex], a[j])) {
                    minIndex = j;
                }
            }
            exchange(a, minIndex, i);
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
