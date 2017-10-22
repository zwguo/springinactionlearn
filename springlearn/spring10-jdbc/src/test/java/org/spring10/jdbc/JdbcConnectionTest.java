package org.spring10.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import java.sql.PreparedStatement;

public class JdbcConnectionTest {

	/**
	 * 测试jdbc连接
	 * http://www.cnblogs.com/zfc2201/archive/2011/08/24/2152685.html
	 */
	@Test
	public void testconnection() {
		String url = "jdbc:mysql://127.0.0.1:3306/gzwdb01";
		String username = "root";
		String password = "123";
		String sql = "select * from t1;";
		String sql2 = "select * from t1 where name = ?;";
		Connection conn = null;
		try {
			//not necessary 
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("id:" + id + "\tname:" + name);
			}
			rs.close();
			st.close();
			
			PreparedStatement ps = conn.prepareStatement(sql2);
			ps.setString(1, "namea");
			rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println("id:" + id + "\tname:" + name);
			}
			rs.close();
			ps.close();
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
	}

}
