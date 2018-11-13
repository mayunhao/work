package com.bocloud.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloController {

	@RequestMapping(value = { "/hi", "hello" })
	@ResponseBody
	public String home(HttpServletRequest request) {
		System.out.println(request.getLocalAddr());
		return "Hello World!";
	}

	@RequestMapping("/index")
	public String index() {
		return "test";
	}
}
