package com.guven.springdemo.mvc;


import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller

@RequestMapping("/hello")
public class HelloWorldController {



	//need a controller method to show the initial method
	@RequestMapping("/showForm")
	public String showForm(){
		
		return "helloworld-form";
	}
	
	//need a controller method to process a form
	
	@RequestMapping("/processForm")
	public String processForm(){
		
		return "helloworld";
	}
	
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest reques, Model model){
		
		String theName=reques.getParameter("studentName");
		
		theName=theName.toUpperCase();
		String result="YEss "+theName;
		model.addAttribute("message",result);
		return "helloworld";
	}
	
	@RequestMapping("processFormThree")
	public String readFormValuRequestParam(@RequestParam("studentName") String theName,Model model){
		theName=theName.toUpperCase();
		model.addAttribute("name",theName);
		return "helloworld";
	}
	
	
	
	
	
	
	
}