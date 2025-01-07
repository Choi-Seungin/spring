package com.kh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardMemberDTO;
import com.kh.service.BoardMemberService;

@RequestMapping("/member")
@Controller
public class MemberController {
	private BoardMemberService boardMemberService;

	public MemberController(BoardMemberService boardMemberService) {
		this.boardMemberService = boardMemberService;
	}
	
	@GetMapping("/main")
	public ModelAndView memberList(ModelAndView view) {
		List<BoardMemberDTO> list = boardMemberService.selectAllMember();
		view.addObject("list", list);
		view.setViewName("adminMain");
		return view;
	}
	
	@ResponseBody
	@DeleteMapping("/delete")
	public Map<String, Object> deleteMember(@RequestBody Map<String, Object> param) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String id = param.get("id").toString();
		int count = boardMemberService.deleteMember(id);
		if(count > 0) {
			map.put("msg", id + "해당 아이디 삭제 완료");
		}else {
			map.put("msg", id + "삭제할 아이디를 찾을 수 없습니다.");
		}
		List<BoardMemberDTO> list = boardMemberService.selectAllMember();
		map.put("list", list);
		return map;
	}
	
	
}
