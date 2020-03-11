package JDBC.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

import JDBC.PreparedStatement.bean.Customer;
import JDBC.Util.JDBCUtils;

public class CustomerDAOImplTest {

	private customerDAOImpl dao = new customerDAOImpl();

	@Test
	public void testInsert() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			Customer customer = new Customer(0, "温斯顿", "123123@126.com", new Date(5464646654L));
			dao.insert(connection, customer);
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testDelectByID() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			dao.delectByID(connection, 13);
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testUpdate() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			Customer customer = new Customer(18, "雅思", "asdad@163.com", new Date(465656546L));
			dao.update(connection, customer );
			
			System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testGetCustomerByID() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			Customer customer = dao.getCustomerByID(connection, 8);
			System.out.println(customer);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testGetAll() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			List<Customer> list = dao.getAll(connection);
			list.forEach(System.out :: println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testGetCount() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			Long count = dao.getCount(connection);
			System.out.println("记录数为：" + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

	@Test
	public void testGetMaxBirth() {
		Connection connection = null;
		try {
			connection = JDBCUtils.getConnection();
			Date maxBirth = dao.getMaxBirth(connection);
			System.out.println("最大生日为：" + maxBirth);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.closeResource(connection, null);
		}
	}

}
