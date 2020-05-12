package com.fetch.eager.hibernate_fetch_eager.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name= "Lapi")
public class Laptop {

	
	@Id
	private int lId;
	
	private String lName;
	
	@ManyToOne
	private Allien allien;
	
	

	public Allien getAllien() {
		return allien;
	}

	public void setAllien(Allien allien) {
		this.allien = allien;
	}

	public int getlId() {
		return lId;
	}

	public void setlId(int lId) {
		this.lId = lId;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

//	@Override
//	public String toString() {
//		return "Laptop [lId=" + lId + ", lName=" + lName + ", allien=" + allien + "]";
//	}
	
	
}
