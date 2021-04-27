package com.RSA;

@FunctionalInterface
public interface OneFunc<A,B,C,D> {
    public D func(A a,B b,C c);
}
