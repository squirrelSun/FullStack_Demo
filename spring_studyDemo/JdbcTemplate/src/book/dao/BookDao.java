package com.book.dao;

public interface BookDao {
	
	public Integer selectCost(Integer bid);
	
	public void updateBhave(Integer bid);
	
	public void updateBalance(Integer uid , Integer cost);
	
	
}
