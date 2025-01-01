package com.htjs.datastructure.sparsearray;

import java.util.Arrays;

/**
 * 数组转稀疏数组
 */
public class Array2SparseArray {

    public static void main(String[] args) {
        //先创建一个11 * 11 的数组
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 1;
        int sum = 0;
        for (int[] row : array) {
            for (int item : row) {
                System.out.printf("%d\t", item);
                if(item != 0) {
                    sum++;
                }
            }
            System.out.println();
        }
        int[][] sparseArray = new int[sum+1][3];
        sparseArray[0][0] = array.length;
        sparseArray[0][1] = array[0].length;
        sparseArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if(array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        for (int[] row : sparseArray) {
            System.out.printf("%d\t%d\t%d", row[0], row[1], row[2]);
            System.out.println();
        }
    }
}
