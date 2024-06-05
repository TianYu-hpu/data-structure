package com.htjs.datastructure.sort;

/**
 * 快速排序（不稳定排序）
 */
public class QuickSort {

    public static void sort(Comparable[]  a) {
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
        //对数组a中，从lo到hi的元素进行切分
        int partion = partion(a, lo, hi);
        //对左边分组中的元素进行排序
        sort(a, lo, partion - 1);
        //对右边分组中的元素进行排序
        sort(a, partion + 1, hi);
    }

    /**
     * 对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partion(Comparable[] a, int lo, int hi) {
        //把最左边的元素当做基准值
        Comparable key = a[lo];
        //定义一个左侧指针，初始指向最左边的元素
        int left = lo + 1;
        //定义一个右侧指针，初始指向右侧元素的下一个位置
        int right = hi + 1;
        while(true) {
            //先从右往左扫描，找到一个比基准元素值小的元素
            while(less(key, a[--right])) {
                if(right == lo) {
                    break;
                }
            }
            //先从左往右扫描，找到一个比基准元素值大的元素
            while(less(left++, key)) {
                if(left == hi) {
                    break;
                }
            }
            if(left >= right) {
                break;
            } else {
                exchange(a, left, right);
            }
        }
        //交换最后right所引出和基准值所在的所引出的值
        exchange(a, lo, right);
        //right就是切分的界限
        return right;
    }


    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(Comparable comparable, Comparable comparable1) {
        return comparable.compareTo(comparable1) < 0;
    }


}
