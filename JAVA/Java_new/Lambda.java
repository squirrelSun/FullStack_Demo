package JAVA.Java_new;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.junit.Test;

/*
 * Lambda表达式
 * 左 -> 右
 * 	->	lambda操作符（箭头操作符）
 * 	左	lambda形参列表（接口中的抽象方法的形参列表）
 * 	右	lambda体（重写的抽象方法的方法体）
 * 
 * Lambda表达式的使用（六种情况）
 * 	本质为接口的实例（具体实现类的对象），接口必须为函数式接口（接口中只声明了一个抽样方法）, Java内置的四大核心函数式接口
 * 	左：lambda形参列表的参数类型可以省略，如果形参列表只有一个参数，小括号可以省略
 *  右：lambda体应该用大括号包裹，若只有一条执行语句（可能是return语句），可以省略大括号（及return关键字）
 * */

public class Lambda {

	//无参，无返回值
	@Test
	public void test1() {
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("asdasdasd");
			}
		};
		r1.run();
		
		System.out.println("------------------------");
		
		Runnable r2 = () -> {
			System.out.println("qweqweqwe");
		};
		r2.run();
	}
	
	
	//需要一个参数，无返回值
	@Test
	public void test2() {
		Consumer<String> con1 = new Consumer<String>() {
			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
		};
		con1.accept("asdasdasd");
		
		System.out.println("------------------------");

		Consumer<String> con2 = (String t) -> {
			System.out.println(t);
		};
		con2.accept("qweqweqwe");
	}
	
	//数据类型可以省略，因为可由编译器推断得出（类型推断）
	@Test
	public void test3() {
		Consumer<String> con1 = (String t) -> {
			System.out.println(t);
		};
		con1.accept("asdasdasd");
		
		System.out.println("------------------------");

		Consumer<String> con2 = (t) -> {
			System.out.println(t);
		};
		con2.accept("qweqweqwe");
		
	}
	
	//只需要一个参数时，参数的小括号可以省略
	@Test
	public void test4() {
		Consumer<String> con1 = (String t) -> {
			System.out.println(t);
		};
		con1.accept("asdasdasd");
		
		System.out.println("------------------------");

		Consumer<String> con2 = t -> {
			System.out.println(t);
		};
		con2.accept("qweqweqwe");
	}
	
	//需要两个或以上参数，多条执行语句，并且可以有返回值
	@Test
	public void test5() {
		Comparator<Integer> com1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				System.out.println(o1);
				System.out.println(o2);
				return o1.compareTo(o2);
			}
		};
		System.out.println(com1.compare(12, 21));
		
		System.out.println("------------------------");

		Comparator<Integer> com2 = (o1 , o2) -> {
			System.out.println(o1);
			System.out.println(o2);
			return o1.compareTo(o2);
		};
		System.out.println(com2.compare(21, 12));
		
	}
	
	//lambda体只有一条语句，return与大括号体可以省略
	@Test
	public void test6() {
		Comparator<Integer> com1 = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		};
		System.out.println(com1.compare(12, 21));
		
		System.out.println("------------------------");

		Comparator<Integer> com2 = (o1 , o2) -> o1.compareTo(o2);
		System.out.println(com2.compare(21, 12));
	}
	
	/*
	 * Java内置的四大核心函数式接口
	 * 
	 * 消费型接口	Consumer<T>		void accept(T t)
	 * 供给型接口	Supplier<T>		T get()
	 * 函数型接口	Function<T,R>	R apply(T t)
	 * 断言型接口	Predicate<T>	boolean test(T t)	
	 * */
	@Test//消费型接口
	public void test01() {
		
		happyTime(500 , new Consumer<Double>() {
			@Override
			public void accept(Double t) {
				System.out.println("asdasdasd: " + t);
			}
		});
		
		System.out.println("---------------------");
		
		happyTime(400 , money -> System.out.println("asdasdasd: " + money));
	}
	
	public void happyTime(double money , Consumer<Double> con) {
		con.accept(money);
	}
	
	@Test//断言型接口
	public void test02() {
		List<String> list = Arrays.asList("qwe" , "try" , "wer");
		
		List<String> fstr1 = filterString(list , new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.contains("w");
			}
		});
		System.out.println(fstr1);			
		
		System.out.println("---------------------");
		
		List<String> fstr2 = filterString(list , t -> t.contains("w"));
		System.out.println(fstr2);			
	}
	//根据给定的规则，过滤集合中的字符串，此规则由Predicate的方法决定
	public List<String> filterString(List<String> list , Predicate<String> pre) {
		ArrayList<String> flist = new ArrayList<String>();
		for (String s : list) {
			if (pre.test(s)) {
				flist.add(s);
			}
		}
		return flist;
	}
	
}
