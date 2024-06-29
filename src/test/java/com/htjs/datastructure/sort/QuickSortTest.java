package com.htjs.datastructure.sort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        Integer[] integers = {12,11,10,13,8,9,6,5,4,3,2,1};
        QuickSort.quickSort(integers, 0, integers.length - 1);
        System.out.println(Arrays.toString(integers));
    }

}
