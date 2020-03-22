package JDBC.PreparedStatement.crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.Test;

import JDBC.PreparedStatement.bean.Order;
import JDBC.Util.JDBCUtils;

/*
 * 针对于Order表的通用查询
 * */

public class OrderForQuery {

	@Test
	public void OrderForQueryTest() {
		String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id = ?";
		Order order = ForQuery(sql , 1);
		System.out.println(order);
	}
	
	public Order ForQuery(String sql , Object ...args){
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			connection = JDBCUtils.getConnection();
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			resultSet = ps.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (resultSet.next()) {
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columValue = resultSet.getObject(i + 1);
					Field filed = Order.class.getDeclaredField(columnLabel);
					filed.setAccessible(true);
					filed.set(order, columValue);
				}
				return order;
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(connection, ps, resultSet);
		}
		return null;
	}
	
}
