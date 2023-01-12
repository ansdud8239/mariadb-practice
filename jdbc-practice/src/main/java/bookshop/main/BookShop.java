package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDao;
import bookshop.vo.BookVo;

public class BookShop {

	public static void main(String[] args) {

		displayBookInfo();

		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Long no = scanner.nextLong();
		scanner.close();

		if (!(new BookDao().findRent(no))) {
			System.out.println("대여중입니다.");
		} else {
			BookVo vo = new BookVo();
			vo.setNo(no);
			vo.setRent("Y");

			boolean result = new BookDao().update(vo);
			
			if (result) {
				rent(no);
			}
		}
		displayBookInfo();
	}

	private static void displayBookInfo() {
		System.out.println("*****도서 정보 출력하기******");
		List<BookVo> list = new BookDao().findAll();
		for (BookVo vo : list) {
			System.out.println("("+vo.getNo()+") 책 제목:" + vo.getTitle() + ", " + "작가:" + vo.getAuthorName() + ", " + "대여 유무:"
					+ (vo.getRent().equals("Y") ? "대여중" : "재고있음"));

		}
	}

	public static void rent(Long no) {
		String title = new BookDao().findTitle(no);

		System.out.println(title + "이(가) 대여 됐습니다");

	}

}
