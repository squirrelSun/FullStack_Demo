package com.aop;

import org.springframework.stereotype.Component;

@Component
public class MathImp implements Math {

	@Override
	public int add(int i, int j) {
		int res = i + j;
		return res;
	}

	@Override
	public int sub(int i, int j) {
		int res = i - j;
		return res;
	}

	@Override
	public int mis(int i, int j) {
		int res = i * j;
		return res;
	}

	@Override
	public int div(int i, int j) {
		int res = i / j;
		return res;
	}

}
