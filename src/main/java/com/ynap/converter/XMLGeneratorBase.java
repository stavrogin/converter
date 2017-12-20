package com.ynap.converter;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.ynap.converter.constants.Constants;
import com.ynap.converter.constants.FullUserCSVFields;
import com.ynap.converter.model.UserPreference;
import com.ynap.converter.model.UserPreferenceValue;
import com.ynap.converter.model.Users;

public abstract class XMLGeneratorBase<T> {

	protected abstract String getInputCSVFilePath();
	protected abstract String getOutputFileName();
	
	protected Iterable<CSVRecord> getCSVRecords() throws IOException {
		Reader in = new FileReader(getInputCSVFilePath());
    	Iterable<CSVRecord> records = CSVFormat.DEFAULT.withDelimiter(';').withQuote('\"').withFirstRecordAsHeader().parse(in);
    	return records;
	}
	
	protected UserPreference getUserPreferences(CSVRecord record) {
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
	
	protected void writeOutput(Users<T> users) throws JsonGenerationException, JsonMappingException, IOException {
		JacksonXmlModule module = new JacksonXmlModule();
    	// to default to using "unwrapped" Lists:
    	module.setDefaultUseWrapper(false);
    	ObjectMapper xmlMapper = new XmlMapper(module);
    	xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);
        xmlMapper.writeValue(new File(getOutputFilePath()), users);
	}
	
	protected String getOutputFilePath() {
		return Constants.PATH + Constants.FULL_USER_OUTPUT_FILE;
	}

}
