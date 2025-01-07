package com.kh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardDTO;
import com.kh.service.BoardService;
import com.kh.vo.PaggingVO;

@Controller
public class MainController {
	private BoardService service;

	public MainController(BoardService service) {
		this.service = service;
	}
	
	@GetMapping("/")
	public ModelAndView index(@RequestParam(defaultValue= "1")int pageNo, @RequestParam(defaultValue = "30")int pageContentEa,  ModelAndView view) {
		List<BoardDTO> list = service.getBoardList(pageNo, pageContentEa);
		int count = service.selectBoardTotalCount();
		PaggingVO pagging = new PaggingVO(count, pageNo, pageContentEa);
		
		view.addObject("list", list);
		view.addObject("pagging", pagging);
		view.setViewName("index");
		return view;
	}
	
}
