package bookmall.main;


import bookmall.dao.test.*;

public class BookMall {

	public static void main(String[] args) {
		System.out.println("## 회원 리스트");		
		
		new UserDaoTest().userList();;
		
		System.out.println("\n## 카테고리");
		new CategoryDaoTest().cagegoryList();
		
		System.out.println("\n## 상품");		
		new BookDaoTest().bookList();
		
		System.out.println("\n## 카트");
		new CartDaoTest().cart();
		
		System.out.println("\n## 주문");
		new OrdersDaoTest().orderList();

		System.out.println("\n## 주문 도서 리스트");
		new OrdersDaoTest().orderBookList();
		
	}


}
