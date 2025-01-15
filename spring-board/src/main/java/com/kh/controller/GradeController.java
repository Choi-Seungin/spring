package com.kh.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.service.BoardMemberService;

@RequestMapping("/grade")
@RestController
public class GradeController {
  private BoardMemberService boardMemberService;

  public GradeController(BoardMemberService boardMemberService) {
    this.boardMemberService = boardMemberService;
  }

  @ResponseBody
  @DeleteMapping("/delete")
  public String deleteGrade(@RequestBody String name){
    boardMemberService.deleteGrade(name);
    return "redirect:/grade/main";
  }
  

  
}
