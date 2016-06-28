package com.github.kathleenhwang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kathleenhwang.model.BoardDAO;

public class EditAuthCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int no = Integer.parseInt(request.getParameter("no"));
		boolean isOk = BoardDAO.getInstance().isAuthenticated(no, request.getParameter("password"));

		if (isOk) {
			System.out.println("auth passed");
			return "Edit.do?no=" + no;
		}

		System.out.println("auth failed");
		return "Detail.do?no=" + no;
	}

}
