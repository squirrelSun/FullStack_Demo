package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.book.dao.BookDao;

@Service
public class BookServiceImp implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void buyBook(Integer uid, Integer bid) {
		Integer cost = bookDao.selectCost(bid);
		bookDao.updateBhave(bid);
		bookDao.updateBalance(uid, cost);
	}

}
