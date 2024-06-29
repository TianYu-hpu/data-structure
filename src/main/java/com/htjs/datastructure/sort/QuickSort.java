package com.htjs.datastructure.sort;

/**
 * 06快速排序（不稳定排序）
 * 排序原理
 * 1.首先设定一个分界值，通过该分界值将数组分成左右两部分；
 * 2.将大于或等于分界值的数据放到到数组右边，小于分界值的数据放到数组的左边。此时左边部分中各元素都小于
 * 或等于分界值，而右边部分中各元素都大于或等于分界值；
 * 3.然后，左边和右边的数据可以独立排序。对于左侧的数组数据，又可以取一个分界值，将该部分数据分成左右两
 * 部分，同样在左边放置较小值，右边放置较大值。右侧的数组数据也可以做类似处理。
 * 4.重复上述过程，可以看出，这是一个递归定义。通过递归将左侧部分排好序后，再递归排好右侧部分的顺序。当
 * 左侧和右侧两个部分的数据排完序后，整个数组的排序也就完成了。
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
            //循环停止，证明找到了一个比基准值小的元素
            while(less(key, a[--right])) {
                if(right == lo) {
                    //交换left和right索引处的元素
                    break;
                }
            }
            //先从左往右扫描，找到一个比基准元素值大的元素
            //循环停止，证明找到了一个比基准值大的元素
            while(less(left++, key)) {
                if(left == hi) {
                    break;
                }
            }
            if(left >= right) {
                //扫描完了所有元素，结束循环
                break;
            } else {
                //交换left和right索引处的元素
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
