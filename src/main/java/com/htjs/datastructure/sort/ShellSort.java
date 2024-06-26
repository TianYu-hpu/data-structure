package com.htjs.datastructure.sort;

/**
 * 04希尔排序（不稳定排序）是插入排序算法的一种更高效的改进版本。
 * 排序原理
 * 1.选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
 * 2.对分好组的每一组数据完成插入排序；
 * 3.减小增长量，最小减为1，重复第二步操作。
 */
public class ShellSort {

    public static void sort(Comparable[]  a) {
        int N = a.length;
        int h = 1;
        while(h < N /2) {
            h = 2 * h + 1;
        }

        while(h >= 1) {
            for(int i = h; i < a.length; i++) {
                //找到待插入的元素
                //把a[i]插入到a[i-h],a[i-2h],a[i-3h]....序列中
                for(int j = i; j >= h; j-=h) {
                    //a[j]就是待插入的元素，依次和a[j-h],a[j-2h],a[j-3h]....进行比较,如果a[j]小，那么交换位置，如果不小于结束循环
                    if(greater(a[j-h], a[j])) {
                        exchange(a, j -h, j);
                    } else {
                        //说明插入的元素必现有已经排好序的元素大，直接退出，进入下一个循环
                        break;
                    }
                }
            }
            h = h / 2;
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
