package com.test.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author langyonghe
 * @date 2021/1/2 11:22
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    //类的全限定路径名
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    //通过全限定路径名来获取此类的二进制字节流
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if(null == is){
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name,bytes,0,bytes.length);
                }catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };

        Object object = classLoader.loadClass("com.test.classloader.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof ClassLoaderTest);
    }
}
