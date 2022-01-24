package com.bankapp.model;

import java.util.Objects;

public class AdminUse {
	private String categoryName;
	private String categoryType;
	private String description;
	private  double descriptionId;
	private double rateOfInterest;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getDescriptionId() {
		return descriptionId;
	}
	public void setDescriptionId(double descriptionId) {
		this.descriptionId = descriptionId;
	}
	public double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	public AdminUse(String categoryName, String categoryType, String description, double descriptionId,
			double rateOfInterest) {
		super();
		this.categoryName = categoryName;
		this.categoryType = categoryType;
		this.description = description;
		this.descriptionId = descriptionId;
		this.rateOfInterest = rateOfInterest;
	}
	public AdminUse() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoryName, categoryType, description, descriptionId, rateOfInterest);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminUse other = (AdminUse) obj;
		return Objects.equals(categoryName, other.categoryName) && Objects.equals(categoryType, other.categoryType)
				&& Objects.equals(description, other.description)
				&& Double.doubleToLongBits(descriptionId) == Double.doubleToLongBits(other.descriptionId)
				&& Double.doubleToLongBits(rateOfInterest) == Double.doubleToLongBits(other.rateOfInterest);
	}
	@Override
	public String toString() {
		return "AdminUse [categoryName=" + categoryName + ", categoryType=" + categoryType + ", description="
				+ description + ", descriptionId=" + descriptionId + ", rateOfInterest=" + rateOfInterest + "]";
	}


}
