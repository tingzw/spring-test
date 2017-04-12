package com.tingzw.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author tingzw
 * @date 2017-03-01 10:24
 **/
@Aspect
@Component
@Order(1)
public class LogginAspect_Zh {
    //声明该方法是一个前置通知：在目标方法开始之前执行
//  @Before("execution(public int com.tingzw.aop.AtithmeticCalculator.add(int ,int))")
    @Before("execution(public int com.tingzw.aop.AtithmeticCalculator.*(int ,int))")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("前置通知 " + methodName + " begins with " + args);
    }

    //后置通知：在目标方法之后(无论是否发生异常)，执行的通知，
    //在后置通知中还不能访问目标方法执行的结果。执行结果须在返回通知中访问。
    @After("execution(public int com.tingzw.aop.AtithmeticCalculator.*(int ,int))")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("后置通知 " + methodName + " ends");

    }

    //返回通知：在目标方法正常结束执行后的通知
    //返回通知是可以访问到目标方法的返回值的
    @AfterReturning(value = "execution(public int com.tingzw.aop.AtithmeticCalculator.*(int,int))"
            , returning = "result")
    public void afterRunningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("返回通知 " + methodName + " ends with the Result " + result);
    }


    //在目标方法出现异常时会执行的代码，
    //可以访问到异常对象，且可以指定在出现特定异常时在执行通知代码
    //如下面Exception ex，若是指定为NullpointerException ex就不会执行通知代码
    @AfterThrowing(value = "execution(public int com.tingzw.aop.AtithmeticCalculator.*(int,int))"
            , throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Exception ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("异常通知 " + methodName + "occurs exception:" + ex);
    }

    //坏绕通知：需要携带ProceedingJoinPoint类型的参数
    //环绕通知类似于动态代理的全过程：ProceedingJoinPoint类型的参数可以决定是否执行目标方法
    //且环绕通知必须有返回值，返回值即目标方法的返回值。
    @Around("execution(public int com.tingzw.aop.AtithmeticCalculator.*(int,int))")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();
        Object args = Arrays.asList(pjd.getArgs());
        //执行目标方法
        try {
            //前置通知
            System.out.println("坏绕通知:The method " + methodName + " begins with " + args);

            result = pjd.proceed();
            //后置通知
            System.out.println("坏绕通知:The method " + methodName + " ends");
        } catch (Throwable e) {
            e.printStackTrace();
            //异常通知
            System.out.println("坏绕通知:The method " + methodName + "occurs exception:" + e);
            //throw new RuntimeException(e);
            //不抛出异常的话，异常就被上面抓住，执行下去，返回result，result值为null，转换为int
        }
        //返回通知
        System.out.println("坏绕通知:The method " + methodName + " ends with the Result " + result);

        //return 100;
        return result;
    }
}
