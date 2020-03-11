package JDBC.dbutils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import JDBC.PreparedStatement.bean.Customer;
import JDBC.Util.JDBCUtils_new;

/*
 * commons-dbutils 
 * 		JDBC工具类库,封装了针对于数据库的增删改查操作
 * 
 */
public class QueryRunner_test {

	// 插入
	@Test
	public void testInsert() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "insert into customers(name,email,birth)values(?,?,?)";
			int insertCount = runner.update(connection, sql, "蔡徐坤", "45648@1633.com", "1984-01-01");
			System.out.println("添加了" + insertCount + "条记录");
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// 查询
	// BeanHander:是ResultSetHandler接口的实现类，用于封装表中的一条记录。
	@Test
	public void testQuery1() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select id,name,email,birth from customers where id = ?";
			BeanHandler<Customer> handler = new BeanHandler<>(Customer.class);
			Customer customer = runner.query(connection, sql, handler, 23);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// BeanHander:是ResultSetHandler接口的实现类，用于封装表中的多条记录构成的集合。
	@Test
	public void testQuery2() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select id,name,email,birth from customers where id < ?";
			BeanListHandler<Customer> handler = new BeanListHandler<>(Customer.class);
			List<Customer> customer = runner.query(connection, sql, handler, 23);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// MapHandler:是ResultSetHandler接口的实现类，对应表中一条记录，将字段及字段值作为key-value
	@Test
	public void testQuery3() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select id,name,email,birth from customers where id = ?";
			MapHandler handler = new MapHandler();
			Map<String, Object> map = runner.query(connection, sql, handler, 23);
			System.out.println(map);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// MapListHandler:是ResultSetHandler接口的实现类，对应表中多条记录，每一条记录将字段及字段值作为key-value
	@Test
	public void testQuery4() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select id,name,email,birth from customers where id < ?";
			MapListHandler handler = new MapListHandler();
			List<Map<String, Object>> list = runner.query(connection, sql, handler, 23);
			list.forEach(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// ScalarHandler:是ResultSetHandler接口的实现类，查询特殊值
	@Test
	public void testQuery5() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select count(*) from customers";
			ScalarHandler handler = new ScalarHandler();
			Object value = runner.query(connection, sql, handler);
			System.out.println(value);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

	// 自定义ResultSetHandler的实现类
	@Test
	public void testQuery6() {
		Connection connection = null;
		try {
			QueryRunner runner = new QueryRunner();
			connection = JDBCUtils_new.getConnection3();
			String sql = "select id,name,email,birth from customers where id = ?";
			ResultSetHandler<Customer> handler = new ResultSetHandler<Customer>() {
				@Override
				public Customer handle(ResultSet rs) throws SQLException {
					System.out.println("handle");
//					return null;

//					return new Customer(12, "成龙", "Jacky@126.com", new Date(234324234324L));

					if (rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						String email = rs.getString("email");
						Date birth = rs.getDate("birth");
						Customer customer = new Customer(id, name, email, birth);
						return customer;
					}
					return null;
				}
			};
			Customer customer = runner.query(connection, sql, handler, 23);
			System.out.println(customer);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JDBCUtils_new.closeResource(connection, null);
		}
	}

}
