package JDBC.PreparedStatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import JDBC.PreparedStatement.bean.Customer;
import JDBC.PreparedStatement.bean.Order;
import JDBC.Util.JDBCUtils;

/*
 * JDBC对数据库的通用查询操作
 * */

public class CommonQuery {

	@Test
	public void testgetInstance() {
		String sql = "SELECT id,name,email,birth FROM customers WHERE id = ?";
		Customer customer = getInstance(Customer.class, sql, 12);
		System.out.println(customer);

		sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id = ?";
		Order order = getInstance(Order.class, sql, 1);
		System.out.println(order);
	}

	// 针对不同表通用获取一条数据
	public <T> T getInstance(Class<T> cla, String sql, Object... args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);

			// 执行
			resultSet = ps.executeQuery();
			// 获取结果集的原数据
			ResultSetMetaData rsmd = resultSet.getMetaData();
			// 通过元数据获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			// 处理结果集
			if (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移
				// 创建对象
				T t = cla.newInstance();
				// 处理结果集一行数据中的每一个列
				for (int i = 0; i < columnCount; i++) {
					// 获取每个列的别名（无别名即为列名）
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// 获取列值
					Object columValue = resultSet.getObject(i + 1);
					// 给cust对象指定的columnName属性，赋值为columValue（反射）
					Field field = cla.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
	}

	@Test
	public void testgetForList() {
		String sql = "SELECT id,name,email,birth FROM customers";
		List<Customer> list1 = getForList(Customer.class, sql);
		list1.forEach(System.out::println);

		sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id > ?";
		List<Order> list2 = getForList(Order.class, sql, 1);
		list2.forEach(System.out::println);
	}
	
	// 针对不同表通用获取多条数据
	public <T> List<T> getForList(Class<T> cla, String sql, Object... args) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			
			// 执行
			resultSet = ps.executeQuery();
			// 获取结果集的原数据
			ResultSetMetaData rsmd = resultSet.getMetaData();
			// 通过元数据获取结果集中的列数
			int columnCount = rsmd.getColumnCount();
			//创建集合对象
			List<T> list = new ArrayList<T>();
			// 处理结果集
			while (resultSet.next()) { // 判断结果集的下一条是否有数据，如果有数据返回true，并指针下移
				// 创建对象
				T t = cla.newInstance();
				// 处理结果集一行数据中的每一个列
				for (int i = 0; i < columnCount; i++) {
					// 获取每个列的别名（无别名即为列名）
					String columnLabel = rsmd.getColumnLabel(i + 1);
					// 获取列值
					Object columValue = resultSet.getObject(i + 1);
					// 给对象指定的columnName属性，赋值为columValue（反射）
					Field field = cla.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				//将对象加入队列
				list.add(t);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
	}

}
