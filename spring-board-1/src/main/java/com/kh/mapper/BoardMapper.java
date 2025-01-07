package com.kh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.dto.BoardDTO;

@Mapper
public interface BoardMapper {

	List<BoardDTO> getBoardList(Map<String, Object> map);

	int selectBoardTotalCount();

}
