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
public class Loans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4649552866092353428L;
	
	@CsvBindByName(column = "interest_rate")
	private Float interestRate;
	
	@CsvBindByName
	private Double amount;
	
	@CsvBindByName(column = "id")
	private Integer loanId;
	
	@CsvBindByName(column = "default_likelihood")
	private Float defaultLikelihood;
	
	@CsvBindByName
	private String state;

	public Float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Float interestRate) {
		this.interestRate = interestRate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Integer getLoanId() {
		return loanId;
	}

	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}

	public Float getDefaultLikelihood() {
		return defaultLikelihood;
	}

	public void setDefaultLikelihood(Float defaultLikelihood) {
		this.defaultLikelihood = defaultLikelihood;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Loans [interestRate=" + interestRate + ", amount=" + amount + ", loanId=" + loanId
				+ ", defaultLikelihood=" + defaultLikelihood + ", state=" + state + "]";
	}
	
}
