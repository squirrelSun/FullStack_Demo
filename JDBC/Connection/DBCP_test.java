package JDBC.Connection;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

/*
 * DBCP数据库连接池
 * */

public class DBCP_test {

	// 方式一
	@Test
	public void testGetConnection() throws SQLException {
		// 创建了DBCP的数据库连接池
		BasicDataSource source = new BasicDataSource();

		// 设置基本信息
		source.setDriverClassName("com.mysql.jdbc.Driver");
		source.setUrl("jdbc:mysql://localhost:3306/test");
		source.setUsername("root");
		source.setPassword("3306");

		// 还可以设置其他涉及数据库连接池管理的相关属性：
		source.setInitialSize(10); // 初始连接数
		source.setMaxActive(10); // 最大活跃数

		// 从连接池中获取连接
		Connection conn = source.getConnection();
		System.out.println(conn);
	}

	// 方式二：使用配置文件	dbcp.propertise	存放在src下
	@Test
	public void testGetConnection1() throws Exception {
		Properties pros = new Properties();

		// 方式1：
//		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("dbcp.properties");
		// 方式2：
		FileInputStream is = new FileInputStream(new File("src/dbcp.properties"));

		pros.load(is);
		//创建数据库连接池
		DataSource source = BasicDataSourceFactory.createDataSource(pros);

		Connection conn = source.getConnection();
		System.out.println(conn);
	}

}
