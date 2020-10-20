package com.test.ex;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestAction {

	private int value;
	private String msg;        //setter injection을 사용하기 위해서는 반드시 setMsg라는 setter가 있어야 합니다.
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	

	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}


	@RequestMapping("/ex1")
	public ModelAndView ex1() {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("str", msg);
		mv.addObject("num", value);
		
		mv.setViewName("ex1");
		
		return mv;
	}
	
}
	
