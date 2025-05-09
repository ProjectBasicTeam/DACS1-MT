package Models;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class InfoBuyM {
	private int stt, totalprice, totalqty;
	private String idhd, phonecustomer, hour;
	private Date day;
	public String getFormattedDay() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(this.day);
	}
	public InfoBuyM() {
	}
	public InfoBuyM(int stt, String idhd,  int totalprice, int totalqty, String phonecustomer, String hour, Date day) {
		super();
		this.stt = stt;
		this.totalprice = totalprice;
		this.totalqty = totalqty;
		this.idhd = idhd;
		this.phonecustomer = phonecustomer;
		this.hour = hour;
		this.day = day;
	}
	public int getStt() {
		return stt;
	}
	public void setStt(int stt) {
		this.stt = stt;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public int getTotalqty() {
		return totalqty;
	}
	public void setTotalqty(int totalqty) {
		this.totalqty = totalqty;
	}
	public String getIdhd() {
		return idhd;
	}
	public void setIdhd(String idhd) {
		this.idhd = idhd;
	}
	public String getPhonecustomer() {
		return phonecustomer;
	}
	public void setPhonecustomer(String phonecustomer) {
		this.phonecustomer = phonecustomer;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
}
