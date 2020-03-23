package JDBC.Transaction;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.junit.Test;

import JDBC.PreparedStatement.bean.User;
import JDBC.Util.JDBCUtils;

/*
 * 事务
 * 	一组逻辑操作单元，使数据从一种状态转变到另一种状态
 * ACID属性
 * 	原子性、一致性、持续性、隔离性
 * 隔离级别
 * 	读未提交数据	读已提交数据	可重复读		串行化
 * 			脏读			不可重复读		幻读
 * 
 */

public class transactinTest {

	//事务的安全性
	@Test//事务一
	public void testQueryWithTransactin1() throws Exception {
		Class<User> cla = User.class;
		Connection connection = JDBCUtils.getConnection();
		
		System.out.println(connection.getTransactionIsolation());
		//取消自动提交
		connection.setAutoCommit(false);
		
		//设置隔离级别
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		
		String sql = "select user,password,balance from user_table where user = ?";
		User user = (User) getInstance(connection, cla, sql, "cc");
		
		System.out.println(user);
	}
	
	@Test//事务二
	public void testQueryWithTransactin2() throws Exception {
		Connection connection = JDBCUtils.getConnection();
		
		//设置隔离级别
		connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
		System.out.println(connection.getTransactionIsolation());
		//取消自动提交
		connection.setAutoCommit(false);
		
		String sql = "update user_table set balance = ? where user = ?";
		Update(connection, sql, 5000, "cc");
		
		Thread.sleep(15000);
		System.out.println("修改结束");
	}
	
	// 一件事务执行
	@Test
	public void testUpdateWithTransactin() {
		Connection connection = null;
		try {
			// 获取连接
			connection = JDBCUtils.getConnection();

			// 取消连接的自动提交
			connection.setAutoCommit(false);

			// 操作一
			String sql1 = "update user_table set balance = balance - 100 where user = ?";
			Update(connection, sql1, "AA");

			// 模拟网络异常
			System.out.println(10 / 0);

			// 操作二
			String sql2 = "update user_table set balance = balance + 100 where user = ?";
			Update(connection, sql2, "BB");

			// 提交数据
			connection.commit();

			System.out.println("转账成功");
		} catch (Exception e) {
			System.out.println("转账失败");
			try {
				// 数据出错时，事务回滚
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				// 恢复连接的自动提交
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// 关闭连接
			JDBCUtils.closeResource(connection, null);
		}
	}

	// 通用的增删改操作，考虑事务
	public int Update(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps);
		}
		return 0;
	}

	// 通用的查询操作（返回一条记录），考虑事务
	public <T> T getInstance(Connection connection, Class<T> cla, String sql, Object... args) {
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		try {
			ps = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			resultSet = ps.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (resultSet.next()) {
				T t = cla.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columValue = resultSet.getObject(i + 1);
					Field field = cla.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columValue);
				}
				return t;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(null, ps, resultSet);
		}
		return null;
	}

}
