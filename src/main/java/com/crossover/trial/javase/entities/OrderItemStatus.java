package com.crossover.trial.javase.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderitemstatus", catalog = "salesorderdb")
public class OrderItemStatus implements java.io.Serializable {

	private static final long serialVersionUID = -7603874987844012038L;

	private Integer orderItemStatusId;
	private String orderItemStatus;
	private String orderItemStatusDesc;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderItemStatusId", unique = true, nullable = false)
	public Integer getOrderItemStatusId() {
		return this.orderItemStatusId;
	}

	public void setOrderItemStatusId(Integer orderItemStatusId) {
		this.orderItemStatusId = orderItemStatusId;
	}

	@Column(name = "orderItemStatus", nullable = false, length = 20)
	public String getOrderItemStatus() {
		return this.orderItemStatus;
	}

	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	@Column(name = "orderItemStatusDesc", length = 200)
	public String getOrderItemStatusDesc() {
		return this.orderItemStatusDesc;
	}

	public void setOrderItemStatusDesc(String orderItemStatusDesc) {
		this.orderItemStatusDesc = orderItemStatusDesc;
	}

}
