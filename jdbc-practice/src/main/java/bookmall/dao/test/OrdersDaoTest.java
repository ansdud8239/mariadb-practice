package bookmall.dao.test;

import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {

		// 회원인 둘리가 카트에 있는 책을 구입할 경우
		OrdersVo vo1 = new OrdersVo();
		vo1.setName("둘리");
		vo1.setReceive("주소");
		testInsert(vo1);

		testFindOrder();
		testFindOrderBook();

	}

	private static void testInsert(OrdersVo vo) {
		new OrdersDao().insertOrder(vo);
	}

	private static void testFindOrder() {
		List<OrdersVo> list = new OrdersDao().findOrder();
		for (OrdersVo vo : list) {
			System.out.println(vo.orderList());
		}
	}

	private static void testFindOrderBook() {
		List<OrdersVo> list = new OrdersDao().findOrderBook();
		for (OrdersVo vo : list) {
			System.out.println(vo.orderBookList());
		}
	}

	public void orderList() {
		// 회원인 둘리가 카트에 있는 책을 구입할 경우
		OrdersVo vo1 = new OrdersVo();
		vo1.setName("둘리");
		vo1.setReceive("부산광역시 수영구");
		testInsert(vo1);

		testFindOrder();

	}
	public void orderBookList() {
		
		testFindOrderBook();

	}

}
