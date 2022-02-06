package com.bankapp.bundle;

import java.util.ListResourceBundle;

public class NavBar extends ListResourceBundle {
	@Override
	public Object[][] getContents() {
		return contents;
	}

	static final Object[][] contents = { { "nav.Home", "Home" }, { "nav.Loans", "Loans" },
			{ "nav.Deposits", "Deposits" }, { "nav.Login", "Login" }, { "nav.Register", "Register" },
			{ "nav.AboutUs", "About Us" }, { "nav.ContactUS", "ContactUS" }, { "nav.Logout", "Logout" } };
}
