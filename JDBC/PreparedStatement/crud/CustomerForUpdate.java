package JDBC.PreparedStatement.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

import org.junit.Test;

import JDBC.Util.JDBCUtils;

/*
 * 使用PreparedStatement替换Statement，实现对数据表的增删改
 * 
 * */

public class CustomerForUpdate {
	
	// 添加customers表的一条记录
	@Test
	public void testInsert() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			// 连接数据库
			connection = JDBCUtils.getConnection();
			// 预编译sql语句，返回PreparedStatement的实例
			String sql = "insert into customers(name,email,birth)values(?,?,?)"; // ?占位符
			ps = connection.prepareStatement(sql);
			// 填充占位符
			ps.setString(1, "阿斯顿");
			ps.setString(2, "123456@qq.com");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse("1000-01-01");
			ps.setDate(3, new Date(date.getTime()));
			// 执行
			ps.execute();
		} catch (Exception e) {
		} finally {
			// 资源关闭
			JDBCUtils.closeResource(connection, ps);
		}
	}

	// 修改customers表的一条记录
	@Test
	public void testUpdate() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			// 1.获取数据库的连接
			connection = JDBCUtils.getConnection();
			// 2.预编译sql语句，返回PreparedStatement的实例
			String sql = "update customers set name=? where id=?";
			ps = connection.prepareStatement(sql);
			// 3.填充占位符
			ps.setObject(1, "wer");
			ps.setObject(2, 18);
			// 4.执行
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5.资源的关闭
			JDBCUtils.closeResource(connection, ps);
		}
	}

	//删除customers表的一条记录
	@Test
	public void testdelete() {
		Connection connection = null;
		PreparedStatement ps = null;
		
		try {
			connection = JDBCUtils.getConnection();
			String sql = "delete from customers where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setObject(1, 21);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.closeResource(connection, ps);			
		}
	}
	
}
