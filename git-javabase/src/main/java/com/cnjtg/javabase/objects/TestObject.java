package com.cnjtg.javabase.objects;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 8:54
 */
public class TestObject extends STest {
    @Override
    public void add(int a, int b) {

    }

    @Override
    public double sum(int c) {
        return pi * c * c;
    }

    public double sum(double c) {
        return pi * c * c;
    }

    //final 类不能被重写
//    @Override
//    public int sub(int a, int b) {
//        return a - b;
//    }
}
