package JDBC.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.DbUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * 使用数据库连接池技术
 * 	c3p0\dbcp\druid
 * 
 * 配置文件均在src下
 * */

public class JDBCUtils_new {

	// 使用c3p0数据库连接池获取连接
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0"); // c3p0-config.xml

	public static Connection getConnection1() throws Exception {
		Connection connection = cpds.getConnection();
		return connection;
	}

	// 使用dbcp数据库连接池获取连接
	private static DataSource source;
	
	static {
		try {
			Properties pros = new Properties();
			FileInputStream is = new FileInputStream(new File("src/dbcp.properties")); // dbcp.propertise
			pros.load(is);
			source = BasicDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public static Connection getConnection2() throws Exception {
		Connection connection = source.getConnection();
		return connection;
	}

	// 使用druid数据库连接池获取连接
	private static DataSource source1;
	
	static {
		try {
			Properties pros = new Properties();
			InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties"); //druid.properties
			pros.load(is);
			source1 = DruidDataSourceFactory.createDataSource(pros);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static Connection getConnection3() throws Exception {
		Connection connection = source1.getConnection();
		return connection;
	}
	

	//dbutils提供的DbUtils工具类，实现资源的关闭
	public static void closeResource(Connection connection, Statement ps, ResultSet resultSet) {
//		//方式一
//		try {
//			DbUtils.close(connection);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(ps);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			DbUtils.close(resultSet);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//方式二
		DbUtils.closeQuietly(connection);
		DbUtils.closeQuietly(ps);
		DbUtils.closeQuietly(resultSet);
	}
	
	public static void closeResource(Connection connection, Statement ps) {
		DbUtils.closeQuietly(connection);
		DbUtils.closeQuietly(ps);
	}
}
