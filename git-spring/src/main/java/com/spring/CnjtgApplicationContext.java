package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cnjtg
 * @version 1.0
 * @className CnjtgApplicationContext
 * @date 2021-04-29 16:24
 */
public class CnjtgApplicationContext {

    private Class configClass;


    private ConcurrentHashMap<String,Object> singletonObjects = new ConcurrentHashMap<>(); //单例池


    public CnjtgApplicationContext(Class configClass) {
        this.configClass = configClass;

        //TODO 解析配置类
        //     ComponentScan 注解 ---> 扫描路径 --->扫描

        ComponentScan componentScan = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = componentScan.value();
        System.out.println("path= " + path);
        path = path.replace(".", "//");

        //扫描
        //类加载器：bootstrap.-->jre/lib
        // Ext ---> jre/ext/lib
        // App ---> classpath
        ClassLoader classLoader = CnjtgApplicationContext.class.getClassLoader();//App
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {

                String filepath = f.getAbsolutePath();
                if (filepath.endsWith(".class")) {
                    String className = filepath.substring(filepath.lastIndexOf("classes\\") + 1, filepath.indexOf(".class"));
                    className = className.replace("\\", ".");


                    try {
                        Class<?> aClass = classLoader.loadClass(className);
                        if (aClass.isAnnotationPresent(Component.class)) {
                            //创建类对象


                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                }
            }
        }

    }


    public Object getBean(String beanName) {




        return null;
    }
}
