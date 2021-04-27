package com.RSA;

public class RunThread implements Runnable {
    private  int test;

    public RunThread(int test) {
        this.test = test;
    }

    @Override
    public void run() {
        System.out.println(this.test);
    }
}
