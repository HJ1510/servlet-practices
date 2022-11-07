package com.bitacademy.guestbook01.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bitacademy.guestbook01.vo.Guestbook01Vo;

public class Guestbook01Dao {

	public List<Guestbook01Vo> findAll() {
		List<Guestbook01Vo> result = new ArrayList<>();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			stmt = conn.createStatement();

			String sql = "select no, name, contents, date_format(reg_date, '%Y/%m/%d %H:%i:%s')  from guestbook";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int no= rs.getInt(1);
				String name = rs.getString(2);
				String contents = rs.getString(3);
				Date date = rs.getDate(4);
						
				Guestbook01Vo vo = new Guestbook01Vo();
				vo.setNo(no);
				vo.setName(name);
				vo.setContents(contents);
				vo.setRegDate(date);

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
				if (stmt != null) {
					stmt.close();
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

}
