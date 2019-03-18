package com.cts.grizzly_store.dao;

import com.cts.grizzly_store.bean.Login;

public interface LoginDAO {

	public String getUserType(String userId);
	public Login authenticate(String userName, String password);
}
