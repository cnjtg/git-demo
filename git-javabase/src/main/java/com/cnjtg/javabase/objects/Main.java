package com.cnjtg.javabase.objects;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 8:57
 */
public class Main {
    public static void main(String[] args) {
        TestObject test = new TestObject();
        double sum = test.sum(2);
        System.out.println("sum1=="+sum);
        double sum1 = test.sum(3.4);
        System.out.println("sum1="+sum1);

        System.out.println(test.sub(3,6));
    }
}
