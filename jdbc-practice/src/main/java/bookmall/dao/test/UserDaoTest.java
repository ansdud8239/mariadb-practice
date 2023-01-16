package bookmall.dao.test;

import java.util.List;

import bookmall.dao.UserDao;
import bookmall.vo.UserVo;

public class UserDaoTest {

	public static void main(String[] args) {
		UserVo vo1 = new UserVo("둘리", "010-0123-0123", "dooly@gmail.com", "1234");
		UserVo vo2 = new UserVo("문영", "010-0123-0123", "ansdud@gmail.com", "4567");
		testInsert(vo1);
		testInsert(vo2);
		testFindAll();
	}

	private static void testInsert(UserVo vo) {
		new UserDao().insert(vo);
	}

	private static void testFindAll() {
		List<UserVo> list = new UserDao().findAll();
		for (UserVo vo : list) {
			System.out.println(vo);

		}
	}
	public void userList() {
		UserVo vo1 = new UserVo("둘리", "010-0123-0123", "dooly@gmail.com", "1234");
		UserVo vo2 = new UserVo("문영", "010-0123-0123", "ansdud@gmail.com", "4567");
		new UserDao().insert(vo1);
		new UserDao().insert(vo2);
		
		List<UserVo> list = new UserDao().findAll();
		for (UserVo vo : list) {
			System.out.println(vo);

		}
	}



}
