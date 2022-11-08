package com.bitacademy.guestbook01.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bitacademy.guestbook01.vo.Guestbook01Vo;

public class Guestbook01Dao {

	public List<Guestbook01Vo> findAll() {
		List<Guestbook01Vo> result = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			String sql = "select no, name, contents, reg_date  from guestbook order by reg_date desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery(); // rs = pstmt.executeQuery(sql); 오류는 안나지만..문법상 없애는게 좋음

			while (rs.next()) {

				int no = rs.getInt(1);
				String name = rs.getString(2);
				String contents = rs.getString(3);
				String regDate = rs.getString(4);

				Guestbook01Vo vo = new Guestbook01Vo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContents(contents);
				vo.setRegDate(regDate);

				result.add(vo);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (rs != null) { // 닫는 순서는 생성 역순으로
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean insert(Guestbook01Vo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			String sql = "insert into guestbook values(null, ?, ?, ?, now())";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getContents());
			//

			int count = pstmt.executeUpdate(); // int count = pstmt.executeUpdate(sql); 에러!

			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		} catch (SQLException e) {
			System.out.println("Error:" + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public Boolean deleteGuestbook(String password, int no) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			String sql = "delete from guestbook where no = ? and password = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, no);
			pstmt.setString(2, password);

			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 : " + e);
		} catch (SQLException e) {
			System.out.println("Error : " + e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;

	}
	
	private Connection getConnection() throws SQLException {
		Connection conn=null;
		
		return conn;
	}
}

//import java.sql.Statement;
//select 시간 넣는것 (insert에는 들어감)
//delete에 옵션 두개 넣는것..
//public class Guestbook01Dao {
//
//	public List<Guestbook01Vo> findAll() {
//		List<Guestbook01Vo> result = new ArrayList<>();
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			Class.forName("org.mariadb.jdbc.Driver");
//
//			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
//			conn = DriverManager.getConnection(url, "webdb", "webdb");
//
//			stmt = conn.createStatement();
//
//			String sql = "select no, name, contents, reg_date  from guestbook";
//
//			rs = stmt.executeQuery(sql);
//
//			while (rs.next()) {
//
//				int no = rs.getInt(1);
//				String name = rs.getString(2);
//				String contents = rs.getString(3);
//				Date regDate = rs.getDate(4);
//
//				Guestbook01Vo vo = new Guestbook01Vo();
//				vo.setNo(no);
//				vo.setName(name);
//				vo.setContents(contents);
//				vo.setRegDate(regDate);
//
//				result.add(vo);
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패 : " + e);
//		} catch (SQLException e) {
//			System.out.println("Error : " + e);
//		} finally {
//			try {
//				if (rs != null) { // 닫는 순서는 생성 역순으로
//					rs.close();
//				}
//				if (stmt != null) {
//					stmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return result;
//	}

//public Boolean insert(Guestbook01Vo vo) {
//boolean result = false;
//
//Connection conn = null;
//Statement stmt = null;
//
//try {
//	Class.forName("org.mariadb.jdbc.Driver");
//
//	String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
//	conn = DriverManager.getConnection(url, "webdb", "webdb");
//
//	stmt = conn.createStatement();
//
//	String sql = "insert into guestbook values(null, '" + vo.getName() + "', '" + vo.getPassword() + "', '"
//			+ vo.getContents() + "', now())";
//
//	int count = stmt.executeUpdate(sql);
//
//	result = count == 1;
//
//} catch (ClassNotFoundException e) {
//	System.out.println("드라이버 로딩 실패:" + e);
//} catch (SQLException e) {
//	System.out.println("Error:" + e);
//} finally {
//	try {
//		if (stmt != null) {
//			stmt.close();
//		}
//
//		if (conn != null) {
//			conn.close();
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//
//return result;
//}

//public Boolean deleteGuestbook(String password) {
//boolean result = false;
//
//Connection conn = null;
//Statement stmt = null;
//
//try {
//	Class.forName("org.mariadb.jdbc.Driver");
//
//	String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
//	conn = DriverManager.getConnection(url, "webdb", "webdb");
//
//	stmt = conn.createStatement();
//
//	String sql = "delete from guestbook where password = '" + password + "'";
//
//	int count = stmt.executeUpdate(sql);
//
//	result = count == 1;
//
//} catch (ClassNotFoundException e) {
//	System.out.println("드라이버 로딩 실패 : " + e);
//} catch (SQLException e) {
//	System.out.println("Error : " + e);
//} finally {
//	try {
//		if (stmt != null) {
//			stmt.close();
//		}
//		if (conn != null) {
//			conn.close();
//		}
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}
//return result;
//
//}
