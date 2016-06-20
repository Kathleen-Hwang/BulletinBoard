package com.github.kathleenhwang.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();

		Connection conn = null;
		Statement stm = null;
		ResultSet ret = null;

		String query = "SELECT * FROM BOARD ORDER BY LASTDATE DESC";

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // oracle.jdbc.driver.OracleDriver
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "manso", "1111"); // jdbc:oracle:thin:@localhost:1521:xe
			stm = conn.createStatement();
			ret = stm.executeQuery(query);

			while (ret.next()) {
				BoardDTO item = new BoardDTO();

				item.setNo(ret.getString("NO"));
				item.setTitle(ret.getString("TITLE"));
				item.setContents(ret.getString("CONTENTS"));
				item.setLastDate(ret.getString("LASTDATE"));
				item.setWriter(ret.getString("WRITER"));
				item.setPassword(ret.getString("PASSWORD"));

				boardList.add(item);
			}

		} catch (Exception e) {
			;
		} finally {
			try {
				if (ret != null)
					ret.close();
				if (stm != null)
					stm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}

		return boardList;
	}
}