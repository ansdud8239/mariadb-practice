package bookmall.vo;

import java.util.HashMap;

public class OrdersVo {

	private Long no;
	private String orderNo;
	private String name;
	private int price;
	private String receive;
	private HashMap<Integer, Integer> booklist;
	
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
	
	public HashMap<Integer, Integer> getBooklist() {
		return booklist;
	}
	public void setBooklist(HashMap<Integer, Integer> booklist) {
		this.booklist = booklist;
	}

	@Override
	public String toString() {
		return "OrdersVo [no=" + no + ", orderNo=" + orderNo + ", name=" + name + ", price=" + price + ", receive="
				+ receive + "]";
	}
	
	
}
