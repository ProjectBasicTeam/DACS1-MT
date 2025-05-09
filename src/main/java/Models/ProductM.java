package Models;

public class ProductM {
	private String idproduct, nameproduct;
	private int stt, priceproduct, qtyproduct;
	private byte []image;
	public ProductM() {
	}
	public ProductM(int stt,String idproduct, String nameproduct, int priceproduct, int qtyproduct, byte[] image) {
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.priceproduct = priceproduct;
		this.qtyproduct = qtyproduct;
		this.image = image;
		this.stt =stt;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public String getIdproduct() {
		return idproduct;
	}
	public void setIdproduct(String idproduct) {
		this.idproduct = idproduct;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	public int getPriceproduct() {
		return priceproduct;
	}
	public void setPriceproduct(int priceproduct) {
		this.priceproduct = priceproduct;
	}
	public int getQtyproduct() {
		return qtyproduct;
	}
	public void setQtyproduct(int qtyproduct) {
		this.qtyproduct = qtyproduct;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
}
