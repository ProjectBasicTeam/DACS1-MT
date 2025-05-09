package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class History2M {
	private int stt, quantityproduct,priceproduct,totalprice;
	private String Idhd, idproduct, nameproduct, brancha;
	private Date day;
	public String getFormattedDay() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(this.day);
	}
	public History2M() {
	}
	public History2M(int stt,String idhd, String idproduct, String nameproduct,int quantityproduct, int priceproduct, int totalprice,
			 Date day, String brancha) {
		super();
		this.stt = stt;
		this.quantityproduct = quantityproduct;
		this.priceproduct = priceproduct;
		this.totalprice = totalprice;
		Idhd = idhd;
		this.idproduct = idproduct;
		this.nameproduct = nameproduct;
		this.brancha = brancha;
		this.day = day;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getQuantityproduct() {
		return quantityproduct;
	}
	public void setQuantityproduct(int quantityproduct) {
		this.quantityproduct = quantityproduct;
	}
	public int getPriceproduct() {
		return priceproduct;
	}
	public void setPriceproduct(int priceproduct) {
		this.priceproduct = priceproduct;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public String getIdhd() {
		return Idhd;
	}
	public void setIdhd(String idhd) {
		Idhd = idhd;
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
	public String getBrancha() {
		return brancha;
	}
	public void setBrancha(String brancha) {
		this.brancha = brancha;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
}
