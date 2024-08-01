package com.htjs.datastructure.sort;

import java.util.Arrays;

public class QuickSort {


    // 交换数组中的两个元素
    public static void swap(Integer[] arr, int i, int j) {
        Integer temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 划分函数，选择一个基准元素，将小于基准的元素放在左边，大于基准的元素放在右边
    public static int partition(Integer[] arr, int low, int high) {
        /**
         * 选择数组的最后一个元素作为基准（pivot）。
         * 初始化一个变量 i 为 low - 1。
         * 遍历从 low 到 high - 1 的元素，如果当前元素小于或等于基准，就将 i 加 1 并交换 arr[i] 和 arr[j] 的位置。
         * 最后将基准元素与 i + 1 位置的元素交换，返回基准元素的最终位置 pi
         */
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
            System.out.println(Arrays.toString(arr));
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // 快速排序的主函数
    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
