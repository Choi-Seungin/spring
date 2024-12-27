package com.kh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/loginView")
	public String loginView() {
		return "login";
	}
	
	@GetMapping("/get2")
	@ResponseBody
	public RegisterDTO getMethodName() {
		return new RegisterDTO("A0002", "홍길동", "123456", 44);
	}
	
}
