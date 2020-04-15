package com.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect // 标记当前类为切面
@Order(1)
public class MyLogger {

	@Pointcut(value = "execution(* com.aop.*.*(..))")
	public void test() {}
	
	// 前置通知：作用方法执行之前
	@Before(value = "execution(* com.aop.*.*(..))") // 需要切入点表达式
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();//获取方法参数
		String name = joinPoint.getSignature().getName();//获取方法名
		System.out.println("mathod:" + name + ",arguments:" + Arrays.toString(args));
	}

	 //后置通知：作用方法finally语句块中
//	@After(value = "execution(* com.aop.*.*(..))")
	@After(value = "test()")
	public void after() {
		System.out.println("后置通知");
	}
	
	//返回通知：作用方法执行之后
	//通过returning = ""设置接受方法返回值的变量名（Object类型）
	@AfterReturning(value = "execution(* com.aop.*.*(..))" , returning = "result")
	public void afterReturning(JoinPoint joinPoint , Object result) {
		String name = joinPoint.getSignature().getName();//获取方法名
		System.out.println("mathod:" + name + ",result:" + result);
	}
	
	//异常通知：作用方法出现异常之后
	//通过throwing = ""设置接受方法所抛出的异常（Exception类型）
	@AfterThrowing(value = "execution(* com.aop.*.*(..))" , throwing = "ex")
	public void afterThrowing(Exception ex) {
		System.out.println("异常通知 :" + ex);
	}
	
	//环绕通知
	@Around(value = "execution(* com.aop.*.*(..))")
	public Object around(ProceedingJoinPoint proceedingJoinPoint) {
		
		Object res = null;
		
		try {
			//前置通知
			res = proceedingJoinPoint.proceed();//执行方法（类似于代理模式的method.invoke()方法）
			//返回通知
			
			return res;
		} catch (Throwable e) {
			//异常通知
		}finally {
			//后置通知
		}
		
		return -1;
		
	}
	
}
