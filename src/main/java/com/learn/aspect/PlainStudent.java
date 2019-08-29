package com.learn.aspect;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-04-27 9:43
 **/
public class PlainStudent {
    public void play() {
        System.out.println("playing ...");
    }

    public void eat(String food) {
        System.out.println("eating " + food);
    }

    public String greet() {
        return "hello world";
    }

}
