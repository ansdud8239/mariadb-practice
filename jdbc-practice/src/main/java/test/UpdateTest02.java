package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateTest02 {
	public static void main(String[] args) {
		DeptVo vo = new DeptVo();
		vo.setNo(1L);
		vo.setName("경영");
		// System.out.println("결과 : "+update(1L,"경영지원"));
		boolean result = update(vo);
		System.out.println(result == true ? "성공" : "실패");
	}

	public static boolean update(DeptVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean result = false;
		try {
			// 1. JDBC Driver Class 로딩
			Class.forName("org.mariadb.jdbc.Driver");

			// 2. 연결하기
			String url = "jdbc:mariadb://192.168.10.109:3307/webdb?charset=utf8";
			conn = DriverManager.getConnection(url, "webdb", "webdb");

			// 3. Statment생성
			String sql = "update dept set name=? where no=?";
			pstmt = conn.prepareStatement(sql);
			
			// 4. binding
			pstmt.setString(1, vo.getName());
			pstmt.setLong(2, vo.getNo());
			
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
