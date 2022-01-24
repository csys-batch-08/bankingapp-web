package com.bankapp.dao;

import java.util.List;

import com.bankapp.model.AdminUse;

public interface AdminUseDao {
	public boolean getDescriptionId(double desc_id,double rateOfInterest);
	public List<AdminUse> allDetails();
}
