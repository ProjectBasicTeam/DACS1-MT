package Models;
public class Account {
	private int ida;
	private String namea, passworda, brancha, addressa, phonea, rolea;
	public Account() {}
	public Account(int ida, String namea, String passworda, String brancha, String addressa, String phonea, String rolea) {
		this.ida = ida;
		this.namea = namea;
		this.passworda = passworda;
		this.brancha = brancha;
		this.addressa = addressa;
		this.phonea = phonea;
		this.rolea = rolea;
	}
	public int getIda() {
		return ida;
	}
	public void setIda(int ida) {
		this.ida = ida;
	}
	public String getNamea() {
		return namea;
	}
	public void setNamea(String namea) {
		this.namea = namea;
	}
	public String getPassworda() {
		return passworda;
	}
	public void setPassworda(String passworda) {
		this.passworda = passworda;
	}
	public String getBrancha() {
		return brancha;
	}
	public void setBrancha(String brancha) {
		this.brancha = brancha;
	}
	public String getAddressa() {
		return addressa;
	}
	public void setAddressa(String addressa) {
		this.addressa = addressa;
	}
	public String getPhonea() {
		return phonea;
	}
	public void setPhonea(String phonea) {
		this.phonea = phonea;
	}
	public String getRolea() {
		return rolea;
	}
	public void setRolea(String rolea) {
		this.rolea = rolea;
	}
}
