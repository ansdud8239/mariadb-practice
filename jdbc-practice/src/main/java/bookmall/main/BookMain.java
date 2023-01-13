package bookmall.main;

import java.util.List;

import bookmall.dao.*;
import bookmall.vo.*;

public class BookMain {

	public static void main(String[] args) {
		System.out.println("## 회원 리스트");		
		
		List<UserVo> Userlist =new UserDao().findAll();
		for(UserVo vo:Userlist) {
			System.out.println(vo);
		}
		
		System.out.println("\n## 카테고리");
		List<CategoryVo> Categorylist =new CategoryDao().findAll();
		for(CategoryVo vo:Categorylist) {
			System.out.println(vo);
		}
		
		System.out.println("\n## 상품");		
		List<BookVo> Booklist =new BookDao().findAll();
		for(BookVo vo:Booklist) {
			System.out.println(vo);
		}
		
		System.out.println("\n## 카트");
		List<CartVo> Cartlist =new CartDao().findAll();
		for(CartVo vo:Cartlist) {
			System.out.println(vo);
		}
		System.out.println("\n## 주문");

		System.out.println("\n## 주문 도서 리스트");

		
	}


}
