package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestbookService {
	
	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	
	//생성자
	
	//메소드-gs
	
	//메소드-일반
	
	// list
	public List<GuestbookVo> getList() {
		
		List<GuestbookVo> gList = guestbookDao.getList();
		
		return gList;
	}
	
	
	// insert
	public int insert(GuestbookVo vo) {
		
		int count = guestbookDao.insert(vo);
		
		return count;
	}
	
	
	//delete
	public int delete(GuestbookVo vo) {
		
		int count = guestbookDao.delete(vo);
		
		return count;
	}
}
