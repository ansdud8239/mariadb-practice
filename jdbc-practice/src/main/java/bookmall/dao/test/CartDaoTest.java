package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {
		CartVo vo1 = new CartVo(1L, 2, 1L);
		CartVo vo2 = new CartVo(2L, 3, 1L);
		testInsert(vo1);
		testInsert(vo2);

		testFindAll();

	}

	private static void testInsert(CartVo vo) {
		new CartDao().insert(vo);
	}

	private static void testFindAll() {
		List<CartVo> list = new CartDao().findAll();
		for (CartVo vo : list) {
			System.out.println(vo);
		}
	}

	public void cart() {
		CartVo vo1 = new CartVo(1L, 2, 1L);
		CartVo vo2 = new CartVo(2L, 3, 1L);
		testInsert(vo1);
		testInsert(vo2);
		testFindAll();
	}

}
