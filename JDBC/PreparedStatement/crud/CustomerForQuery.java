package JDBC.PreparedStatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import JDBC.PreparedStatement.bean.Customer;
import JDBC.Util.JDBCUtils;

/*
 * 针对Customers表的查询操作
 * */

public class CustomerForQuery {

	// 查询一条记录
	@Test
	public void testQuery() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "SELECT id,name,email,birth FROM customers WHERE id =  ?";
			ps = connection.prepareStatement(sql);
			ps.setObject(1, 1);
			
			// 执行并返回结果集
			resultSet = ps.executeQuery();
			// 处理结果集
			if (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移
				// 获取当前条数据的各字段值
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				String email = resultSet.getString(3);
				Date birth = resultSet.getDate(4);

//				 // 方式一
//				 System.out.println("id = " + id + " , name = " + name + " , email = " + email
//				 + " , birth = " + birth);
//				
//				 //方式二
//				 Object[] data = new Object[]{id , name , email , birth};

				// 方式三，将数据封装为一个对象
				Customer customer = new Customer(id, name, email, birth);
				System.out.println(customer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
	}

	//Customers表的通用查询操作
	public Customer queryForCustomers(String sql,Object ...args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0 ; i < args.length ; i++)
				ps.setObject(i + 1 , args[i]);

			//执行
			resultSet = ps.executeQuery();
			//获取结果集的原数据
			ResultSetMetaData rsmd = resultSet.getMetaData();
			//通过元数据获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			// 处理结果集
			if (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移
				Customer cust = new Customer();
				//处理结果集一行数据中的每一个列
				for(int i = 0;i <columnCount;i++){
					//获取每个列的别名（无别名即为列名）
					String columnLabel = rsmd.getColumnLabel(i + 1);
					//获取列值
					Object columValue = resultSet.getObject(i + 1);
					
					//给cust对象指定的columnName属性，赋值为columValue（反射）
					Field field = Customer.class.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(cust, columValue);
				}
				return cust;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
	}
	
	@Test 
	public void testQueryForCustomers() {
		String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
		Customer customer = queryForCustomers(sql , 2);
		System.out.println(customer);
		
		sql = "SELECT name,email FROM customers WHERE name = ?";
		customer = queryForCustomers(sql , "成龙");
		System.out.println(customer);
		
	}
	
	
	
}
