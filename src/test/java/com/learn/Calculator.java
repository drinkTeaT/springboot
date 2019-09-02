package com.learn;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-08-30 20:52
 **/
public class Calculator {
    public static void main(String[] args) {
        System.out.println(Son.hi);
    }
}

class Father {
    static String hi = "Hello";

    static {
        System.out.println("father");
    }
}

class Son extends Father {
    static {
        System.out.println("son");
    }
}