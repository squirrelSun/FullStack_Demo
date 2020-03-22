package JDBC.PreparedStatement.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import JDBC.Util.JDBCUtils;

/*
 * JDBC对数据库的通用增删改操作
 * */

public class CommonUpdate {
	
	@Test
	public void testCommonUpdate() {
//		String sql = "delete from customers where id = ?";
//		update(sql,3);

		String sql = "update `order` set order_name = ? where order_id = ?";
		Update(sql, "DD", "2");

	}

	// 通用的增删改操作
	public int Update(String sql, Object ...args) {// sql中占位符的个数与可变形参的长度相同
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接
			conn = JDBCUtils.getConnection();
			// 2.预编译sql语句，返回PreparedStatement的实例
			ps = conn.prepareStatement(sql);
			// 3.填充占位符
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);// 小心参数声明错误！！
			}
			// 4.执行
//			ps.execute();	//如果为查询操作（有返回结果）则返回true，如果为增删改操作（无返回结果）则返回false
			return ps.executeUpdate();	//返回值为影响了几条数据
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(conn, ps);
		}
		return 0;
	}
}
