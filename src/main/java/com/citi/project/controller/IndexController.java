package com.citi.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.citi.project.dao.cfgDao;
import com.citi.project.dto.Transaction;


@org.springframework.stereotype.Controller
public class IndexController {
	
	@Autowired
	cfgDao cfgDaoObject;
	
	@GetMapping("/")
	public String login() {
		return "login";
	}

	@GetMapping("/index")
	public String indexPage() {
		return "index";
	}
	
	@GetMapping("/file")
	public String filePage() {
		return "file";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/success")
	public String getSuccessRecords(Model model) throws NumberFormatException, IOException, ParseException{
		cfgDaoObject.read();
		List<Transaction> data=new ArrayList<>(cfgDaoObject.tSuccess);
		model.addAttribute("data",data); ;	
		return "success";
	}
	
	@GetMapping("/failure")
	public String getFailureRecords(Model model) throws NumberFormatException, IOException, ParseException{
		cfgDaoObject.read();
		List<Transaction> dataf=new ArrayList<>(cfgDaoObject.tFailure);
		model.addAttribute("dataf",dataf); ;	
		return "failure";
	}
	
	
}
