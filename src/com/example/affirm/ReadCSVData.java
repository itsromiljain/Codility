/**
 * 
 */
package com.example.affirm;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

	private static final String LOANS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/small/loans.csv";
	private static final String BANKS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/small/banks.csv";
	private static final String COVENANTS_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/small/covenants.csv";
	private static final String FACILITIES_CSV_FILE_PATH = "/Users/romiljain/affirm-take-home-interview-sept-2018/small/facilities.csv";

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
		Set<Integer> bankIds = new HashSet<Integer>();
		for (Loans loan : loansData) {
			for (Covenants coventants : covenantsData) {
				if ((coventants.getMaxDefaultLikelihood() != null && !StringUtils.isEmpty(coventants.getBannedState())
						&& !loan.getState().equals(coventants.getBannedState())
						&& coventants.getMaxDefaultLikelihood() >= loan.getDefaultLikelihood())
						|| (coventants.getMaxDefaultLikelihood() == null
								&& !loan.getState().equals(coventants.getBannedState()))
						|| (StringUtils.isEmpty(coventants.getBannedState())
								&& coventants.getMaxDefaultLikelihood() >= loan.getDefaultLikelihood())) {
					
					bankIds.add(coventants.getBankId());

				}
			}
			// calculate cheapest facility by calculating the interest rate.
			
			
		}
	}

	public static List<Bank> readBankData(String file) {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("id", "bankId");
		mapping.put("name", "bankName");
		// HeaderColumnNameTranslateMappingStrategy for Bank Class
		//HeaderColumnNameTranslateMappingStrategy<Bank> strategy = new HeaderColumnNameTranslateMappingStrategy<Bank>();
		//strategy.setType(Bank.class);
		//strategy.setColumnMapping(mapping);
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			// CsvToBean<Bank> csvToBean = new CsvToBean<Bank>();
			// call the parse method of CsvToBean
			// pass strategy, csvReader to parse method
			// csvToBean.setCsvReader(csvReader);
			// csvToBean.setMappingStrategy(strategy);
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
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("amount", "amount");
		mapping.put("interest_rate", "interestRate");
		mapping.put("id", "facilityId");
		mapping.put("bank_id", "bankId");
		// HeaderColumnNameTranslateMappingStrategy for Facilities Class
		HeaderColumnNameTranslateMappingStrategy<Facilities> strategy = new HeaderColumnNameTranslateMappingStrategy<Facilities>();
		strategy.setType(Facilities.class);
		strategy.setColumnMapping(mapping);
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Facilities> csvToBean = new CsvToBeanBuilder<Facilities>(csvReader).withType(Facilities.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Facilities> facilityList = csvToBean.parse();
			// print details of Bean object
			for (Facilities facility : facilityList) {
				System.out.println(facility.toString());
			}
			return facilityList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static List<Loans> readLoansData(String file) {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("interest_rate", "interestRate");
		mapping.put("amount", "amount");
		mapping.put("id", "loanId");
		mapping.put("default_likelihood", "defaultLikelihood");
		mapping.put("state", "state");
		// HeaderColumnNameTranslateMappingStrategy for Loan Class
		HeaderColumnNameTranslateMappingStrategy<Loans> strategy = new HeaderColumnNameTranslateMappingStrategy<Loans>();
		strategy.setType(Loans.class);
		strategy.setColumnMapping(mapping);
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

	public static List<Covenants> readCoventantsData(String file) {
		Map<String, String> mapping = new HashMap<String, String>();
		mapping.put("facility_id", "facilityId");
		mapping.put("max_default_likelihood", "maxDefaultLikelihood");
		mapping.put("bank_id", "bankId");
		mapping.put("banned_state", "bannedState");
		// HeaderColumnNameTranslateMappingStrategy for Loan Class
		HeaderColumnNameTranslateMappingStrategy<Covenants> strategy = new HeaderColumnNameTranslateMappingStrategy<Covenants>();
		strategy.setType(Covenants.class);
		strategy.setColumnMapping(mapping);
		try {
			FileReader filereader = new FileReader(file);
			CSVReader csvReader = new CSVReader(filereader);
			CsvToBean<Covenants> csvToBean = new CsvToBeanBuilder<Covenants>(csvReader).withType(Covenants.class)
					.withIgnoreLeadingWhiteSpace(true).build();
			List<Covenants> covenantList = csvToBean.parse();
			// print details of Bean object
			for (Covenants covenant : covenantList) {
				System.out.println(covenant.toString());
			}
			return covenantList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
