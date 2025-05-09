package Models;

public class EmTimeKeepingM {
	private int idnv, awol, late;
	private String namemv, phonenv, work, status;
	public EmTimeKeepingM() {
	
	} 

	public EmTimeKeepingM(int idnv, String namemv, String phonenv, String work, int awol, int late,String status) {
		super();
		this.idnv = idnv;
		this.awol = awol;
		this.late = late;
		this.namemv = namemv;
		this.phonenv = phonenv;
		this.work = work;
		this.status = status;
	}

	public int getIdnv() {
		return idnv;
	}

	public void setIdnv(int idnv) {
		this.idnv = idnv;
	}

	public int getAwol() {
		return awol;
	}

	public void setAwol(int awol) {
		this.awol = awol;
	}

	public int getLate() {
		return late;
	}

	public void setLate(int late) {
		this.late = late;
	}

	public String getNamemv() {
		return namemv;
	}

	public void setNamemv(String namemv) {
		this.namemv = namemv;
	}

	public String getPhonenv() {
		return phonenv;
	}

	public void setPhone(String phone) {
		this.phonenv = phone;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
