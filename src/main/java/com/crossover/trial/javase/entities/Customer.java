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
@Table(name = "customer", catalog = "salesorderdb")
public class Customer implements java.io.Serializable {

	private static final long serialVersionUID = 348641849334604392L;

	private Integer custId;
	private Address address;
	private String custName;
	private BigDecimal currentCredit;
	private BigDecimal creditLimit;
	private String primaryContactNumber;
	private String secondaryContactNumber;
	private Date updatedDate;
	private Date createdDate;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "custId", unique = true, nullable = false)
	public Integer getCustId() {
		return this.custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "address")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name = "custName", nullable = false, length = 50)
	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "currentCredit", precision = 10)
	public BigDecimal getCurrentCredit() {
		return this.currentCredit;
	}

	public void setCurrentCredit(BigDecimal currentCredit) {
		this.currentCredit = currentCredit;
	}

	@Column(name = "creditLimit", nullable = false, precision = 10)
	public BigDecimal getCreditLimit() {
		return this.creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Column(name = "primaryContactNumber", length = 15)
	public String getPrimaryContactNumber() {
		return this.primaryContactNumber;
	}

	public void setPrimaryContactNumber(String primaryContactNumber) {
		this.primaryContactNumber = primaryContactNumber;
	}

	@Column(name = "secondaryContactNumber", length = 15)
	public String getSecondaryContactNumber() {
		return this.secondaryContactNumber;
	}

	public void setSecondaryContactNumber(String secondaryContactNumber) {
		this.secondaryContactNumber = secondaryContactNumber;
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
