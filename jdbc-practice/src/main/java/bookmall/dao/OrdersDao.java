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

	public List<OrdersVo> findOrder() {
		List<OrdersVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetion();
			String sql = "select order_no,name,price,receive from orders";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrdersVo vo = new OrdersVo();
				vo.setOrderNo(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setPrice(rs.getInt(3));
				vo.setReceive(rs.getString(4));

				result.add(vo);
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

	public List<OrdersVo> findOrderBook() {
		List<OrdersVo> result = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetion();
			String sql = "select b.no,b.name,a.count,c.name from order_book a "
					+ "join book b on a.book_no=b.no "
					+ "join orders c on c.no=a.orders_no";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				OrdersVo vo = new OrdersVo();
				vo.setNo(rs.getLong(1));
				vo.setBookName(rs.getString(2));
				vo.setCount(rs.getInt(3));
				vo.setName(rs.getString(4));

				result.add(vo);
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
	public void insertOrder(OrdersVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int price = 0;
		int autoNum = selectAutoNum();
		ResultSet rs = null;
		try {

			conn = getConnetion();
			// 가격 조회
			sql = "select count*price from cart a join book b on a.book_no=b.no where user_no=(select no from user where name=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				price += rs.getInt(1);
			}

			// orders테이블 insert
			sql = "insert into orders values('null',concat((date_format(now(),'%Y%m%d')),'-',lpad(?,8,0)),?,?,?,(select no from user where name=?))";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, autoNum);
			pstmt.setString(2, vo.getName());
			pstmt.setInt(3, price);
			pstmt.setString(4, vo.getReceive());
			pstmt.setString(5, vo.getName());

			pstmt.executeUpdate();

			insertOrderBook(vo,autoNum);

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

	public void insertOrderBook(OrdersVo vo,int autoNum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		
		ResultSet rs = null;
		try {

			conn = getConnetion();

			sql = "select book_no,count from cart where user_no=(select no from user where name=?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getName());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				sql = "insert into order_book values (?,?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setLong(1, rs.getInt(1));
				pstmt.setInt(2, autoNum);
				pstmt.setLong(3, rs.getInt(2));
				pstmt.executeUpdate();
			}

		} catch (SQLException e) {
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

	private static int selectAutoNum() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "";
		int autoNum = 0;
		ResultSet rs = null;
		try {

			conn = getConnetion();

			sql ="SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name = 'orders' AND table_schema = 'bookmall';";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				autoNum = rs.getInt(1);
			}


		} catch (SQLException e) {
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
		return autoNum;
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
