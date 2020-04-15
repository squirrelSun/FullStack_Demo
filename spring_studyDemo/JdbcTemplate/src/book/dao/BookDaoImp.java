package com.book.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDaoImp implements BookDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Integer selectCost(Integer bid) {
		Integer bcost = jdbcTemplate.queryForObject("select bcose from book where bid = ?", new Object[] { bid }, Integer.class);
		return bcost;
	}

	@Override
	public void updateBhave(Integer bid) {
		Integer bhave = jdbcTemplate.queryForObject("select bhave from have where bid = ?", new Object[] { bid }, Integer.class);
		if (bhave <= 0)
			throw new RuntimeException("库存不足");
		else
			jdbcTemplate.update("update have set bhave = bhave - 1 where bid = ?", bid);
	}

	@Override
	public void updateBalance(Integer uid, Integer cost) {
		Integer balance = jdbcTemplate.queryForObject("select balance from user where uid = ?", new Object[] {uid}, Integer.class);
		if (balance < cost)
			throw new RuntimeException("余额不足");
		else
			jdbcTemplate.update("update user set balance = balance - ? where uid = ?", cost , uid);
	
	}

}
