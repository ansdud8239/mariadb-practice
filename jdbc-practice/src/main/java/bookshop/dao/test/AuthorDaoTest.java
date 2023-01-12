package bookshop.dao.test;

import java.util.List;

import bookshop.dao.AuthorDao;
import bookshop.vo.AuthorVo;

public class AuthorDaoTest {

	public static void main(String[] args) {
			testInsert();
			testFindAll();
			

	}
	private static void testInsert() {
		AuthorVo vo =null;
		AuthorDao dao = new AuthorDao();
		String[] AuthorNames = {"스테파니메이어","조정래","김동인","김난도","천상병","원수연"};
		
		for(int i=0;i<AuthorNames.length;i++) {
			vo = new AuthorVo();
			vo.setName(AuthorNames[i]);
			dao.insert(vo);
		}
		
	}
	private static void testFindAll() {
		List<AuthorVo> list=new AuthorDao().findAll();
		for(AuthorVo vo  : list) {
			System.out.println(vo);			
		}		
		
	}

}
