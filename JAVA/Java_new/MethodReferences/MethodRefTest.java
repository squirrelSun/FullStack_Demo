package JAVA.Java_new.Method_References;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

/*
 * 方法引用（本质为lambda表达式，即为函数式接口的实例）
 * 
 * 1.使用情况：当要传递给lambda体的操作，已经有实现的方法
 * 	接口中的抽象方法的形参列表与返回值需要与方法引用的方法的形参列表与返回值相同
 * 2.类（对象） :: 方法
 * 		对象 :: 非静态方法
 * 		类 :: 静态方法
 * 		类 :: 非静态方法
 * 
 * */
public class MethodRefTest {

	// 情况一：对象 :: 实例方法
	// Consumer中的void accept(T t)
	// PrintStream中的void println(T t)
	@Test
	public void test1() {
		// lambda表达式
		Consumer<String> con1 = str -> System.out.println(str);
		con1.accept("asd");

		System.out.println("-----------------");

		// 方法引用
		PrintStream ps = System.out;
		Consumer<String> con2 = ps::println;
		con2.accept("qwe");
	}

	// Supplier中的T get()
	// Employee中的String getName()
	@Test
	public void test2() {
		Employee e = new Employee(1001, "asd", 12, 200);

		Supplier<String> sp1 = () -> e.getName();
		System.out.println(sp1.get());

		System.out.println("-----------------");

		Supplier<String> sp2 = e::getName;
		System.out.println(sp2.get());
	}

	// 情况二：类 :: 静态方法
	// Comparator中的int compare(T t1,T t2)
	// Integer中的int compare(T t1,T t2)
	@Test
	public void test3() {
		Comparator<Integer> com1 = (t1, t2) -> Integer.compare(t1, t2);
		System.out.println(com1.compare(12, 21));

		System.out.println("-----------------");

		Comparator<Integer> com2 = Integer::compare;
		System.out.println(com2.compare(12, 21));
	}

	// Function中的R apply(T t)
	// Math中的Long round(Double d)
	@Test
	public void test4() {
		Function<Double, Long> fun1 = d -> Math.round(d);
		System.out.println(fun1.apply(12.2));

		System.out.println("-----------------");

		Function<Double, Long> fun2 = Math::round;
		System.out.println(fun2.apply(12.2));
	}

	// 情况三：类 :: 实例方法
	// Comparator中的int comapre(T t1,T t2)
	// String中的int t1.compareTo(t2)
	@Test
	public void test5() {
		Comparator<String> com1 = (t1 , t2) -> t1.compareTo(t2);
		System.out.println(com1.compare("asd", "qwe"));
		
		System.out.println("-----------------");

		Comparator<String> com2 = String :: compareTo;		//第一个参数作为方法的调用者
		System.out.println(com2.compare("zxc", "asd"));
	}

	// BiPredicate中的boolean test(T t1, T t2);
	// String中的boolean t1.equals(t2)
	@Test
	public void test6() {
		BiPredicate<String , String> bi1 = (t1 , t2) -> t1.equals(t2);
		System.out.println(bi1.test("asd", "asd"));
		
		System.out.println("-----------------");

		BiPredicate<String , String> bi2 = String :: equals;
		System.out.println(bi2.test("qwe", "qwe"));
	}

	// Function中的R apply(T t)
	// Employee中的String getName();
	@Test
	public void test7() {
		Employee emp = new Employee(1001, "ert", 121, 9999);
		
		Function<Employee, String> fun1 = e -> e.getName();
		System.out.println(fun1.apply(emp));
		
		System.out.println("-----------------");
		
		Function<Employee, String> fun2 = Employee :: getName;
		System.out.println(fun2.apply(emp));
	}

}
