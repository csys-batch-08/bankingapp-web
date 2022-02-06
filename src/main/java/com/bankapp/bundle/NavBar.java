package com.bankapp.bundle;

import java.util.ListResourceBundle;

public class NavBar extends ListResourceBundle {
	@Override
	public Object[][] getContents() {
		return contents;
	}

	static final Object[][] contents = { { "nav.Loans", "Loans" }, { "nav.Deposits", "Deposits" },
			{ "nav.login", "login" }, { "nav.Register", "Register" }, { "nav.Contact Us", "Contact Us" } };
}
