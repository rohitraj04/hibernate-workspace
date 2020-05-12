package com.mapping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	@Id
	private int sId;
	private String sName;

	/**
	 * Case 1: Below are the commented Code for One To One Mapping
	 * 
	 * @OneToOne private Laptop laptop;
	 * 
	 * 
	 *           public Laptop getLaptop() { return laptop; }
	 * 
	 *           public void setLaptop(Laptop laptop) { this.laptop = laptop; }
	 * 
	 */
	// CASE :2 one To Many

	
//	 * @OneToMany(mappedBy= "student") private List<Laptop> laptop = new
//	 * ArrayList<Laptop>();
//	 * 
//	 * 
//	 * public List<Laptop> getLaptop() { return laptop; }
//	 * 
//	 * public void setLaptop(List<Laptop> laptop) { this.laptop = laptop; }
	 
	@ManyToMany(mappedBy="student")
	private List<Laptop> laptop = new ArrayList<>();

	public List<Laptop> getLaptop() {
		return laptop;
	}

	public void setLaptop(List<Laptop> laptop) {
		this.laptop = laptop;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

}
