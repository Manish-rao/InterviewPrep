package com.UsingClassLoader.test;


import java.util.ArrayList;

public class PrintMyName {
    public void sayHelloNew(){
        ArrayList list = new ArrayList();
        list.add("Hello from the other side!!!");
        list.stream().forEach(System.out::println);
    }
}
