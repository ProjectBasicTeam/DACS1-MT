package Models;

public class ProductM2 {
	private String id, name;
	private int qty;
	public ProductM2() {
		
	}
	public ProductM2(String id, String name, int qty) {
		super();
		this.id = id;
		this.name = name;
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
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
}
