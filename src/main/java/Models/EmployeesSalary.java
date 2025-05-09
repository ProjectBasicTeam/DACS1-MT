package Models;

public class EmployeesSalary {
	private int idnv,shiftnv,salaryshiftnv,salarynv, late, awol;
	private String namenv, banknv, worknv, phonenv, brancha;
	public EmployeesSalary() {
		 
	}
	public EmployeesSalary(int idnv, String namenv, String phonenv, String brancha, String worknv, String banknv, int shiftnv, int salaryshiftnv, int salarynv, int late, int awol) {
		this.idnv = idnv;
		this.shiftnv = shiftnv;
		this.salaryshiftnv = salaryshiftnv;
		this.salarynv = salarynv;
		this.namenv = namenv;
		this.banknv = banknv;
		this.worknv = worknv;
		this.phonenv = phonenv;
		this.brancha = brancha;
		this.late = late;
		this.awol = awol;
	}
	public int getIdnv() {
		return idnv;
	}
	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}
	public int getShiftnv() {
		return shiftnv;
	}
	public void setShiftnv(int shiftnv) {
		this.shiftnv = shiftnv;
	}
	public int getSalaryshiftnv() {
		return salaryshiftnv;
	}
	public void setSalaryshiftnv(int salaryshiftnv) {
		this.salaryshiftnv = salaryshiftnv;
	}
	public int getSalarynv() {
		return salarynv;
	}
	public void setSalarynv(int salarynv) {
		this.salarynv = salarynv;
	}
	public String getNamenv() {
		return namenv;
	}
	public void setNamenv(String namenv) {
		this.namenv = namenv;
	}
	public String getBanknv() {
		return banknv;
	}
	public void setBanknv(String banknv) {
		this.banknv = banknv;
	}
	public String getWorknv() {
		return worknv;
	}
	public void setWorknv(String worknv) {
		this.worknv = worknv;
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
	public int getLate() {
		return late;
	}
	public void setLate(int late) {
		this.late = late;
	}
	public int getAwol() {
		return awol;
	}
	public void setAwol(int awol) {
		this.awol = awol;
	}
	
	
}
