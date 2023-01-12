package bookshop.vo;

public class BookVo {
	private Long no;
	private String rent;
	private String title;
	private int authorNo;
	private String authorName;

	public BookVo() {
		this.rent = "N";
	}
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getRent() {
		return rent;
	}

	public void setRent(String rent) {
		this.rent = rent;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getAuthorNo() {
		return authorNo;
	}

	public void setAuthorNo(int authorNo) {
		this.authorNo = authorNo;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", rent=" + rent + ", title=" + title + ", authorNo=" + authorNo + ", authorName="
				+ authorName + "]";
	}

	

}
