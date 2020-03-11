package JDBC.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import JDBC.PreparedStatement.bean.Customer;

/*
 * 此接口用于规范针对于Customers表的常用操作
 */

public interface CustomerDAO {

	//将customer加入数据库
	void insert(Connection connection , Customer customer);
	
	//根据指定的ID删除一条记录
	void delectByID(Connection connection , int id);
	
	//针对customer对象修改数据表中的记录
	void update(Connection connection , Customer customer);
	
	//根据指定的ID查询对应的Customer对象
	Customer getCustomerByID(Connection connection , int id);
	
	//查询表中的所有记录构成的集合
	List<Customer> getAll(Connection connection);
	
	//返回数据表中的条目数
	Long getCount(Connection connection);
	
	//返回表中最大的生日
	Date getMaxBirth(Connection connection);
}
