package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao {

	// 카트에 담긴 책 정보
	public List<CartVo> findAll() {
		List<CartVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetion();
			String sql = "select c.name,a.no,b.name '책 이름',a.count '갯수',b.price '가격' from cart a "
					+ "join book b on a.book_no = b.no " + "join user c on c.no = a.user_no " + "order by c.name,a.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				CartVo vo = new CartVo();
				vo.setUserName(rs.getString(1));
				vo.setNo(rs.getLong(2));
				vo.setName(rs.getString(3));
				vo.setCount(rs.getInt(4));
				vo.setPrice(rs.getInt(5));

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

	public void insert(CartVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetion();

			String sql = "insert into cart values('null',?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCount());
			pstmt.setLong(2, vo.getBookNo());
			pstmt.setLong(3, vo.getUserNo());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("CartDao error : " + e);
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
