package Models;

public class TempPurchaseM {
	private String id, name;
	private int price, qty;
	public TempPurchaseM() {
	}
	public TempPurchaseM(String id, String name,int qty, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.qty = qty;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
