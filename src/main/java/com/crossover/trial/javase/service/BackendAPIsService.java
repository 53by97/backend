package com.crossover.trial.javase.service;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.crossover.trial.javase.dao.BackendAPIsDAO;
import com.crossover.trial.javase.entities.Customer;
import com.crossover.trial.javase.entities.OrderItem;
import com.crossover.trial.javase.entities.Product;
import com.crossover.trial.javase.entities.SalesOrder;
import com.crossover.trial.javase.util.BackendAPIsUtil;
import com.google.gson.Gson;

public class BackendAPIsService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(BackendAPIsService.class);

	private BackendAPIsDAO dao = new BackendAPIsDAO();
	private Gson gson = new Gson();

	public String getCurrentRecords(int type) {
		List list = null;
		switch (type) {
		case 1:
			list = dao.list(Product.class);
			break;
		case 2:
			list = dao.list(Customer.class);
			break;
		case 3:
			list = dao.list(SalesOrder.class);
			break;
		default:
			break;
		}
		return gson.toJson(list);
	}

	public String getRecord(int type, int code) {
		Object object = getRecordFromTypeAndCode(type, code);
		return gson.toJson(object);
	}

	public String deleteRecord(int type, int code) {
		Object object = getRecordFromTypeAndCode(type, code);
		dao.delete(object);
		return "true";
	}

	public String saveRecord(int objectType, String jsonString)
			throws Exception {
		Type type = BackendAPIsUtil.getClassType(objectType);
		Object object = gson.fromJson(jsonString, type);
		if (objectType == 3) { // validating sales order before saving it
			SalesOrder order = (SalesOrder) object;
			Customer customer = order.getCustomer();
			customer = dao.read(Customer.class, customer.getCustId());

			BigDecimal currentCredit = customer.getCurrentCredit();
			if (currentCredit == null) {
				currentCredit = BigDecimal.ZERO;
			}
			BigDecimal currentLimit = customer.getCreditLimit().subtract(
					currentCredit);
			if (currentLimit.compareTo(order.getTotalPrice()) >= 0) {
				// customer has enough money to purchase all order items
				List<OrderItem> orderItems = dao.getRecordsByProperty(
						OrderItem.class, "salesOrder", order.getOrderId());
				Product product;
				for (OrderItem orderItem : orderItems) {
					product = orderItem.getProduct();
					product = dao.read(Product.class, product.getProdId());
					
					if (product.getAvailableQuantity() > orderItem
							.getQuantity()) {
						continue;
					} else {
						LOGGER.error(
								"Quantities [{}] unavailable for product [{}]",
								orderItem.getQuantity(), product.getProdDesc()
										+ " (" + product.getProdId() + ")");
						throw new Exception(
								"Quantities unavailable for product "
										+ product.getProdDesc() + " ("
										+ product.getProdId() + ")");
					}
				}
				object = dao.commitSalesOrderTransaction(object, order,
						customer, currentCredit, orderItems);
			}
		} else {
			object = dao.save(object);
		}
		return gson.toJson(object);
	}

	private Object getRecordFromTypeAndCode(int type, int code) {
		Object object = null;
		switch (type) {
		case 1:
			object = dao.read(Product.class, code);
			break;
		case 2:
			object = dao.read(Customer.class, code);
			break;
		case 3:
			object = dao.read(SalesOrder.class, code);
			break;
		default:
			break;
		}
		return object;
	}

}
