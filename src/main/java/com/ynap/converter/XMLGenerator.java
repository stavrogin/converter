package com.ynap.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ynap.converter.constants.FullUserCSVFields;
import com.ynap.converter.model.FullUser;

public class XMLGenerator {
	
	private static final String PATH = "c:/csv_converter/";
	private static final String FULL_CSV = PATH + "UtentiFull_YNAP.csv";
	private static final String FAST_CSV = PATH + "UtentiFast_YNAP.csv";
	private static final Logger logger = LogManager.getLogger(XMLGenerator.class);
	
	public void generateXML() throws IOException {
		Reader in = new FileReader(FULL_CSV);
    	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader().parse(in);
//    	CSVFormat.DEFAULT
//    	withDelimiter
//    	withQuote
    	List<FullUser> fullUserList = new ArrayList<>();
    	for (CSVRecord record : records) {
    	    FullUser fullUser = buildFullUser(record);
    	    fullUserList.add(fullUser);
    	}
    	
    	XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File(PATH + "output.xml"), fullUserList);
	}
	
	private FullUser buildFullUser(CSVRecord record) {
		
		String userRegType = record.get(FullUserCSVFields.USER_REG_TYPE);
		String brandName = record.get(FullUserCSVFields.BRAND_NAME);
		String registeredCountry = record.get(FullUserCSVFields.REGISTERED_COUNTRY);
		String firstName = record.get(FullUserCSVFields.FIRST_NAME);
		String lastName = record.get(FullUserCSVFields.LAST_NAME);
		String legacyUserId = record.get(FullUserCSVFields.LEGACY_USER_ID);
		String email = record.get(FullUserCSVFields.EMAIL);
		String gender = record.get(FullUserCSVFields.GENDER);
		String dateOfBirth = record.get(FullUserCSVFields.DATE_OF_BIRTH);
		String primaryPhone = record.get(FullUserCSVFields.PRIMARY_PHONE);
		String registrationDateTime = record.get(FullUserCSVFields.REGISTRATION_DATE_TIME);
		String lastUpdate = record.get(FullUserCSVFields.LAST_UPDATE);
		String accountStatus = record.get(FullUserCSVFields.ACCOUNT_STATUS);
		String registrationSource = record.get(FullUserCSVFields.REGISTRATION_SOURCE);
		String roleName = record.get(FullUserCSVFields.ROLE_NAME);
		String pronunciationFirstName = record.get(FullUserCSVFields.PRONUNCIATION_FIRST_NAME);
		String pronunciationLastName = record.get(FullUserCSVFields.PRONUNCIATON_LAST_NAME);
		String pronunciationLocale = record.get(FullUserCSVFields.PRONUNCIATION_LOCALE);
		String ferrariGUID = record.get(FullUserCSVFields.FERRARI_GUID);
		String ferrariCodeLanguage = record.get(FullUserCSVFields.FERRARI_CODE_LANGUAGE);
		String ferrariConsent = record.get(FullUserCSVFields.FERRARI_CONSENT);
		String ferrariConsent1 = record.get(FullUserCSVFields.FERRARI_CONSENT1);
		String maMarketingConsent = record.get(FullUserCSVFields.MA_MARKETING_CONSENT);
		String maPrivacyConsent = record.get(FullUserCSVFields.MA_PRIVACY_CONSENT);
		String newsletterCode = record.get(FullUserCSVFields.NEWSLETTER_CODE);
		String address1 = record.get(FullUserCSVFields.ADDRESS_1);
		String address2 = record.get(FullUserCSVFields.ADDRESS_2);
		String address3 = record.get(FullUserCSVFields.ADDRESS_3);
		String city = record.get(FullUserCSVFields.CITY);
		String province = record.get(FullUserCSVFields.PROVINCE);
		String zipCode = record.get(FullUserCSVFields.ZIP_CODE);
		String addressType = record.get(FullUserCSVFields.ADDRESS_TYPE);
		String careOf = record.get(FullUserCSVFields.CARE_OF);
		
		FullUser fullUser = new FullUser();
		fullUser.setUserRegType(userRegType);
		fullUser.setBrand(brandName);
		fullUser.setRegisteredCountry(registeredCountry);
		fullUser.setFirstName(firstName);
		fullUser.setLastName(lastName);
		fullUser.setLegacyUserId(legacyUserId);
		fullUser.setEmail(email);
		fullUser.setGender(gender);
		fullUser.setDateOfBirth(dateOfBirth);
		fullUser.setPrimaryPhone(primaryPhone);
		fullUser.setRegistrationDateTime(registrationDateTime);
		fullUser.setLastUpdate(lastUpdate);
		fullUser.setAccountStatus(accountStatus);
		fullUser.setRegistrationSource(registrationSource);
		//TODO
		//fullUser.setRoles(roles);
		//fullUser.setPronunciation(pronunciation);
		//fullUser.setContextAttribute(contextAttribute);
		
		return fullUser;
	}

	/*
	private static Consumer<CSVRecord> getFullUserCSVConsumer() {
		Consumer<CSVRecord> consumer = (row) -> {
		};
		return consumer;
	}
	*/

}
