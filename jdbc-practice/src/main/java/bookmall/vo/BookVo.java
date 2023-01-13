package bookmall.vo;

public class BookVo {
	private Long no;
	private String name;
	private int price;
	private Long categoryNo;
	private String categoryName;
	
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	public Long getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(Long categoryNo) {
		this.categoryNo = categoryNo;
	}

	
	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "[책 번호=" + no + ", 책 제목= " + name +  ", 카테고리= " + categoryName+", 책 가격= " + price + "원]";
	}

	

}
