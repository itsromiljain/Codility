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
public class Covenants implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7281811748522010012L;

	@CsvBindByName(column = "facility_id", required=false)
	private Integer facilityId;
	
	@CsvBindByName(column = "max_default_likelihood", required=false)
	private Float maxDefaultLikelihood;
	
	@CsvBindByName(column = "bank_id")
	private Integer bankId;
	
	@CsvBindByName(column = "banned_state", required=false)
	private String bannedState;

	public Integer getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Integer facilityId) {
		this.facilityId = facilityId;
	}

	public Float getMaxDefaultLikelihood() {
		return maxDefaultLikelihood;
	}

	public void setMaxDefaultLikelihood(Float maxDefaultLikelihood) {
		this.maxDefaultLikelihood = maxDefaultLikelihood;
	}

	public Integer getBankId() {
		return bankId;
	}

	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	public String getBannedState() {
		return bannedState;
	}

	public void setBannedState(String bannedState) {
		this.bannedState = bannedState;
	}

	@Override
	public String toString() {
		return "Covenants [facilityId=" + facilityId + ", maxDefaultLikelihood=" + maxDefaultLikelihood + ", bankId="
				+ bankId + ", bannedState=" + bannedState + "]";
	}
	
}
