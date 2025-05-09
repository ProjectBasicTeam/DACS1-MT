package Models;

public class PurchaseM {
	private String name, id;
	private int price, qty;
	private byte[] image;
	public PurchaseM() {
	}
	public PurchaseM(String id, String name, int price, byte[] image, int qty) {
		this.name = name;
		this.id = id;
		this.price = price;
		this.qty = qty;
		this.image = image;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
}
