package com.kh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardMemberDTO;
import com.kh.service.BoardMemberService;

//크로스 도메인 이슈 해결 방법
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
		if (count > 0) {
			map.put("msg", id + "해당 아이디 삭제 완료");
		} else {
			map.put("msg", id + "삭제할 아이디를 찾을 수 없습니다.");
		}
		List<BoardMemberDTO> list = boardMemberService.selectAllMember();
		map.put("list", list);
		return map;
	}

	@ResponseBody
	@PutMapping("/update")
	public Map<String, Object> updateMember(@RequestBody Map<String, String> body) {
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(body);
		int count = boardMemberService.updateMember(body);
		if (count > 0) {
			map.put("msg", body.get("id") + "수정 완료");
		} else {
			map.put("msg", body.get("id") + "수정할 아이디를 찾을 수 없습니다.");
		}
		List<BoardMemberDTO> list = boardMemberService.selectAllMember();
		map.put("list", list);
		return map;
	}

	@ResponseBody
	@PatchMapping("/updateColumn")
	public Map<String, Object> updateColumnMember(@RequestBody Map<String, String> body) {
		HashMap<String, Object> map = new HashMap<>();
		System.out.println(body);
		int count = boardMemberService.updateColumnMember(body);
		if (count > 0) {
			map.put("msg", body.get("id") + " - 데이터 수정 완료");
		} else {
			map.put("msg", body.get("id") + " - 수정할 아이디를 찾을 수 없습니다.");
		}

		return map;
	}
	
	@ResponseBody
	@GetMapping("/list")
	public List<BoardMemberDTO> memberList() {
		return boardMemberService.selectAllMember();
	}
}
