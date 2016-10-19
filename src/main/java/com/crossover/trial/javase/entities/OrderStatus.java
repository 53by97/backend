package com.crossover.trial.javase.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orderstatus", catalog = "salesorderdb")
public class OrderStatus implements java.io.Serializable {

	private static final long serialVersionUID = -4983661292980766225L;

	private Integer orderStatusId;
	private String orderStatus;
	private String orderStatusDesc;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "orderStatusId", unique = true, nullable = false)
	public Integer getOrderStatusId() {
		return this.orderStatusId;
	}

	public void setOrderStatusId(Integer orderStatusId) {
		this.orderStatusId = orderStatusId;
	}

	@Column(name = "orderStatus", nullable = false, length = 20)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "orderStatusDesc", length = 200)
	public String getOrderStatusDesc() {
		return this.orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}

}
