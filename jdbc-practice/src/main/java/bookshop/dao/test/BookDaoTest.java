package bookshop.dao.test;

import bookshop.dao.BookDao;

import bookshop.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {
		testInsert();
	}

	private static void testInsert() {
		BookVo vo = null;
		BookDao dao = new BookDao();

		String[][] booklist = { 
				{ "트와일라잇", "1" }, 
				{ "뉴문", "1" }, 
				{ "이클립스", "1" },
				{ "브레이킹던", "1" }, 
				{ "아리랑", "2" }, 
				{ "젊은그들", "3" }, 
				{ "아프니깐 청춘이다", "4" }, 
				{ "귀천", "5" },
				{ "태백산맥", "2" }, 
				{ "풀하우스", "6" } 
				};
		
		for (int i = 0; i < booklist.length; i++) {
			vo = new BookVo();
			vo.setTitle(booklist[i][0]);
			vo.setAuthorNo(Integer.parseInt(booklist[i][1]));
			dao.insert(vo);
		}

	}

}
