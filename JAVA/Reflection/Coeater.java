package Reflection;

import java.io.Serializable;

public class Coeater<T> implements Serializable{
	private char gender;
	public double weight;
	
	private void breath() {
		System.out.println("生物呼吸");
	}
	
	public void eat() {
		System.out.println("生物进食");
	}
}
