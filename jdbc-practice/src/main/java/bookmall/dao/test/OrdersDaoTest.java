package bookmall.dao.test;

import java.util.HashMap;
import java.util.List;

import bookmall.dao.OrdersDao;
import bookmall.vo.OrdersVo;

public class OrdersDaoTest {

	public static void main(String[] args) {
		
		// 주문할 책 리스트
		// key : booknum . value : 수량(권)
		HashMap<Integer, Integer> booklist = new HashMap<>();
		booklist.put(1, 2);
		booklist.put(2, 1);
		
		OrdersVo vo1 = new OrdersVo();
		vo1.setName("둘리");
		vo1.setReceive("주소");
		vo1.setOrderNo("20230113-00000002");
		vo1.setBooklist(booklist);
		testInsert(vo1);
		
		//testFindAll();

	}

	private static void testInsert(OrdersVo vo) {
		new OrdersDao().insert(vo);
	}

	private static void testFindAll() {
		List<OrdersVo> list = new OrdersDao().findAll();
		for (OrdersVo vo : list) {
			System.out.println(vo);
		}
	}
}
