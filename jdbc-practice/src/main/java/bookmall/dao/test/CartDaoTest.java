package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		CartVo vo1 = new CartVo();
		vo1.setCount(2);
		vo1.setBookNo(1l);
		vo1.setUserNo(1l);
		testInsert(vo1);
		testFindAll();

	}
	private static void testInsert(CartVo vo) {		
		new CartDao().insert(vo);
	}
	private static void testFindAll() {
		List<CartVo> list =new CartDao().findAll();
		for(CartVo vo:list) {
			System.out.println(vo);
		}
	}


}
