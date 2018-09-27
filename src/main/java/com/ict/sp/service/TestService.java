package com.ict.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.sp.dao.TestDAO;
import com.ict.sp.vo.Dept;

@Service
public class TestService {
	@Autowired
	private TestDAO tdao;
	
	public List<Dept> getList(){
		return tdao.getList();
	}
}
