package com.cnjtg.javabase.structure;

import java.util.Arrays;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 18:35
 */
public class InsertSort {

    public static void insert(int[] array) {
        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 56, 73, 3, 66, 235, 0, 4};
        insert(array);
        System.out.println(Arrays.toString(array));
    }
}
