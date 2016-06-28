package com.github.kathleenhwang.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	private static BoardDAO instance;
	private DataSource dataSource;

	public static BoardDAO getInstance() {
		if (instance == null) {
			instance = new BoardDAO();
		}

		return instance;
	}

	private BoardDAO() {
		// TODO Auto-generated constructor stub
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		}
	}

	public List<BoardDTO> getBoardList() {
		List<BoardDTO> boardList = new ArrayList<BoardDTO>();

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet ret = null;

		String query = "SELECT NO, TITLE, CONTENTS, LASTDATE, WRITER, PASSWORD FROM BOARD ORDER BY NO DESC";

		try {
			conn = dataSource.getConnection();
			stm = conn.prepareStatement(query);
			ret = stm.executeQuery();

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
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (ret != null)
					ret.close();
				if (stm != null)
					stm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return boardList;
	}

	public boolean write(final String title, final String contents, final String lastDate, final String writer,
			final String password) {
		boolean retValue = false;

		Connection con = null;
		PreparedStatement stat = null;
		String query = "INSERT INTO BOARD (TITLE, CONTENTS, LASTDATE, WRITER, PASSWORD) VALUES (?, ?, sysdate, ?, ?)";

		try {
			con = dataSource.getConnection();
			stat = con.prepareStatement(query);
			stat.setString(1, title);
			stat.setString(2, contents);
			stat.setString(3, writer);
			stat.setString(4, password);
			retValue = (0 < stat.executeUpdate());

		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return retValue;
	}

	public boolean modify(int no, final String title, final String contents, final String writer,
			final String password) {
		boolean retValue = false;

		Connection con = null;
		PreparedStatement stat = null;
		String query = "UPDATE BOARD SET TITLE=?, CONTENTS=?, LASTDATE=sysdate, WRITER=?, PASSWORD=? WHERE NO = ?";

		try {
			con = dataSource.getConnection();
			stat = con.prepareStatement(query);
			
			System.out.println(title);
			
			stat.setString(1, title);
			stat.setString(2, contents);
			stat.setString(3, writer);
			stat.setString(4, password);
			stat.setInt(5, no);

			retValue = (0 < stat.executeUpdate());

		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return retValue;
	}

	public boolean delete(int no) {
		boolean retValue = false;

		Connection con = null;
		PreparedStatement stat = null;
		String query = "DELETE FROM BOARD WHERE NO = ?";

		try {
			con = dataSource.getConnection();
			stat = con.prepareStatement(query);
			stat.setInt(1, no);
			if (0 < stat.executeUpdate()) {
				retValue = true;
			}
		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return retValue;
	}

	public boolean isAuthenticated(int no, final String password) {
		boolean retValue = false;

		Connection con = null;
		PreparedStatement stat = null;
		String query = "SELECT PASSWORD FROM BOARD WHERE NO = ?";
		ResultSet set = null;
		try {
			con = dataSource.getConnection();
			stat = con.prepareStatement(query);
			stat.setInt(1, no);

			set = stat.executeQuery();

			if (set.next()) {
				retValue = password.equals(set.getString("PASSWORD"));
			}
		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (stat != null) {
					stat.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return retValue;
	}

	public BoardDTO getDetail(int no) {
		BoardDTO item = null;

		Connection conn = null;
		PreparedStatement stm = null;
		ResultSet ret = null;

		String query = "SELECT NO, TITLE, CONTENTS, LASTDATE, WRITER, PASSWORD FROM BOARD WHERE NO = ?";

		try {
			conn = dataSource.getConnection();
			stm = conn.prepareStatement(query);

			stm.setInt(1, no);

			ret = stm.executeQuery();

			while (ret.next()) {
				item = new BoardDTO();

				item.setNo(ret.getString("NO"));
				item.setTitle(ret.getString("TITLE"));
				item.setContents(ret.getString("CONTENTS"));
				item.setLastDate(ret.getString("LASTDATE"));
				item.setWriter(ret.getString("WRITER"));
				item.setPassword(ret.getString("PASSWORD"));
			}

		} catch (Exception e) {
			System.out.println("msg : " + e.getMessage());
		} finally {
			try {
				if (ret != null)
					ret.close();
				if (stm != null)
					stm.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println("msg : " + e.getMessage());
			}
		}

		return item;
	}
}
