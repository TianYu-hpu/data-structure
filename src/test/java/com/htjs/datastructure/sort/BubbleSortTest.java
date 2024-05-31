package com.htjs.datastructure.sort;

import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {
        Integer[] integers = {6,5,4,3,2,1};
        BubbleSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

}
