package com.kh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kh.service.BoardMemberService;

@RestController
public class RestMainController {
	private BoardMemberService service;

	public RestMainController(BoardMemberService service) {
		this.service = service;
	}

	@GetMapping("/member/register/{id}")
	public int chkId(@PathVariable String id) {
		int result = service.chkId(id);
		return result;
	}
}
