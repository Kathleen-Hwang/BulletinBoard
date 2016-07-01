package com.github.kathleenhwang.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 * 
 * add Resource tag like below to use context pool in contex.xml
 * <Resource auth="Container" driverClassName="oracle.jdbc.driver.OracleDriver"
 * maxActive="50" maxWait="1000" name="jdbc/Oracle11g" password="user_password"
 * type="javax.sql.DataSource" url="jdbc:oracle:thin:@localhost:1521:xe"
 * username="user_name"/>
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FrontController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");

		doGet(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String command = uri.substring(conPath.length());

		System.out.println(">>> : " + command);

		Command cmd = null;
		if (command.equals("/Write.do")) {
			cmd = new WriteCommand();
		} else if (command.equals("/Detail.do")) {
			cmd = new DetailCommand();
		} else if (command.equals("/EditAuth.do")) {
			cmd = new EditAuthCommand();
		} else if (command.equals("/Edit.do")) {
			cmd = new EditCommand();
		} else if (command.equals("/EditAction.do")) {
			cmd = new EditActionCommand();
		} else {
			cmd = new ListCommand();
		}

		String jspPage = cmd.execute(request, response);

		RequestDispatcher dispatcher = request.getRequestDispatcher(jspPage);
		dispatcher.forward(request, response);
	}

}
