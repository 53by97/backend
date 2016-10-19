package com.crossover.trial.javase.util;

import java.lang.reflect.Type;

import com.crossover.trial.javase.entities.Customer;
import com.crossover.trial.javase.entities.Product;
import com.crossover.trial.javase.entities.SalesOrder;
import com.google.gson.reflect.TypeToken;

public class BackendAPIsUtil {

	public static Type getClassType(int objectType) {
		Type type = null;

		switch (objectType) {
		case 1:
			type = new TypeToken<Product>() {
			}.getType();
			break;
		case 2:
			type = new TypeToken<Customer>() {
			}.getType();
			break;
		case 3:
			type = new TypeToken<SalesOrder>() {
			}.getType();
			break;
		default:
			break;
		}
		return type;
	}
}
