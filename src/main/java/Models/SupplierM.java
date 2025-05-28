package Models;

import java.sql.*;
import java.text.SimpleDateFormat;

public class SupplierM {
	private int ids, qtyproduct, priceoneproduct, totalcapital;
	private String names, phones, nameproduct, addresss;
	private byte[] image;
	private Date day;
	public String getFormattedDay() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(this.day);
	}
	public SupplierM() {
	}
	public SupplierM(int ids, String names, String phones, String addresss,
			String nameproduct, int qtyproduct, int priceoneproduct, int totalcapital,  byte[] image, Date day) {
		this.ids = ids;
		this.qtyproduct = qtyproduct;
		this.priceoneproduct = priceoneproduct;
		this.totalcapital = totalcapital;
		this.names = names;
		this.phones = phones;
		this.nameproduct = nameproduct;
		this.image = image;
		this.day = day;
		this.addresss = addresss;
	}
	public String getAddresss() {
		return addresss;
	}
	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}
	public int getIds() {
		return ids;
	}
	public void setIds(int ids) {
		this.ids = ids;
	}
	public int getQtyproduct() {
		return qtyproduct;
	}
	public void setQtyproduct(int qtyproduct) {
		this.qtyproduct = qtyproduct;
	}
	public int getPriceoneproduct() {
		return priceoneproduct;
	}
	public void setPriceoneproduct(int priceoneproduct) {
		this.priceoneproduct = priceoneproduct;
	}
	public int getTotalcapital() {
		return totalcapital;
	}
	public void setTotalcapital(int totalcapital) {
		this.totalcapital = totalcapital;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getNameproduct() {
		return nameproduct;
	}
	public void setNameproduct(String nameproduct) {
		this.nameproduct = nameproduct;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	
}
