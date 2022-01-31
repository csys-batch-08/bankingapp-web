package com.bankapp.dao;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.model.AdminUse;

public interface AdminUseDao {
	public boolean getDescriptionId(double desc_id,double rateOfInterest) throws SQLException;
	public List<AdminUse> allDetails() throws SQLException;
}
