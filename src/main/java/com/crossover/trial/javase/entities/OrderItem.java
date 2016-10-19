package com.crossover.trial.javase.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orderitem", catalog = "salesorderdb")
public class OrderItem implements java.io.Serializable {

	private static final long serialVersionUID = -8539641949140893526L;
	
	private Integer orderItemId;
	private OrderItemStatus orderItemStatus;
	private Product product;
	private SalesOrder salesOrder;
	private int quantity;
	private BigDecimal totalPrice;
	private Date updatedDate;
	private Date createdDate;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderItemId", unique = true, nullable = false)
	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "orderItemStatus")
	public OrderItemStatus getOrderItemStatus() {
		return this.orderItemStatus;
	}

	public void setOrderItemStatus(OrderItemStatus orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product", nullable = false)
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parentOrder", nullable = false)
	public SalesOrder getSalesOrder() {
		return this.salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	@Column(name = "quantity", nullable = false)
	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Column(name = "totalPrice", nullable = false, precision = 10)
	public BigDecimal getTotalPrice() {
		return this.totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updatedDate", nullable = false, length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdDate", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
