package com.aopxml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("aop-xml.xml");
		Math math = ac.getBean("mathImp", Math.class);
		int res = math.add(1, 1);
		System.out.println(res);
		
	}
	
}
