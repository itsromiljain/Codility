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
public class Bank implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4061497387235262668L;
	
	@CsvBindByName(column = "id")
	private Integer bankId;
	
	@CsvBindByName(column = "name")
	private String bankName;

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Bank [bankId=" + bankId + ", bankName=" + bankName + "]";
	}
	
}
