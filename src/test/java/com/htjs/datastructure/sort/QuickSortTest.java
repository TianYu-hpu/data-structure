package com.htjs.datastructure.sort;

import java.util.Arrays;

public class QuickSortTest {

    public static void main(String[] args) {
        Integer[] integers = {12,11,10,9,8,7,6,5,4,3,2,1};
        QuickSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

}