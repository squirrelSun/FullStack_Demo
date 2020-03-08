package JDBC.Connection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

/*
 * 自主获取数据库连接
 * */

public class connection_test {

	// 方式一
	@Test
	public void test1() throws Exception {

		Driver driver = new com.mysql.jdbc.Driver(); // 加载数据库驱动

		// 主协议 子协议 IP地址 端口号 数据库名
		String url = "jdbc:mysql://localhost:3306/test"; // 数据库地址

		Properties info = new Properties(); // 封装用户名，密码
		info.setProperty("user", "root");
		info.setProperty("password", "3306");

		Connection conn = driver.connect(url, info); // 获取连接

		System.out.println(conn);
	}

	// 方式二，对方式一的迭代
	@Test
	public void test2() throws ClassNotFoundException, Exception {
		// 获取Driver的实现类对象（反射）
		Class<?> cla = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) cla.newInstance();

		// 提供连接的数据库
		String url = "jdbc:mysql://localhost:3306/test";

		// 提供用户名密码
		Properties info = new Properties();
		info.setProperty("user", "root");
		info.setProperty("password", "3306");

		// 获取连接
		Connection conn = driver.connect(url, info);

		System.out.println(conn);
	}

	// 方式三：使用DriverManager替换Driver
	@Test
	public void test3() throws Exception {
		// 获取Driver的实现类对象
		Class<?> cla = Class.forName("com.mysql.jdbc.Driver");
		Driver driver = (Driver) cla.newInstance();

		// 提供基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "3306";

		// 注册驱动
		DriverManager.registerDriver(driver);

		// 获取连接
		Connection connection = DriverManager.getConnection(url, user, password);

		System.out.println(connection);
	}

	// 方式四：只用加载驱动，不用显式创建驱动
	@Test
	public void test4() throws Exception {
		// 提供基本信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "3306";

		// 加载驱动
		Class.forName("com.mysql.jdbc.Driver");

		// 获取连接
		Connection connection = DriverManager.getConnection(url, user, password);

		System.out.println(connection);
	}

	// 最终版：将数据库连接需要的信息存放在配置文件中，通过读取配置文件，获取连接
	@Test
	public void test5() throws Exception {
		// 读取配置文件中的信息
		InputStream inputStream = connection_test.class.getClassLoader()
				.getResourceAsStream("JDBC/util/jdbc.properties");

		Properties pro = new Properties();
		pro.load(inputStream);

		String user = pro.getProperty("user");
		String password = pro.getProperty("password");
		String url = pro.getProperty("url");
		String driverClass = pro.getProperty("driverClass");

		// 加载驱动
		Class.forName(driverClass);

		// 获取链接
		Connection connection = DriverManager.getConnection(url, user, password);

		System.out.println(connection);
	}
}
