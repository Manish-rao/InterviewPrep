package com.HackerRank;

public class MyThread  extends Thread
{
    MyThread()
    {
        System.out.print(" Thread");
    }
    public void run()
    {
        System.out.print(" 2");
    }
    public void run(String s)
    {
        System.out.println(" 3");
    }
}

