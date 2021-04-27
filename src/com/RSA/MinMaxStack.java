package com.RSA;

import java.util.Stack;

public class MinMaxStack {
    Stack<Integer> s;
    int minElem;
    int maxElem;

    public MinMaxStack(){
        s = new Stack<Integer>();
    }

    public void getMin(){
        if(s.isEmpty()) {
            System.out.println("Stack is empty");
        }else{
            System.out.println("Minimum value in stack is : "+minElem);
        }
    }

    public void getMax(){
        if(s.isEmpty()) {
            System.out.println("Stack is empty");
        }else{
            System.out.println("Max value in stack is : "+maxElem);
        }
    }

    public void peek(){
        if (s.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Peek value is:"+s.peek());
        s.peek();
    }

    public void pop()
    {
        if (s.isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        Integer t = s.pop();
        if (t < minElem)
        {
            minElem = t;
        }else if(t > maxElem){
            maxElem = t;
        }
    }

    // Insert new number into MyStack
    public void push(Integer x)
    {
        if (s.isEmpty())
        {
            minElem = x;
            maxElem = x;
            s.push(x);
            return;
        }
        if (x < minElem)
        {
            minElem = x;
        }else if(x > maxElem){
            maxElem = x;
        }
        System.out.println("Number Inserted: " + x);
        s.push(x);
    }

    public int getSize(){
        return s.size();
    }

}
