package com.kh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardMemberDTO;
import com.kh.service.BoardMemberService;

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

	@GetMapping("/members")
	public ModelAndView allMembers(ModelAndView view) {
		//전체 회원 정보 받아옴
		List<BoardMemberDTO> list = service.selectAllMember();
		view.addObject("list", list);
		view.setViewName("member_list");
		return view;
		
	}

}