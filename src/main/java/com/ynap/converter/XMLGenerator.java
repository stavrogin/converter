package com.ynap.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ynap.converter.constants.FullUserCSVFields;
import com.ynap.converter.model.AttributeValue;
import com.ynap.converter.model.ContextAttribute;
import com.ynap.converter.model.FullUser;
import com.ynap.converter.model.Pronunciation;
import com.ynap.converter.model.Roles;
import com.ynap.converter.model.UserPreference;
import com.ynap.converter.model.UserPreferenceValue;
import com.ynap.converter.model.Users;

public class XMLGenerator {
	
	private static final String PATH = "c:/csv_converter/";
	private static final String FULL_CSV = PATH + "UtentiFull_YNAP.csv";
	private static final String FAST_CSV = PATH + "UtentiFast_YNAP.csv";
	private static final Logger logger = LogManager.getLogger(XMLGenerator.class);
	
	public void generateXML() throws IOException {
		Reader in = new FileReader(FULL_CSV);
    	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withQuote('\"').withFirstRecordAsHeader().parse(in);
//    	CSVFormat.DEFAULT
//    	withDelimiter
//    	withQuote
    	
    	Users<FullUser> users = new Users<>();
    	List<FullUser> fullUserList = new ArrayList<>();
    	for (CSVRecord record : records) {
    	    FullUser fullUser = buildFullUser(record);
    	    fullUserList.add(fullUser);
    	}
    	users.setUsers(fullUserList);
    	
    	JacksonXmlModule module = new JacksonXmlModule();
    	// to default to using "unwrapped" Lists:
    	module.setDefaultUseWrapper(false);
    	
    	ObjectMapper xmlMapper = new XmlMapper(module);
    	xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(PATH + "output.xml"), users);
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
		Roles roles = getRoles(roleName);
		fullUser.setRoles(roles);
		Pronunciation pronunciation = getPronunciation(pronunciationFirstName, pronunciationLastName, pronunciationLocale);
		fullUser.setPronunciation(pronunciation);
		List<ContextAttribute> contextAttributes = getContextAttributes(record);
		fullUser.setContextAttribute(contextAttributes);
		
		return fullUser;
	}
	
	private Roles getRoles(String roleName) {
		Roles roles = null;
		if (roleName != null) {
			String[] rolesArray = roleName.split("\\|");
			roles = new Roles();
			List<String> roleNames = Arrays.asList(rolesArray);
			roles.setRoleName(roleNames);
		}
		return roles;
	}
	
	private Pronunciation getPronunciation(String firstName, String lastName, String locale) {
		Pronunciation pronunciation = null;
		if (locale != null) {
			pronunciation = new Pronunciation();
			pronunciation.setFirstName(firstName);
			pronunciation.setLastName(lastName);
			pronunciation.setLocale(locale);
		}
		return pronunciation;
	}
	
	private List<ContextAttribute> getContextAttributes(CSVRecord record){
		List<ContextAttribute> contextAttributes = new ArrayList<>();
		addContextAttribute(contextAttributes, record, FullUserCSVFields.FERRARI_GUID);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.FERRARI_CODE_LANGUAGE);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.FERRARI_CONSENT);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.FERRARI_CONSENT1);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.MA_MARKETING_CONSENT);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.MA_PRIVACY_CONSENT);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.ADDRESS_1);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.ADDRESS_2);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.ADDRESS_3);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.PROVINCE);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.ZIP_CODE);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.ADDRESS_TYPE);
		addContextAttribute(contextAttributes, record, FullUserCSVFields.CARE_OF);
		return contextAttributes;
		
	}

	private void addContextAttribute(List<ContextAttribute> contextAttributes, CSVRecord record, String inputAttrName) {
		String attributeValue = record.get(inputAttrName);
		if (attributeValue != null) {
			ContextAttribute ctxAttr = new ContextAttribute();
			ctxAttr.setAttributeName(inputAttrName);
			AttributeValue ctxAttrVal = new AttributeValue();
			String value = record.get(inputAttrName);
			ctxAttrVal.setValue(value);
			ctxAttr.setAttributeValue(ctxAttrVal);
			contextAttributes.add(ctxAttr);
		}
	}
	
	private UserPreference getUserPreferences(CSVRecord record) {
		UserPreference userPreference = null;
		String attributeValue = record.get(FullUserCSVFields.NEWSLETTER_CODE);
		if (attributeValue != null) {
			String[] attributeValues = attributeValue.split("\\|");
			userPreference = new UserPreference();
			UserPreferenceValue userPreferenceValue = new UserPreferenceValue();
			List<String> values = new ArrayList<>();
			for (String newsletter : attributeValues) {
				values.add(newsletter);
			}
			userPreferenceValue.setName(values);
			userPreference.setUserPreferenceValue(userPreferenceValue);
		}
		return userPreference;
	}
	
	/*
	private static Consumer<CSVRecord> getFullUserCSVConsumer() {
		Consumer<CSVRecord> consumer = (row) -> {
		};
		return consumer;
	}
	*/

}
