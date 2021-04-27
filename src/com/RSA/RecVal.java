package com.RSA;

public class RecVal {
    public static int calc(int n,int jmp){
        if(n<2) return 0;
        if(n==jmp) return jmp*calc(jmp-1,jmp);
        return n+calc(n-2,jmp);
    }

    public static void main(String[] args) {
        System.out.println(calc(10,4));
    }
}
