package com.qa.persistence.util;

import java.io.IOException;


import com.google.gson.Gson;
import com.qa.persistence.domain.Account;

public class JSONUtility {
	
	private Gson gson;

	public JSONUtility() {
		this.gson = new Gson();
	}

	public String getJSONForObject(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T getObjectForJSON(String jsonString, Class<T> classType) {
		return gson.fromJson(jsonString, classType);
	}
}
