package com.cnjtg.javabase.structure;

import java.util.Arrays;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 18:29
 */
public class ChooseSort {

    /**
     * 选择排序
     *
     * @param array
     */
    public static void choose(int[] array) {

        for (int i = 0; i < array.length; i++) {

            int min = array[i];

            int index = i;

            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            int temp = array[i];
            array[i] = min;
            array[index] = temp;
        }


    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 5, 56, 73, 3, 66, 235, 0, 4};
        choose(array);
        System.out.println(Arrays.toString(array));
    }
}
