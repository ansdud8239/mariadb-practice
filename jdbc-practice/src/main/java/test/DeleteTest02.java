package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteTest02 {
	public static void main(String[] args) {
		System.out.println("결과 : " + delete(5L));
	}

	public static boolean delete(Long no) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.10.109:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statment 준비
			String sql = "delete from dept where no=?";
			pstmt = conn.prepareStatement(sql);

			// 4. binding
			pstmt.setLong(1, no);
			
			// 5. sql 실행
			int count = pstmt.executeUpdate();

			result = count == 1;

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		} catch (SQLException e) {
			System.out.println("error: " + e);
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
}
