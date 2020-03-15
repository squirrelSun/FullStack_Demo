package JDBC.Util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/*
 * 操作数据库的工具类
 * */

public class JDBCUtils {

	/*
	 * 获取数据库连接
	 */
	public static Connection getConnection() throws Exception {
		// 读取配置文件中的信息
		InputStream inputStream = ClassLoader.getSystemClassLoader()
				.getResourceAsStream("JDBC/Util/jdbc.properties");

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

		return connection;
	}

	/*
	 * 资源关闭
	 */
	public static void closeResource(Connection connection, Statement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void closeResource(Connection connection, Statement ps, ResultSet resultSet) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (resultSet != null)
				resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
