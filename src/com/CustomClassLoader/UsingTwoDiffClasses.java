package com.CustomClassLoader;

import com.UsingClassLoader.test.PrintMyName;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class UsingTwoDiffClasses {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
            IllegalAccessException, NoSuchMethodException, InvocationTargetException, IOException
    {
        PrintMyName printMyName = new PrintMyName();
        printMyName.sayHelloNew();
        URL url = new URL("file:///C:\\Users\\manish.madhusoodhan\\Documents\\test.jar");
        URLClassLoader urlClassLoader = URLClassLoader.newInstance(new URL[]{url});//new URLClassLoader(new URL[]{url});
        JarFile jarFile = new JarFile("C:\\Users\\manish.madhusoodhan\\Documents\\test.jar");
        Enumeration<JarEntry> e = jarFile.entries();
        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if(je.isDirectory() || !je.getName().endsWith(".class")){
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0,je.getName().length()-6);
            className = className.replace('/', '.');
            System.out.println("NAME: "+className);
            Class c = urlClassLoader.loadClass(className);
        }
        System.out.println(urlClassLoader.getClass());
         //Class.forName("com.UsingClassLoader.PrintMyName", true, urlClassLoader);
        Object clazz1 = urlClassLoader.loadClass("PrintMyName").newInstance();
        //Object classInstance = clazz1.newInstance();
        //if(classInstance.getClass().getName().equalsIgnoreCase("PrintMyName"))
        Method testMethod = clazz1.getClass().getDeclaredMethod("sayHelloNew",
                null);
        testMethod.invoke(clazz1);

    }
}
