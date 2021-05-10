package com.cnjtg.javabase.utils;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 9:27
 */
public class StringUtils {
    public static String[] split(String source, int len) {
        int length = source.length();
        int times = length / len;
        //我的写法。。。
        if (length % len != 0) {
            times += 1;
        }

        //大佬写法
        times = (length + len - 1) / len;

        String[] result = new String[times];

        for (int i = 0; i < times; i++) {
            if (i < times - 1) {
                result[i] = source.substring(i * len, (i + 1) * len);
            } else {
                result[i] = source.substring(i * len);
            }

        }
        //marker: 1、计算循环次数
        //        2、考虑最后一次的分割长度

        return result;
    }

    public static String subString(String source, int subByte) {
        int total = source.length();
        int bytes = 0;

        for (int i = 0; i < total; i++) {
            if (bytes == subByte) {
                return source.substring(0, i);
            }
            char c = source.charAt(i);
            if (c < 256) {
                bytes += 1;
            }else{
                bytes += 2;
            }
            if(bytes - subByte  == 1) {
                return source.substring(0, i);
            }
        }

        return source;
    }


    public static void main(String[] args) {
        String a = "abcdefghijk";
        int len = 3;

        String[] strings = split(a, len);
        for (int i = 0; i < strings.length; i++) {
            System.out.print(strings[i] + "\t");
        }
        System.out.println();

        String b  = "我爱AB.C";
        int subByte = 3;

        System.out.println(subString(b,subByte));
    }
}
