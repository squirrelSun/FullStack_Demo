package spring.datasource;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.pool.DruidDataSource;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("druid.xml");
		//直接连接
		DruidDataSource dataSource = ac.getBean("druid", DruidDataSource.class);
		System.out.println(dataSource.getConnection());
		//加载外部资源连接
		DruidDataSource dataSource2 = ac.getBean("druid2", DruidDataSource.class);
		System.out.println(dataSource2.getConnection());
	}
	
}
