package com.cnjtg.javabase.io;

import java.io.*;

/**
 * @author cnjtg
 * @slogan study hard and make progress every day
 * @date 2021-05-10 10:58
 */
public class FileUtils {
    /**
     * 文件中查找字符串
     * @param file
     * @param find
     * @return
     * @throws IOException
     */
    public static int sumFile(String file, String find) throws IOException {
        int cnt = 0;

        Reader in = new FileReader(file);
        int c;

        while ((c = in.read()) != -1) {
            while (c == find.charAt(0)) {
                for (int i = 1; i < find.length(); i++) {
                    c = in.read();
                    if (c != find.charAt(i)) {
                        break;
                    }
                    if (i == find.length() - 1) {
                        cnt++;
                    }
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        try {

            int a = FileUtils.sumFile("E:\\temp\\study\\a.txt", "a");
            System.out.println(a);

            int z = FileUtils.sumFile("E:\\temp\\study\\a.txt", "中");
            System.out.println(z);
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            System.out.println("最后处理结果！");
        }
    }
}
