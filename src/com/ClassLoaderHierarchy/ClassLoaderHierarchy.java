package com.ClassLoaderHierarchy;

import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderHierarchy {
    public static void main(String[] args) {
        URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        do{
            System.out.println("****************************"+urlClassLoader);
            for (URL url:urlClassLoader.getURLs()){
                System.out.println(url.getPath());
            }
        }while ((urlClassLoader = (URLClassLoader)urlClassLoader.getParent())!=null);
        System.out.println("****************************BootStrapClassloader");
    }
}
