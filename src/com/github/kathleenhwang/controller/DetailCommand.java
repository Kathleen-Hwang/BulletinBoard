package com.github.kathleenhwang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kathleenhwang.model.BoardDAO;
import com.github.kathleenhwang.model.BoardDTO;

public class DetailCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDTO item = BoardDAO.getInstance().getDetail(Integer.parseInt(request.getParameter("no")));
		
		request.setAttribute("item", item);
		
		return "/board/detail.jsp";
	}

}
