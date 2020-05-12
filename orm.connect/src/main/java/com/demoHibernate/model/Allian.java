package com.demoHibernate.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;

import com.demoHibernate.AllienName;

@Entity()
@Table(name = "alien_table")
public class Allian {

	@Id
	private int id;

	// @Transient
	// private String aName;

	private AllienName aName;

	@Column(name = "allien_color")
	private String color;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * public String getaName() { return aName; }
	 * 
	 * public void setaName(String aName) { this.aName = aName; }
	 */

	public String getColor() {
		return color;
	}

	public AllienName getaName() {
		return aName;
	}

	public void setaName(AllienName aName) {
		this.aName = aName;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Allian() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Allian [id=" + id + ", aName=" + aName + ", color=" + color + "]";
	}

}
