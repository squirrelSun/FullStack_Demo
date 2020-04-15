package com.jdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TestJdbcTemplate {

	ApplicationContext ac = new ClassPathXmlApplicationContext("jdbc.xml");
	JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);

	@Test
	public void test() {
//		System.out.println(jdbcTemplate);
//		jdbcTemplate.update("insert into emp values(null , 'asd' , 11 , 'man')");
//		String sql = "insert into emp values(null , ? , ? , ?)";
		String eids = "1,2,3";
		String sql = "delete from emp where eid in (" + eids + ")";
		jdbcTemplate.update(sql);
	}
	
	//批量操作
	@Test
	public void test2() {
		String sql = "insert into emp values(null , ? , ? , ?)";
		List<Object[]> list = new ArrayList<>();
		list.add(new Object[] {"ppp" , 33 , "man"});
		list.add(new Object[] {"ooo" , 44 , "woman"});
		list.add(new Object[] {"iii" , 55 , "man"});
		jdbcTemplate.batchUpdate(sql, list);
	}

	@Test
	public void test3() {
//		jdbcTemplate.queryForObject(sql, requiredType)获取单个的值（聚合函数）
//		jdbcTemplate.queryForObject(sql, rowMapper)获取单条数据列名与属性名的映射关系
		String sql = "select eid,ename,age,sex from emp where eid = ?";
		RowMapper<emp> rowMapper = new BeanPropertyRowMapper<>(emp.class);
		emp emp = jdbcTemplate.queryForObject(sql , new Object[] {4} , rowMapper);
		System.out.println(emp);
	}
	
	@Test
	public void test4() {
		String sql = "select eid,ename,age,sex from emp";
		RowMapper<emp> rowMapper = new BeanPropertyRowMapper<>(emp.class);
		List<emp> list = jdbcTemplate.query(sql , rowMapper);
		for (emp e : list) {
			System.out.println(e);
		}
	}
	
}
