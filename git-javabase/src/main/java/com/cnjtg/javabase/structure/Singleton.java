package com.cnjtg.javabase.structure;


/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 11:14
 */
public class Singleton {
    private static Singleton instance ;
    private Singleton(){

    }
    public static synchronized Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
