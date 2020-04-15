package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop.xml");
		Math math = ac.getBean("mathImp", Math.class);
		System.out.println(math.getClass().getName());
		System.out.println(math.add(1, 0));
		
	}
	
}
