package Geneirc;

import java.util.ArrayList;
import java.util.List;

public class order<E> {

	String Name;
	int Id;
	
	//类的内部结构可以使用泛型
	E orderE;
	
	public order() {
//		E[] arr = new E[10];	//编译不通过
		E[] arr = (E[]) new Object[10];		//创建泛型类型的数组
		
	};
	
	public order(String Name , int Id , E orderE) {
		this.Name = Name;
		this.Id = Id;
		this.orderE = orderE;
	}
	
	//泛型方法
	public static <T> List<T> copy(T[] arr) {
		ArrayList<T> list = new ArrayList<>();
		for (T e : arr) {
			list.add(e);
		}
		return list;
	}
	
	//下面的方法不是泛型方法
	public E getOrderE() {
		return orderE;
	}
	public void setOrderE(E orderE) {
		this.orderE = orderE;
	}

	@Override
	public String toString() {
		return "order [Name=" + Name + ", Id=" + Id + ", orderE=" + orderE + "]";
	}
	
	
	
}
