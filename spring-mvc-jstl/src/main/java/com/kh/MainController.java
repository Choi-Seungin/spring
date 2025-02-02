package com.kh;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class MainController {
	// 역주입 방법 1
//	@Autowired
//	private RegisterService service;
	// 역주입 방법 2
	private RegisterService service;
	private ComponentClass component;

	public MainController(RegisterService service, ComponentClass component) {
		this.service = service;
		this.component = component;
	}

	@GetMapping(path = { "/", "/loginView.do" })
	public String loginView() {
		service.serviceTest();
		component.componentTest();
		return "login";
	}

	@GetMapping("/registerView.do")
	public String registerView() {
		return "member_register";
	}

	/*
	 * @PostMapping("/login.do") public String login(HttpServletRequest request,
	 * HttpSession session) { // login.jsp에서 보낸 id와 password를 받아서 sysout으로 출력 String
	 * id = request.getParameter("id"); String pass = request.getParameter("pass");
	 * System.out.println(id); System.out.println(pass); // id와 password를 세션에 저장해서
	 * login_result.jsp로 이동 // HttpSession session = request.getSession();
	 * session.setAttribute("id", id); session.setAttribute("pass", pass); //
	 * login_result.jsp에서는 세션에 저장한 아이디 암호 값을 출력 return "login_result"; }
	 */
	/*
	 * @PostMapping("/login.do") public String login(@RequestParam(name = "id",
	 * defaultValue = "user", required = true)String id,
	 * 
	 * @RequestParam(name = "pass", defaultValue = "password", required =
	 * true)String pass, HttpSession session) { System.out.println(id + " " + pass);
	 * session.setAttribute("id", id); session.setAttribute("pass", pass); return
	 * "login_result";
	 */
	@PostMapping("/login.do")
	public String login(String id, String pass, HttpSession session) {
		System.out.println(id + " " + pass);
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);

		return "login_result";
	}

	/*
	 * @PostMapping("/register.do") public String register(RegisterDTO dto,
	 * HttpServletRequest request) { System.out.println(dto);
	 * request.setAttribute("dto", dto); request.setAttribute("msg",
	 * "회원가입에 성공하셨습니다."); return "register_result"; }
	 */
	@PostMapping("/register.do")
	public ModelAndView register(RegisterDTO dto, ModelAndView view) {
		System.out.println(dto);
		view.addObject("dto", dto);
		view.addObject("msg", "안녕하세요 - request 영역");
		view.setViewName("register_result");
		return view;
	}
	
	//redirect로 이동하는 방법
	@GetMapping("/main")
	public String main() {
		return "redirect:/loginView.do";
	}

}
