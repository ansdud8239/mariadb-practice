package bookmall.main;

import java.util.List;

import bookmall.dao.*;
import bookmall.vo.*;

public class BookMall {

	public static void main(String[] args) {

		insertBookMall();

		desplayBookMall();
	}

	public static void insertBookMall() {
		// 유저 생성
		UserVo userVo1 = new UserVo("둘리", "010-0123-0123", "dooly@gmail.com", "1234");
		UserVo userVo2 = new UserVo("문영", "010-0123-0123", "ansdud@gmail.com", "4567");
		new UserDao().insert(userVo1);
		new UserDao().insert(userVo2);

		// 카테고리 생성
		CategoryVo categoryVo1 = new CategoryVo();
		categoryVo1.setName("컴퓨터/IT");
		new CategoryDao().insert(categoryVo1);
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setName("소설");
		new CategoryDao().insert(categoryVo2);
		CategoryVo categoryVo3 = new CategoryVo();
		categoryVo3.setName("경제");
		new CategoryDao().insert(categoryVo3);

		// 상품 생성
		BookVo bookVo1 = new BookVo(2l, "불편한 편의점 2", 14000);
		new BookDao().insert(bookVo1);
		BookVo bookVo2 = new BookVo(1l, "혼자 공부하는 파이썬", 22000);
		new BookDao().insert(bookVo2);
		BookVo bookVo3 = new BookVo(3l, "트렌드 코리아 2023", 19000);
		new BookDao().insert(bookVo3);

		// 카트
		// 둘리 카트에 책 2개 추가
		CartVo cartVo1 = new CartVo(1L, 2, 1L);
		CartVo cartVo2 = new CartVo(2L, 3, 1L);
		new CartDao().insert(cartVo1);
		new CartDao().insert(cartVo2);

		// 주문
		// 회원인 둘리가 카트에 있는 책을 구입할 경우
		OrdersVo orderVo1 = new OrdersVo();
		orderVo1.setName("둘리");
		orderVo1.setReceive("부산광역시 수영구");
		new OrdersDao().insertOrder(orderVo1);

		// 주문 책 리스트
		// 둘리가 카트에 담은 책을 주문 책 리스트에 넣음

	}

	public static void desplayBookMall() {
		// 유저
		System.out.println("## 회원 리스트");
		List<UserVo> userList = new UserDao().findAll();
		for (UserVo vo : userList) {
			System.out.println(vo);

		}

		// 카테고리
		System.out.println("\n## 카테고리");
		List<CategoryVo> categoryList = new CategoryDao().findAll();
		for (CategoryVo vo : categoryList) {
			System.out.println(vo);
		}

		// 상품
		System.out.println("\n## 상품");
		List<BookVo> bookList = new BookDao().findAll();
		for (BookVo vo : bookList) {
			System.out.println(vo);
		}

		System.out.println("\n## 카트");
		List<CartVo> cartlList = new CartDao().findAll();
		for (CartVo vo : cartlList) {
			System.out.println(vo);
		}

		System.out.println("\n## 주문");
		List<OrdersVo> orderList = new OrdersDao().findOrder();
		for (OrdersVo vo : orderList) {
			System.out.println(vo.orderList());
		}

		System.out.println("\n## 주문 도서 리스트");
		List<OrdersVo> orderBookList = new OrdersDao().findOrderBook();
		for (OrdersVo vo : orderBookList) {
			System.out.println(vo.orderBookList());
		}
	}

}
