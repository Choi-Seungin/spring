package com.kh.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kh.dto.BoardCommentDTO;
import com.kh.dto.BoardDTO;
import com.kh.dto.BoardFileDTO;
import com.kh.service.BoardService;
import com.kh.token.JwtTokenProvider;
import com.kh.vo.PaggingVO;

import jakarta.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BoardController {
	private final BoardService boardService;
	private final JwtTokenProvider tokenProvider;

	public BoardController(BoardService boardService, JwtTokenProvider tokenProvider) {
		super();
		this.boardService = boardService;
		this.tokenProvider = tokenProvider;
	}

	@GetMapping("/board/list")
	public Map<String, Object> boardList(@RequestParam(defaultValue = "1") int pageNo,
			@RequestParam(defaultValue = "30") int pageContentEa) {
		// 전체 게시글 개수 조회
		int count = boardService.selectBoardTotalCount();
		// 페이지 번호를 보내서 해당 페이지 게시글 목록만 조회
		List<BoardDTO> list = boardService.getBoardList(pageNo, pageContentEa);
		// PaggingVO 페이징 정보 생성
		PaggingVO pagging = new PaggingVO(count, pageNo, pageContentEa);

		Map<String, Object> map = new HashMap<>();
		map.put("boardList", list);
		map.put("pagging", pagging);

		return map;
	}

	@GetMapping("/board/{bno}")
	public Map<String, Object> boardDetail(@PathVariable int bno) {
		Map<String, Object> map = new HashMap<>();
		BoardDTO board = boardService.selectBoard(bno);
		List<BoardCommentDTO> commentList = boardService.getCommentList(bno, 1);
		List<BoardFileDTO> fileList = boardService.getBoardFileList(bno);

		map.put("fileList", fileList);
		map.put("board", board);
		map.put("commentList", commentList);

		return map;
	}

	@GetMapping("/board/comment/{bno}")
	public List<BoardCommentDTO> getMethodName(@PathVariable int bno, @RequestParam int start) {
		List<BoardCommentDTO> commentList = boardService.getCommentList(bno, start);
		return commentList;
	}
}
