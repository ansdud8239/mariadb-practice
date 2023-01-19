package bookmall.vo;

public class OrdersVo {

	private Long no;
	private String orderNo;
	private String name;
	private int price;
	private String receive;
	private Long userNo;
	private String bookName;
	private int count;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String orderList() {
		return name + "님 주문 [주문번호= " + orderNo + ", 가격=" + price + ", 주소=" + receive + "]";
	}

	public String orderBookList() {
		return name + "님이 주문한 책 리스트 [책 번호= " + no + ", 책 제목=" + bookName + ", 개수=" + count + "권]";
	}

}
