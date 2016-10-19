package com.crossover.trial.javase.dao;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.crossover.trial.javase.entities.Customer;
import com.crossover.trial.javase.entities.OrderItem;
import com.crossover.trial.javase.entities.Product;
import com.crossover.trial.javase.entities.SalesOrder;
import com.crossover.trial.javase.hibernate.util.HibernateUtil;

public class BackendAPIsDAO {

	private SessionFactory sessionFactory = new HibernateUtil()
			.getSessionFactory();

	@SuppressWarnings("unchecked")
	public <T> List<T> list(Class<T> klass) {
		Session session = sessionFactory.openSession();
		List<T> list = session.createQuery("from " + klass.getSimpleName())
				.list();
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public <T> T read(Class<T> klass, int id) {
		Session session = sessionFactory.openSession();
		T object = (T) session.get(klass, id);
		session.close();
		return object;
	}

	public <T> void delete(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		session.close();
	}

	public <T> T save(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(object);
		session.getTransaction().commit();
		session.close();
		return object;
	}

	public <T> T update(T object) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.merge(object);
		session.getTransaction().commit();
		session.close();
		return object;
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> getRecordsByProperty(Class<T> klass, String property,
			int value) {
		Session session = sessionFactory.openSession();
		List<T> list = session.createQuery(
				"from " + klass.getSimpleName() + " E where E." + property
						+ " = " + value).list();
		session.close();
		return list;
	}

	public Object commitSalesOrderTransaction(Object object, SalesOrder order,
			Customer customer, BigDecimal currentCredit,
			List<OrderItem> orderItems) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Product product;
		for (OrderItem orderItem : orderItems) {
			product = orderItem.getProduct();
			product = (Product) session.get(Product.class, product.getProdId());
			product.setAvailableQuantity(product.getAvailableQuantity()
					- orderItem.getQuantity());
			session.merge(product);
		}
		customer.setCurrentCredit(currentCredit.add(order.getTotalPrice()));
		session.merge(customer);

		object = save(object);
		session.getTransaction().commit();
		session.close();

		return object;
	}
}
