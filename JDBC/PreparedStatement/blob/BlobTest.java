package JDBC.PreparedStatement.blob;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import JDBC.PreparedStatement.bean.Customer;
import JDBC.Util.JDBCUtils;

/*
 * 使用PreparedStatement操作Blob类型的数据
 * */

public class BlobTest {

	// 向数据表中插入Blob类型的字段
	@Test
	public void testInsert() {
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "insert into customers(name,email,birth,photo)values(?,?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setObject(1, "朴智妍");
			ps.setObject(2, "456789@126.com");
			ps.setObject(3, "1999-01-01");
			FileInputStream is = new FileInputStream(new File(
					"E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JDBC\\PreparedStatement\\blob\\timg.jfif"));
			ps.setBlob(4, is);
			ps.execute();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils.closeResource(connection, ps);
		}
	}

	// 查询数据表中Blob类型的字段
	@Test
	public void testQuery() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			connection = JDBCUtils.getConnection();
			String sql = "select id,name,email,birth,photo from customers where id = ?";
			ps = connection.prepareStatement(sql);
			ps.setObject(1, 23);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				// //方式一
				// int id = resultSet.getInt(1);
				// String name = resultSet.getString(2);
				// String email = resultSet.getString(3);
				// Date birth = resultSet.getDate(4);
				// 方式二
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String email = resultSet.getString("email");
				Date birth = resultSet.getDate("birth");
				Customer customer = new Customer(id, name, email, birth);
				System.out.println(customer);

				// 将blob的数据下载并保存本地
				Blob photo = resultSet.getBlob("photo");
				is = photo.getBinaryStream();
				fos = new FileOutputStream(new File(
						"E:\\Java\\WorkSpace\\eclipse\\Full_Stack\\src\\JDBC\\PreparedStatement\\blob\\timg01.jfif"));
				byte[] buffer = new byte[1024];
				int len;
				while ((len = is.read(buffer)) != -1) {
					fos.write(buffer, 0, len);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JDBCUtils.closeResource(connection, ps, resultSet);
		}

	}

}
