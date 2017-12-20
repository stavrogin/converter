package com.ynap.converter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ynap.converter.constants.Constants;
import com.ynap.converter.constants.FullUserCSVFields;
import com.ynap.converter.model.FastUser;
import com.ynap.converter.model.UserPreference;
import com.ynap.converter.model.Users;

public class FastUserXMLGenerator extends XMLGeneratorBase<FastUser> implements XMLGenerator {
	
	private static final Logger logger = LogManager.getLogger(FastUserXMLGenerator.class);
	
	@Override
	public void generateXML() throws IOException {
    	Iterable<CSVRecord> records = getCSVRecords();
    	
    	Users<FastUser> users = new Users<>();
    	List<FastUser> fullUserList = new ArrayList<>();
    	for (CSVRecord record : records) {
    	    FastUser fullUser = buildUser(record);
    	    fullUserList.add(fullUser);
    	}
    	users.setUsers(fullUserList);
    	
    	writeOutput(users);
	}
	
	/**
	 * Builds full user XML model object from the input CSV
	 * @param record
	 * @return
	 */
	private FastUser buildUser(CSVRecord record) {
		
		String userRegType = record.get(FullUserCSVFields.USER_REG_TYPE);
		String brandName = record.get(FullUserCSVFields.BRAND_NAME);
		String registeredCountry = record.get(FullUserCSVFields.REGISTERED_COUNTRY);
		String legacyUserId = record.get(FullUserCSVFields.LEGACY_USER_ID);
		String email = record.get(FullUserCSVFields.EMAIL);
		String registrationDateTime = record.get(FullUserCSVFields.REGISTRATION_DATE_TIME);
		String lastUpdate = record.get(FullUserCSVFields.LAST_UPDATE);
		String accountStatus = record.get(FullUserCSVFields.ACCOUNT_STATUS);
		String registrationSource = record.get(FullUserCSVFields.REGISTRATION_SOURCE);
		
		FastUser fastUser = new FastUser();
		fastUser.setUserRegType(userRegType);
		fastUser.setBrand(brandName);
		fastUser.setRegisteredCountry(registeredCountry);
		fastUser.setLegacyUserId(legacyUserId);
		fastUser.setEmail(email);
		fastUser.setRegistrationDateTime(registrationDateTime);
		fastUser.setLastUpdate(lastUpdate);
		fastUser.setAccountStatus(accountStatus);
		fastUser.setRegistrationSource(registrationSource);
		
		UserPreference userPreference = getUserPreferences(record);
		fastUser.setUserPreference(userPreference);
		
		return fastUser;
	}
	
	@Override
	protected String getInputCSVFilePath() {
		return Constants.FAST_CSV_PATH;
	}

	@Override
	protected String getOutputFileName() {
		return Constants.FAST_USER_OUTPUT_FILE;
	}
	
}
