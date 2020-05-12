package com.hibernate.cache.model;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity(name = "Allien_cache")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Allien {

	@Id
	private int aId;
	private String aName;
	private String aColor;

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

	public String getaColor() {
		return aColor;
	}

	public void setaColor(String aColor) {
		this.aColor = aColor;
	}

	@Override
	public String toString() {
		return "Allien [aId=" + aId + ", aName=" + aName + ", aColor=" + aColor + "]";
	}

}
