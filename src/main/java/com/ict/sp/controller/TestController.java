package com.ict.sp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ict.sp.service.TestService;

@Controller
public class TestController {
	@Autowired
	private TestService ts;
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Model m) {
		m.addAttribute("list",ts.getList());
		return "test/test";
	}
}
