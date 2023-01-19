package bookmall.vo;

public class CartVo {
	private Long no;
	private String name;
	private int count;
	private int price;
	private Long bookNo;
	private Long userNo;
	private String userName;

	public CartVo() {
	}

	public CartVo(Long bookNo, int count, Long userNo) {
		this.bookNo = bookNo;
		this.count = count;
		this.userNo = userNo;
	}

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}

	public Long getUserNo() {
		return userNo;
	}

	public void setUserNo(Long userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return userName + "님 카트 (" + no + ") [책 이름= " + name + ", 개수=" + count + "권, 가격=" + price + "원 총 가격="
				+ count * price + "원]";
	}

}
