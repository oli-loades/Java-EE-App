package com.qa.persistence.util;

import java.lang.reflect.Type;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.qa.persistence.domain.Transaction;

public class TransactionAdapter implements JsonSerializer<Transaction> {

	public JsonElement serialize(Transaction tranaction, Type type, JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", tranaction.getId());
		jsonObject.addProperty("name", tranaction.getName());
		return jsonObject;
	}

}
