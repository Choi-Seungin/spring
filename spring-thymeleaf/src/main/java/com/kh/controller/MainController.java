package com.kh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.dto.BoardMemberDTO;
import com.kh.service.BoardMemberService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	private BoardMemberService service;

	public MainController(BoardMemberService service) {
		this.service = service;
	}

	@GetMapping("/")
	public ModelAndView index(ModelAndView view) {
		view.setViewName("index");
		return view;
	}

	@PostMapping("/login")
	public String login(String id, String password, HttpSession session) {
		BoardMemberDTO member = service.login(id, password);
		System.out.println(member);
		if (member == null) {
			return "redirect:/";
		}
		session.setAttribute("member", member);
		return "redirect:/members";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/members")
	public ModelAndView allMembers(ModelAndView view) {
		List<BoardMemberDTO> list = service.selectAllMember();
		view.addObject("list", list);
		view.setViewName("main");
		return view;
	}

	@GetMapping("/member/register/view")
	public String registerView() {
		return "register";
	}

	@PostMapping("/member/register")
	public String memberRegister(BoardMemberDTO member) {
		System.out.println(member);
		service.insertMember(member);
		return "redirect:/";
	}

	@GetMapping("/member/delete/{id}")
	// public String deleteMember(@PathVariable("id") String id) {
	public String deleteMember(@PathVariable String id) {
		System.out.println("삭제할 아이디 : " + id);
		int count = service.deleteMember(id);
		if (count == 0) {
			System.out.println("데이터 삭제 실패");
		} else {
			System.out.println("데이터 삭제 성공");
		}
		return "redirect:/members";
	}

	@GetMapping("/member/{id}")
	public ModelAndView updateView(@PathVariable String id, ModelAndView view) {
		BoardMemberDTO member = service.selectMember(id);
		view.addObject("member", member);
		view.setViewName("member_update_view");
		return view;
	}

	@PostMapping("/member/update")
	public String updateMember(BoardMemberDTO member) {
		System.out.println(member);
		service.updateMember(member);
		return "redirect:/members";
	}

}
