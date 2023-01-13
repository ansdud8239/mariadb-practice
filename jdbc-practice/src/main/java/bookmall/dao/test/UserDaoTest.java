package bookmall.dao.test;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		UserVo vo = new UserVo("둘리","010-0123-0123","dooly@gmail.com","1234");
//		vo.setName("둘리");
//		vo.setPhoneNum("010-0123-0123");
//		vo.setEmail("dooly@gmail.com");
//		vo.setPassword("1234");
		testInsert(vo);
		testFindAll();
	}
	private static void testInsert(UserVo vo) {
		
		new UserDao().insert(vo);
	}
	private static void testFindAll() {
		List<UserVo> list = new UserDao().findAll();
		for(UserVo vo:list) {
			System.out.println(vo);
		}
	}


}
