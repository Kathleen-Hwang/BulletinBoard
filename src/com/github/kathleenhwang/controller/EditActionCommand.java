package com.github.kathleenhwang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kathleenhwang.model.BoardDAO;

public class EditActionCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDAO.getInstance().modify(Integer.parseInt(request.getParameter("no")), request.getParameter("title"),
				request.getParameter("contents"), request.getParameter("writer"), request.getParameter("password"));
		return "List.do";
	}

}
