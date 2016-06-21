package com.github.kathleenhwang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kathleenhwang.model.BoardDAO;
import com.github.kathleenhwang.model.BoardDTO;

public class ListCommand implements Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<BoardDTO> boardList = BoardDAO.getInstance().getBoardList();

		request.setAttribute("boardList", boardList);

		return "/board_list.jsp";
	}

}
