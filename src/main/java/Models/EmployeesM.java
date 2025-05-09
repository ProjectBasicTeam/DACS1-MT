package Models;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeesM {
	private int idnv;
	private String namenv, cccdnv, gendernv, phonenv, brancha, worknv;
	private Date birth;
	public String getFormattedBirth() {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    return sdf.format(this.birth);
	}
	public EmployeesM() {
	} 
	public EmployeesM(int idnv, String namenv,  String gendernv, String phonenv, String cccdnv,Date birth, String worknv, String brancha) {
		super();
		this.idnv = idnv;
		this.namenv = namenv;
		this.cccdnv = cccdnv;
		this.gendernv = gendernv;
		this.phonenv = phonenv;
		this.brancha = brancha;
		this.worknv = worknv;
		this.birth = birth;
	}
	public int getIdnv() {
		return idnv;
	}
	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}
	public String getNamenv() {
		return namenv;
	}
	public void setNamenv(String namenv) {
		this.namenv = namenv;
	}
	public String getCccdnv() {
		return cccdnv;
	}
	public void setCccdnv(String cccdnv) {
		this.cccdnv = cccdnv;
	}
	public String getGendernv() {
		return gendernv;
	}
	public void setGendernv(String gendernv) {
		this.gendernv = gendernv;
	}
	public String getPhonenv() {
		return phonenv;
	}
	public void setPhonenv(String phonenv) {
		this.phonenv = phonenv;
	}
	public String getBrancha() {
		return brancha;
	}
	public void setBrancha(String brancha) {
		this.brancha = brancha;
	}
	public String getWorknv() {
		return worknv;
	}
	public void setWorknv(String worknv) {
		this.worknv = worknv;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
