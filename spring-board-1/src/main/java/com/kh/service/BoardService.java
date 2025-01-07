package com.kh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kh.dto.BoardDTO;
import com.kh.mapper.BoardMapper;

@Service
public class BoardService {
	private BoardMapper mapper;

	public BoardService(BoardMapper mapper) {
		this.mapper = mapper;
	}

	public List<BoardDTO> getBoardList(int pageNo, int pageContentEa) {
		Map<String, Object> map = new HashMap<>();
		map.put("pageNo", pageNo);
		map.put("pageContentEa", pageContentEa);
		return mapper.getBoardList(map);
	}

	public int selectBoardTotalCount() {
		return mapper.selectBoardTotalCount();
	}
	
	

}
