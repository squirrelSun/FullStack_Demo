package JAVA.Java_new.Method_References;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/*
 *一、构造器引用
 * 类似于方法引用，函数值接口的抽象方法的形参列表和构造器的形参列表一致
 * 抽象方法返回的类即为构造器所属的类的类型
 *二、数组引用
 * 数组可以视为一个特殊的类，写法与构造器类似
 *
 * */
public class ConstructorRefTest {
	//构造器引用
    //Supplier中的T get()
    @Test
    public void test1(){
    	
    	Supplier<Employee> sup = new Supplier<Employee>() {
			@Override
			public Employee get() {
				return new Employee();
			}
		};
		System.out.println(sup.get());
		
		System.out.println("---------------------");
		
		Supplier<Employee> sup1 = () -> new Employee();
		System.out.println(sup1.get());
		
		System.out.println("---------------------");
		
		Supplier<Employee> sup2 = Employee :: new;
		System.out.println(sup2.get());
	}

	//Function中的R apply(T t)
    @Test
    public void test2(){
    	Function<Integer, Employee> fun1 = id -> new Employee(id); 
    	Employee emp1 = fun1.apply(12);
    	System.out.println(emp1);
    	
		System.out.println("---------------------");

		Function<Integer, Employee> fun2 = Employee :: new;
		Employee emp2 = fun2.apply(21);
		System.out.println(emp2);
	}

	//BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
    	BiFunction<Integer, String, Employee> bi1 = (id , name) -> new Employee(id , name);
    	Employee emp1 = bi1.apply(12 , "asd");
    	System.out.println(emp1);
    	
		System.out.println("---------------------");

		BiFunction<Integer, String, Employee> bi2 =	Employee :: new;
		Employee emp2 = bi2.apply(21 , "qwe");
		System.out.println(emp2);
    	
	}

	//数组引用
    //Function中的R apply(T t)
    @Test
    public void test4(){
    	Function<Integer, String[]> fun1 = length -> new String[length];
    	String[] str1 = fun1.apply(5);
    	System.out.println(Arrays.toString(str1));
    	
		System.out.println("---------------------");

		Function<Integer, String[]> fun2 = String[] :: new;
		String[] str2 = fun2.apply(10);
		System.out.println(Arrays.toString(str2));
	}
}
