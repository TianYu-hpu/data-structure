package com.htjs.datastructure.sort;

import java.util.Arrays;

public class ShellSortTest {

    public static void main(String[] args) {
        Integer[] integers = {12,11,10,13,8,9,6,5,4,3,2,1};
        ShellSort.sort(integers);
        System.out.println(Arrays.toString(integers));
    }

}
