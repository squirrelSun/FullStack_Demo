package Reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.junit.Test;

/*
 * 反射机制（动态性）
 * 
 * 获取Class的实例
 * 创建运行时类的对象
 * 获取运行时类的完整结构（夫类的泛型、注解、接口等）
 * 调用运行时类中指定的结构（属性、方法、构造器）
 * */

public class Reflection_test {
	/*
	 * java.lang.Class类
	 * 
	 * 1.类的加载过程：
	 * 程序经过javac.exe命令后，会生成一个或多个字节码文件(.class结尾)，使用java.exe命令对某个字节码文件进行解释运行。
	 * 相当于将某个字节码文件加载入内存中（此过程称为类的加载），加载入内存中的类称为运行时类，此运行时类就作为Class的一个实例。
	 * 2.Class的实例对象就是一个运行时类（存在于方法区） 3.加载入内存中的运行时类，会在缓存区存在一段时间。在此时间内，可以通过不同的方式获取此运行时类
	 * 可以获取的对象类型： 1）class：外部类、成员内部类、静态内部类、局部内部类、匿名内部类 2）interface：接口 3）[]：数组
	 * 4）enum：枚举类 5）annotation：注解@interface 6）基本数据类型 7）void
	 * 
	 */

	@Test // 获取Class的实例的方式
	public void test1() throws ClassNotFoundException {
		// 方式一：调用运行时类的属性.class
		Class cla1 = Person.class;
		System.out.println(cla1);

		// 方式二：通过运行时类的对象调用.getClass()
		Person p = new Person();
		Class cla2 = p.getClass();
		System.out.println(cla2);

		// 方式三：通过Class的静态方法forName(String classPath) 常用方法
		Class cla3 = Class.forName("Reflection.Person"); // 包含包名的类的全类名
		System.out.println(cla3);

		// 方式四：使用类的加载器
		ClassLoader classLoader = Reflection_test.class.getClassLoader();
		Class cla4 = classLoader.loadClass("Reflection.Person");
		System.out.println(cla4);

		// 获取的是同一个运行时类
		System.out.println(cla1 == cla2);
		System.out.println(cla3 == cla2);
		System.out.println(cla3 == cla4);
	}

	@Test // Class可以获取的对象类型
	public void test2() {
		Class c1 = Object.class;
		Class c2 = Comparable.class;
		Class c3 = String[].class;
		Class c4 = int[][].class;
		Class c5 = ElementType.class;
		Class c6 = Override.class;
		Class c7 = int.class;
		Class c8 = void.class;
		Class c9 = Class.class;

		int[] a = new int[10];
		Class c10 = a.getClass();
		int[] b = new int[100];
		Class c11 = b.getClass();

		// 只要数组的元素类型与维度一样，就是同一个Class，与长度无关
		System.out.println(c10 == c11);
	}

	@Test // 通过反射调用构造器创建运行时类的对象
	public void test3() throws Exception {
//		Class cla = Person.class;
//		Person obj = (Person) cla.newInstance();	
		Class<Person> cla = Person.class;
		// 调用newInstance()创建运行时类的对象，内部调用了运行时类的空参构造器，如果没有空参构造器或空参构造器访问权限不足时产生异常
		Person obj = cla.newInstance();

		System.out.println(obj);
	}

	@Test // 通过反射获取运行时类的完整结构
	public void test4() {
		Class cla = Person.class;

		// getFields()获取运行时类及其所有父类中声明为public访问权限的属性
		Field[] fields1 = cla.getFields();
		for (Field f : fields1) {
			System.out.println(f);
		}
		System.out.println("-----------");

		// getDeclaredFields()获取当前运行时类的所有属性，与权限无关，不包含父类
		Field[] fields2 = cla.getDeclaredFields();
		for (Field f : fields2) {
			System.out.println(f);
		}
		System.out.println("-----------");

		// 获取运行时类每一个属性的细节（权限修饰符、数据类型、变量名）
		Field[] fields3 = cla.getDeclaredFields();
		for (Field f : fields3) {
			// 获取权限修饰符
			int mod = f.getModifiers(); // 返回的是用数字表示的权限
			System.out.print(Modifier.toString(mod) + "\t"); // 翻译权限

			// 获取数据类型
			Class type = f.getType(); // 获取为全类名
			System.out.print(type.getName() + "\t");

			// 获取变量名
			String name = f.getName();
			System.out.print(name + "\t");

			System.out.println();
		}
		System.out.println("-----------");

		// getMethods()获取运行时类及其所有父类中声明为public访问权限的方法
		Method[] methods1 = cla.getMethods();
		for (Method m : methods1) {
			System.out.println(m);
		}
		System.out.println("-----------");

		// getDeclaredMethods()获取当前运行时类中声明的所有方法，与权限无关，不包含父类
		Method[] methods2 = cla.getDeclaredMethods();
		for (Method m : methods2) {
			System.out.println(m);
		}
		System.out.println("-----------");

		//	（注解、权限修饰符、返回值类型、方法名、参数类型1、形参名、...、抛出的异常）
		Method[] methods3 = cla.getDeclaredMethods();
		for (Method m : methods3) {
			//获取方法声明的注解
			Annotation[] ann = m.getAnnotations();	//一个方法可能有多个注解
			for (Annotation a : ann) {
				System.out.println(a);
			}
			
			//获取方法的权限修饰符
			int mo = m.getModifiers();	// 返回的是用数字表示的权限
			System.out.print(Modifier.toString(mo) + "\t"); // 翻译权限
			
			//获取返回值类型
			System.out.print(m.getReturnType().getName() + "\t");
			
			//获取方法名
			System.out.print(m.getName());
			
			System.out.print("(");
			//获取形参列表
			Class[] ty = m.getParameterTypes();
			if (!(ty == null && ty.length == 0)) {	//有参数类型时
				for (int i = 0 ; i < ty.length ; i++) {
					if (i == ty.length - 1) {
						System.out.print(ty[i] + "args_" + i);		//获取参数类型+形参名
						break;
					}
					System.out.print(ty[i] + "args_" + i + ",");
				}
			}
			System.out.print(")");
			
			//获取方法抛出的异常
			Class[] ex = m.getExceptionTypes();
			if (ex.length > 0) {	//有异常抛出时
				System.out.print(" throws ");
				for (int i = 0 ; i < ex.length ; i ++) {
					if (i == ex.length - 1) {
						System.out.print(ex[i].getName());	//获取异常类型并翻译
						break;
					}
					System.out.print(ex[i].getName() + ",");
				}
				
			}
			System.out.println();
			System.out.println("-----------");
			
			//getConstructors()获取运行时类中权限为public的构造器
			Constructor[] con1 = cla.getConstructors();
			for (Constructor c : con1) {
				System.out.println(c);
			}
			System.out.println("-----------");
			
			//getDeclaredConstructors()获取当前运行时类中声明的所有构造器，与权限无关，不包含父类
			Constructor[] con2 = cla.getDeclaredConstructors();
			for (Constructor c : con2) {
				System.out.println(c);
			}
			System.out.println("-----------");
			
			//获取运行时类的父类
			Class su = cla.getSuperclass();
			System.out.println(su);
			System.out.println("-----------");
			
			//获取运行时类的带泛型的父类
			Type gsu = cla.getGenericSuperclass();
			System.out.println(gsu);
			System.out.println("-----------");
			
			//获取运行时类的父类的泛型
			Type gsu1 = cla.getGenericSuperclass();		//获取带泛型的父类
			ParameterizedType para = (ParameterizedType) gsu1;
			Type[] ata = para.getActualTypeArguments();	//获取泛型类型
//			System.out.println(ata[0].getTypeName());	//获取类型名1
			System.out.println(((Class) ata[0]).getName());	//获取类型名2
			System.out.println("-----------");

			//获取运行时类实现的接口
			Class[] inter = cla.getInterfaces();
			for (Class c : inter) {
				System.out.println(c);
			}
			System.out.println("-----------");
			
			//获取运行时类所在的包
			Package pack = cla.getPackage();
			System.out.println(pack);
			System.out.println("-----------");
			
			//获取运行时类的注解
			Annotation[] ann2 = cla.getAnnotations();
			for (Annotation a : ann2) {
				System.out.println(a);
			}
			System.out.println("-----------");
		}
	}
	
	@Test	//调用运行时类中指定的结构（属性、方法、构造器）
	public void test5() throws Exception {
		Class cla = Person.class;
		//创建运行时类的对象
		Person p = (Person) cla.newInstance();
		
		//调用属性
		//方法一：运行时类的属性权限为public
		Field id = cla.getField("id");//获取指定的属性
		id.set(p, 1001);//设置当前属性的值	参数一：指明设置的对象 参数二：将此属性设置为多少
		int pId = (int) id.get(p);//获取指定对象的属性值	参数：指明获取的对象
		System.out.println(pId);
		//方法二
		Field name = cla.getDeclaredField("name");//获取指定的属性
		name.setAccessible(true);//保证当前属性可访问
		name.set(p, "asd");//设置当前属性的值	参数一：指明设置的对象 参数二：将此属性设置为多少
		String pName = (String) name.get(p);//获取指定对象的属性值	参数：指明获取的对象
		System.out.println(pName);
		System.out.println("------------------");
		
		//调用运行时类的方法
		//非静态方法
		Method show = cla.getDeclaredMethod("show", String.class);//获取指定的某个方法		参数一：指明获取方法的名称	参数二：指明获取的方法的形参列表
		show.setAccessible(true);//保证当前方法可访问
		Object obj = show.invoke(p, "CHN");//调用invoke执行方法	参数一：方法的调用者	参数二：调用的方法的实参	该方法的返回值即为调用的方法的返回值
		System.out.println((String)obj);
		//静态方法
		Method desc = cla.getDeclaredMethod("showDESC" );
		desc.setAccessible(true);
		Object obj1 = desc.invoke(null);	//调用的为无返回值方法，该方法返回值为null
		System.out.println(obj1);
		
		//调用运行时类的指定构造器
		Constructor con = cla.getDeclaredConstructor(String.class);//获取指定构造器	参数为指定的构造器的形参列表的参数类型
		con.setAccessible(true);//保证当前构造器可访问
		Person p1 = (Person) con.newInstance("Tom");//调用构造器创建运行时类的对象
		System.out.println(p1);
	}
}
