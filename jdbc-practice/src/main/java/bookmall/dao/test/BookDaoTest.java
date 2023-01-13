package bookmall.dao.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;


public class BookDaoTest {

	public static void main(String[] args) {
		BookVo vo1 = new BookVo();
		vo1.setName("스카이 버스");
		vo1.setPrice(16200);
		vo1.setCategoryNo(1l);
		testInsert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setName("만일 내가 인생을 다시 산다면 (10만 부 기념 스페셜 에디션)");
		vo2.setPrice(15480);
		vo2.setCategoryNo(2l);
		testInsert(vo2);
		testFindAll();

	}
	private static void testInsert(BookVo vo) {		
		new BookDao().insert(vo);
	}
	private static void testFindAll() {
		List<BookVo> list =new BookDao().findAll();
		for(BookVo vo:list) {
			System.out.println(vo);
		}
	}

}
