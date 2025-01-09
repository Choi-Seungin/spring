package com.kh.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardCommentDTO;
import com.kh.dto.BoardDTO;
import com.kh.service.BoardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RequestMapping("/board")
@Controller
public class BoardController {
	private BoardService boardService;

  public BoardController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/{bno}")
  public ModelAndView board(@PathVariable int bno, ModelAndView view) {
    BoardDTO dto = boardService.selectBoard(bno);
    List<BoardCommentDTO> list = boardService.getCommentList(bno);
    view.addObject("commentList", list);
    view.addObject("board", dto);
    view.setViewName("board_view");
    return view;
  }

  @PostMapping("/commentWrite")
  public String comment(BoardCommentDTO dto) {
    boardService.insertBoardComment(dto);
    return "redirect:/board/" + dto.getBno();
  }
  

  

}
