package com.fetch.eager.hibernate_fetch_eager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Allien {

	@Id
	private int aId;
	private String aName;

	@OneToMany(mappedBy = "allien",fetch=FetchType.EAGER)
	private List<Laptop> laptop = new ArrayList<>();

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getaName() {
		return aName;
	}

	public void setaName(String aName) {
		this.aName = aName;
	}

	@Override
	public String toString() {
		return "Allien [aId=" + aId + ", aName=" + aName + ", laptop=" + laptop + "]";
	}

	
}
