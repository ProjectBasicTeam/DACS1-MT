package Models;

public class BuyItemM {
	private String idproduct, name, brancha, idhd;
	private int stt, price, qty, totalprice;
	public BuyItemM(int stt, String idproduct, String name,int qty, int price, int totalprice,String brancha, String idhd) {
		super();
		this.idproduct = idproduct;
		this.name = name;
		this.brancha = brancha;
		this.idhd = idhd;
		this.stt = stt;
		this.price = price;
		this.qty = qty;
		this.totalprice = totalprice;
	}
	
	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrancha() {
		return brancha;
	}
	public void setBrancha(String brancha) {
		this.brancha = brancha;
	}
	public String getIdhd() {
		return idhd;
	}
	public void setIdhd(String idhd) {
		this.idhd = idhd;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
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
