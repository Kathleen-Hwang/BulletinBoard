package com.github.kathleenhwang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kathleenhwang.model.BoardDAO;

public class WriteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		BoardDAO.getInstance().writeOnBoard(request.getParameter("title"), request.getParameter("contents"),
				request.getParameter("lastDate"), request.getParameter("writer"), request.getParameter("password"));
		
		return "/list.do";
	}

}
