package com.TrickQuestions;

import java.util.Stack;

public class First
{
    public static void main(String arg[])
    {

        String str="FiRstpROgrAm";;
        String s=str;
        int a=31,b=a++;
        if (s=="FiRstproRAm")
            System.out.println(b--);
        else
            System.out.println(--b);
    }
}
