/**
 * 
 */
package com.example.affirm;

import java.io.Serializable;

import com.opencsv.bean.CsvBindByName;

/**
 * @author romiljain
 *
 */
public class Facilities implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7455801465723734L;
	
	@CsvBindByName
	private Double amount;
	
	@CsvBindByName(column = "interest_rate")
	private Float interestRate;
	
	@CsvBindByName(column = "id")
	private Integer facilityId;
	
	@CsvBindByName(column = "bank_id")
	private Integer bankId;

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	@Override
	public String toString() {
		return "Facilities [amount=" + amount + ", interestRate=" + interestRate + ", facilityId=" + facilityId
				+ ", bankId=" + bankId + "]";
	}

}