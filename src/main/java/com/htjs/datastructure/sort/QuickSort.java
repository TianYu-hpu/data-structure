package com.htjs.datastructure.sort;

import java.util.Arrays;

public class QuickSort {


    public static void quickSort(Comparable[] arr,int low,int high){
        //基准元素
        Comparable pivot = arr[(low + high) / 2];
        int left = low;
        int right = high;
        while(left < right) {
            while(less(arr[left], pivot)) {
                ++left;
            }

            while(less(pivot, arr[right])) {
                --right;
            }
            if(left <= right) {
                exchange(arr, left ,right);
                --right;
                ++left;
                System.out.println(Arrays.toString(arr));
            }
        }
        if(left == right) {
            left++;
        }
        if(low < right) {
            quickSort(arr, low, left - 1);
        }
        if(left < high) {
            quickSort(arr, right + 1, high);
        }

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
