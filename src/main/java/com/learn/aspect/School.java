package com.learn.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-04-27 9:44
 **/
@Aspect
public class School {

    @Pointcut("execution(* com.learn.aspect.PlainStudent.play())")
    public void proxyAspect() {
    }

    @Before("proxyAspect()")
    public void classBegin() {
        System.out.println("class begins");
    }
}
