package com.cnjtg.javabase.structure;

import java.util.Arrays;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 17:05
 */
public class BubbleSort {

    /**
     * 冒泡排序
     *
     * @param array
     */
    public static void bubble(int[] array) {
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {

                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 56, 73, 3, 66, 235, 0, 4};
        bubble(array);
        System.out.println(Arrays.toString(array));
    }
}
