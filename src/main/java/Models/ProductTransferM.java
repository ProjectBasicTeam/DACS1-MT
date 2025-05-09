package Models;

public class ProductTransferM {
	private int stt, qty;
	private String idproduct, brancha, address;
	public ProductTransferM() {	}
	public ProductTransferM(int stt, String brancha, String address, String idproduct, int qty) {
		this.stt = stt;
		this.qty = qty;
		this.idproduct = idproduct;
		this.brancha = brancha;
		this.address = address;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public String getBrancha() {
		return brancha;
	}
	public void setBrancha(String brancha) {
		this.brancha = brancha;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
