package com.cts.grizzly_store.service;

import com.cts.grizzly_store.bean.Login;

public interface LoginService {

	public String getUserType(String userId);
	public Login authenticate(String userName, String password);
}
