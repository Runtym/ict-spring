package com.ict.sp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ict.sp.vo.Dept;

@Repository
public class TestDAO {
	
	@Autowired
	private SqlSessionTemplate sst;

	public List<Dept> getList(){
		Dept d = new Dept();
		d.setDeptno(10);
		return sst.selectList("SQL.DEPT.selectDept",d);
	}
}
