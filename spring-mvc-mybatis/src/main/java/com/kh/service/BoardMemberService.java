package com.kh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.dto.BoardMemberDTO;
import com.kh.mapper.BoardMemberMapper;

@Service
public class BoardMemberService {
	private BoardMemberMapper mapper;

	public BoardMemberService(BoardMemberMapper mapper) {
		this.mapper = mapper;
	}

	public List<BoardMemberDTO> selectAllMember() {
		return mapper.selectAllMember();
	}

}
