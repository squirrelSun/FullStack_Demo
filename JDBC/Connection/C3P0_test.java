package JDBC.Connection;

import java.sql.Connection;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/*
 * C3P0数据库连接池
 * */

public class C3P0_test {

	//方式一
	@Test
	public void testGetConnection() throws Exception {
		//创建c3p0数据库连接池
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test" );
		cpds.setUser("root");                                  
		cpds.setPassword("3306");
		
		//设置初始时数据库连接池中的连接数
		cpds.setInitialPoolSize(10);
		
		//从连接池中获取连接
		Connection connection = cpds.getConnection();
		System.out.println(connection);
		
		//销毁c3p0数据库连接池,一般不关闭
//		DataSources.destroy( cpds );
	}
	
	//方式二:使用配置文件	c3p0-config.xml	默认存放在src下
	@Test
	public void testGetConnection1() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		Connection connection = cpds.getConnection();
		System.out.println(connection);
	}
	
}



