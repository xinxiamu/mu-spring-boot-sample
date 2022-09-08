package com.terran4j.springboot.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@Autowired
	private HelloService helloService;

	// URL示例：  http://localhost:8080/hello?name=terran4j
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String sayHello(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(">>>>host:" + request.getRemoteHost());
		return "192.168.10.116";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String msg = helloService.hello(name);
		response.getWriter().println(msg);
	}

}
