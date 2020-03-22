package JDBC.PreparedStatement.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import JDBC.Util.JDBCUtils;

/*
 * 实现批量数据的操作（insert，批量插入）
 * 	update/delete本身具有批量操作
 * 
 * 向goods表插入两万条数据
		CREATE TABLE goods(
		id INT PRIMARY KEY AUTO_INCREMENT,
		NAME VARCHAR(25)
		);
		
		SELECT COUNT(*) FROM goods;
		TRUNCATE TABLE goods;
 * */

public class InsertTest {

	//方式一
	@Test
	public void testInsert1() {
		long start = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "insert into goods(name)values(?)";
			ps = connection.prepareStatement(sql);
			for (int i = 1; i <= 200000; i++) {
				ps.setObject(1, "name_" + i);

				ps.execute();
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtils.closeResource(connection, ps);
			long end = System.currentTimeMillis();
			System.out.println(end - start);		//200000:535675ms
		}
	}
	
	/*
	 * 方式二
	 * 1.使用addBatch()、executeBatch()、clearBatch()类似于缓冲区
	 * 2.mysql服务器默认是关闭批处理的，我们需要通过一个参数，让mysql开启批处理的支持。
	 * 		 ?rewriteBatchedStatements=true 写在配置文件的url后面
	 * 3.使用更新的mysql 驱动：mysql-connector-java-5.1.37-bin.jar
	 */
	@Test
	public void testInsert2() {
		long start = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "insert into goods(name)values(?)";
			ps = connection.prepareStatement(sql);
			for (int i = 1; i <= 2000000; i++) {
				ps.setObject(1, "name_" + i);
				
				//攒sql
				ps.addBatch();
				
				if (i % 1000 == 0) {
					//执行Batch
					ps.executeBatch();
					
					//清空Batch
					ps.clearBatch();
				}
			} 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtils.closeResource(connection, ps);
			long end = System.currentTimeMillis();
			System.out.println(end - start);		//200000:1627ms		2000000:13090ms
		}
	}
	
	//方式四
	@Test
	public void testInsert3() {
		long start = System.currentTimeMillis();
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			
			//设置不允许自动提交数据
			connection.setAutoCommit(false);
			
			String sql = "insert into goods(name)values(?)";
			ps = connection.prepareStatement(sql);
			for (int i = 1; i <= 2000000; i++) {
				ps.setObject(1, "name_" + i);
				//攒sql
				ps.addBatch();
				if (i % 1000 == 0) {
					//执行Batch
					ps.executeBatch();
					//清空Batch
					ps.clearBatch();
				}
			} 
			
			//统一提交数据
			connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			JDBCUtils.closeResource(connection, ps);
			long end = System.currentTimeMillis();
			System.out.println(end - start);		//2000000:7009ms
		}
	}
}
