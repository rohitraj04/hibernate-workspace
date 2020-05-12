package com.demoHibernate;

import javax.persistence.Embeddable;

@Embeddable
public class AllienName {

	private String fName;
	private String LName;
	private String MName;

	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	@Override
	public String toString() {
		return "AllienName [fName=" + fName + ", LName=" + LName + ", MName=" + MName + "]";
	}

	
}
