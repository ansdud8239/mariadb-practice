package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		BookVo vo1 = new BookVo(2l, "불편한 편의점 2", 14000);
		testInsert(vo1);

		BookVo vo2 = new BookVo(1l, " 혼자 공부하는 파이썬", 22000);
		testInsert(vo2);

		BookVo vo3 = new BookVo(3l, " 트렌드 코리아 2023", 19000);
		testInsert(vo3);

		testFindAll();

	}

	private static void testInsert(BookVo vo) {
		new BookDao().insert(vo);
	}

	private static void testFindAll() {
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println(vo);
		}
	}

	public void bookList() {
		BookVo vo1 = new BookVo(2l, "불편한 편의점 2", 14000);
		testInsert(vo1);

		BookVo vo2 = new BookVo(1l, " 혼자 공부하는 파이썬", 22000);
		testInsert(vo2);

		BookVo vo3 = new BookVo(3l, " 트렌드 코리아 2023", 19000);
		testInsert(vo3);

		testFindAll();

	}

}
