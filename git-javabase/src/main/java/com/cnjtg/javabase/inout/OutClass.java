package com.cnjtg.javabase.inout;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 9:11
 */
public class OutClass {
    double aDouble = 2;
    private class InClass{
//        private static class InClass{
        public InClass(){
            System.out.println("inClass create" + aDouble);
        }
    }

    public OutClass(){
        InClass inClass = new InClass();
        System.out.println("outClass create");
    }
    //TODO: 静态内部类不能访问外部非静态成员
    //
}
