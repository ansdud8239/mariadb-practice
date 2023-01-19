package bookmall.dao.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("컴퓨터/IT");
		testInsert(vo1);

		CategoryVo vo2 = new CategoryVo();
		vo2.setName("소설");
		testInsert(vo2);

		CategoryVo vo3 = new CategoryVo();
		vo3.setName("경제");
		testInsert(vo3);

		testFindAll();
	}

	private static void testInsert(CategoryVo vo) {
		new CategoryDao().insert(vo);
	}

	private static void testFindAll() {
		List<CategoryVo> list = new CategoryDao().findAll();
		for (CategoryVo vo : list) {
			System.out.println(vo);
		}
	}

	public void cagegoryList() {
		CategoryVo vo1 = new CategoryVo();
		vo1.setName("컴퓨터/IT");
		testInsert(vo1);

		CategoryVo vo2 = new CategoryVo();
		vo2.setName("소설");
		testInsert(vo2);

		CategoryVo vo3 = new CategoryVo();
		vo3.setName("경제");
		testInsert(vo3);

		testFindAll();

	}
}
