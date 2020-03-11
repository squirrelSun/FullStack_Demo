package JDBC.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import JDBC.PreparedStatement.bean.Customer;

public class customerDAOImpl extends BaseDAO<Customer> implements CustomerDAO{

	@Override
	public void insert(Connection connection, Customer customer) {
		String sql = "insert into customers(name,email,birth)values(?,?,?)";
		Update(connection, sql, customer.getName(), customer.getEamil(), customer.getBirth());
	}

	@Override
	public void delectByID(Connection connection, int id) {
		String sql = "delete from customers where id = ?";
		Update(connection, sql, id);		
	}

	@Override
	public void update(Connection connection, Customer customer) {
		String sql = "update customers set name = ?,email = ?,birth = ? where id = ?";
		Update(connection, sql, customer.getName(), customer.getEamil(), customer.getBirth(), customer.getId());	
	}

	@Override
	public Customer getCustomerByID(Connection connection, int id) {
		String sql = "select id,name,email,birth from customers where id = ?";
		Customer customer = getInstance(connection, sql , id);
		return customer;
	}

	@Override
	public List<Customer> getAll(Connection connection) {
		String sql = "select id,name,email,birth from customers";
		List<Customer> list = getForList(connection, sql);
		return list;
	}

	@Override
	public Long getCount(Connection connection) {
		String sql = "select count(*) from customers";
		return getValue(connection, sql);
	}

	@Override
	public Date getMaxBirth(Connection connection) {
		String sql = "select max(birth) from customers";
		return getValue(connection, sql);
	}

}
