package JDBC.Connection;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/*
 * Druid数据库连接池
 * */


public class Druid_test {
	//使用配置文件	druid.properties
	@Test
	public void getConnection() throws Exception{
		Properties pros = new Properties();
		
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		
		pros.load(is);
		
		//创建数据库连接池
		DataSource source = DruidDataSourceFactory.createDataSource(pros);
		
		Connection conn = source.getConnection();
		System.out.println(conn);
		
	}
}