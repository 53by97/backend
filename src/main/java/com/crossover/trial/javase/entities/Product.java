package com.crossover.trial.javase.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product", catalog = "salesorderdb")
public class Product implements java.io.Serializable {

	private static final long serialVersionUID = 1248080243383066347L;

	private Integer prodId;
	private String prodName;
	private String prodDesc;
	private BigDecimal price;
	private int availableQuantity;
	private Date updatedDate;
	private Date createdDate;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "prodId", unique = true, nullable = false)
	public Integer getProdId() {
		return this.prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	@Column(name = "prodName", length = 50)
	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	@Column(name = "prodDesc", length = 200)
	public String getProdDesc() {
		return this.prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	@Column(name = "price", nullable = false, precision = 10)
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column(name = "availableQuantity", nullable = false)
	public int getAvailableQuantity() {
		return this.availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
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
