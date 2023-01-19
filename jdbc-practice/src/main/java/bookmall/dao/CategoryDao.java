package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao {

	public List<CategoryVo> findAll() {
		List<CategoryVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetion();
			String sql = "select * from category";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CategoryVo vo = new CategoryVo();
				vo.setNo(rs.getLong(1));
				vo.setName(rs.getString(2));
				result.add(vo);
			}

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

	public void insert(CategoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetion();

			String sql = "insert into category values('null',?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("UserDao error : " + e);
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

	}

	private static Connection getConnetion() throws SQLException {
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");

			String url = "jdbc:mariadb://" + UserDao.IP + ":3307/bookmall?charset=utf8";
			conn = DriverManager.getConnection(url, "bookmall", "bookmall");

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패: " + e);
		}
		return conn;

	}
}
