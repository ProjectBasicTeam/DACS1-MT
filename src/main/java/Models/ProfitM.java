package Models;

import java.sql.Date;

public class ProfitM {
	private int totalprice;
	private Date day;
	public ProfitM() {
	}
	public ProfitM(int totalprice, Date day) {
		this.totalprice = totalprice;
		this.day = day;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
}
