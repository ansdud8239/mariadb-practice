package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.OrdersVo;

public class OrdersDao {
	private static final int key = 0;

	public List<OrdersVo> findAll() {
		List<OrdersVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetion();
			String sql = "select a.no,b.name '책 이름',a.count '갯수',b.price '가격' from cart a join book b on a.book_no = b.no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
//				OrdersVo vo = new OrdersVo();
//				vo.setNo(rs.getLong(1));
//				vo.setName(rs.getString(2));
//				vo.setCount(rs.getInt(3));
//				vo.setPrice(rs.getInt(4));
//
//				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("OrderDao error: " + e);
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

	public void insert(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql="";
		int price = 0;
		int orderNo=0;
		ResultSet rs = null;
		try {
			
			conn = getConnetion();
			//가격 조회
			for(Integer key:vo.getBooklist().keySet()) {
				sql = "select price from book where no =?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, key);
				rs = pstmt.executeQuery();
				while(rs.next()) {
					price += rs.getInt(1);
				}
			}
			
			// orders테이블 insert
			sql = "insert into orders values('null',?,?,?,?,1)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getOrderNo());
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, price);
			pstmt.setString(4, vo.getReceive());
			
			pstmt.executeUpdate();
			
			
			sql = "select last_insert_id() as orders";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderNo=rs.getInt(1);
			}
			
			// order_book 테이블 insert
			for(Integer key:vo.getBooklist().keySet()) {
				sql = "insert into order_book values(?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, key);
				pstmt.setInt(2, orderNo);
				pstmt.setInt(3, vo.getBooklist().get(key));				
				pstmt.executeUpdate();
			}
			
			
			
			
			
		} catch (SQLException e) {
				System.out.println("OrderDao rollback error : " + e);
			System.out.println("OrderDao error : " + e);
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
