/**
 * 
 */
package com.example.affirm;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;

/**
 * @author romiljain
 *
 */
public class ReadCSVData {

	private static final String LOANS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/large/loans.csv";
	private static final String BANKS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/large/banks.csv";
	private static final String COVENANTS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/large/covenants.csv";
	private static final String FACILITIES_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/large/facilities.csv";

	private static Map<Integer, Facilities> facilitiesMap = null;

	private static Map<String, CovenantRule> covenantRuleMap = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Bank> banksData = readBankData(BANKS_CSV_FILE_PATH);
		List<Facilities> facilitiesData = readFacilityData(FACILITIES_CSV_FILE_PATH);
		Map<Integer, List<Facilities>> bankFacilityMap = populateBankFacilityMap(facilitiesData);
		List<Covenants> covenantsData = readCoventantsData(COVENANTS_CSV_FILE_PATH);
		List<Loans> loansData = readLoansData(LOANS_CSV_FILE_PATH);
		calculateAssignmentAndYield(covenantsData, loansData, bankFacilityMap);
	}

	private static Map<Integer, List<Facilities>> populateBankFacilityMap(List<Facilities> facilitiesData) {
		Map<Integer, List<Facilities>> bankFacilityMap = new HashMap<Integer, List<Facilities>>();
		List<Facilities> facilties = new ArrayList<Facilities>();
		for (Facilities facility : facilitiesData) {
			if (bankFacilityMap.get(facility.getBankId()) != null
					&& !bankFacilityMap.get(facility.getBankId()).isEmpty()) {
				facilties = bankFacilityMap.get(facility.getBankId());
			}
			facilties.add(facility);
			bankFacilityMap.put(facility.getBankId(), facilties);
		}
		return bankFacilityMap;
	}

	private static void calculateAssignmentAndYield(List<Covenants> covenantsData, List<Loans> loansData, Map<Integer, List<Facilities>> bankFacilityMap) {
		Map<Integer, Integer> assignmentMap = new HashMap<>();
		Map<Integer, Double> yieldMap = new HashMap<>();
		for (Loans loan : loansData) {
			Set<Facilities> facilities = new HashSet<>();
			for (Map.Entry<String, CovenantRule> entry : covenantRuleMap.entrySet()){
				CovenantRule covenantRule = entry.getValue();
				if(loan.getDefaultLikelihood() <= covenantRule.getMaxDefaultLikelihood() && !covenantRule.getBannedStates().contains(loan.getState())){
					// Add this facility Id in the list
					Integer facilityId = Integer.valueOf(entry.getKey().split("_")[0]);
					Facilities facility = facilitiesMap.get(facilityId);
					if(facility.getAmount() >= loan.getAmount())
						facilities.add(facility);
				}
			}
			// calculate cheapest facility by calculating the interest rate.
			if(!facilities.isEmpty()){
				Integer facilityId = facilities.stream().sorted(Comparator.comparing(Facilities::getInterestRate)).collect(Collectors.toList()).get(0).getFacilityId();
				System.out.println(loan.getLoanId() + " :: " + facilityId);

				assignmentMap.put(loan.getLoanId(), facilityId);
				Facilities facility = facilitiesMap.get(facilityId);
				facility.setAmount(facility.getAmount()-loan.getAmount());
				facilitiesMap.put(facilityId, facility);
				Double expected_yield = (1 - loan.getDefaultLikelihood()) * loan.getInterestRate() * loan.getAmount() - loan.getDefaultLikelihood() * loan.getAmount() - facility.getInterestRate() * loan.getAmount();

				if (yieldMap.get(facilityId) != null) {
					expected_yield = expected_yield.doubleValue() + yieldMap.get(facilityId).doubleValue();
				}
				yieldMap.put(facilityId, expected_yield);
			}
		}
		for(Map.Entry<Integer, Double> entry : yieldMap.entrySet()){
			System.out.println(entry.getKey() + " :: " + Math.round(entry.getValue()));
		}
	}

	public static List<Bank> readBankData(String file) {
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Bank> csvToBean = new CsvToBeanBuilder<Bank>(csvReader).withType(Bank.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			List<Bank> bankList = csvToBean.parse();
			// print details of Bean object
			for (Bank bank : bankList) {
				System.out.println(bank.toString());
			}
			return bankList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Facilities> readFacilityData(String file) {
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Facilities> csvToBean = new CsvToBeanBuilder<Facilities>(csvReader).withType(Facilities.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Facilities> facilityList = csvToBean.parse();
			facilitiesMap = new HashMap<>();
			for (Facilities facility : facilityList) {
				System.out.println(facility.toString());
				facilitiesMap.put(facility.getFacilityId(), facility);
			}
			return facilityList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Covenants> readCoventantsData(String file) {
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Covenants> csvToBean = new CsvToBeanBuilder<Covenants>(csvReader).withType(Covenants.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Covenants> covenantList = csvToBean.parse();
			// print details of Bean object
			covenantRuleMap = new HashMap<>();
			for (Covenants covenant : covenantList) {
				System.out.println(covenant.toString());
				String id =  covenant.getFacilityId() + "_" + covenant.getBankId();
				Float maxDefaultLikelihood = covenant.getMaxDefaultLikelihood();
				String bannedState = covenant.getBannedState();
				CovenantRule covenantRule = covenantRuleMap.get(id);
				if(null == covenantRule){
					List<String> bannedStates = new ArrayList<>();
					bannedStates.add(bannedState);
					covenantRule = new CovenantRule();
					covenantRule.setMaxDefaultLikelihood(maxDefaultLikelihood);
					covenantRule.setBannedStates(bannedStates);

				}else {
					covenantRule.getBannedStates().add(bannedState);
					if(null == covenantRule.getMaxDefaultLikelihood() || (null != maxDefaultLikelihood && maxDefaultLikelihood > covenantRule.getMaxDefaultLikelihood())){
						covenantRule.setMaxDefaultLikelihood(maxDefaultLikelihood);
					}
				}
				covenantRuleMap.put(id, covenantRule);
			}
			return covenantList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Loans> readLoansData(String file) {
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Loans> csvToBean = new CsvToBeanBuilder<Loans>(csvReader).withType(Loans.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Loans> loanList = csvToBean.parse();
			// print details of Bean object
			for (Loans loan : loanList) {
				System.out.println(loan.toString());
			}
			return loanList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
