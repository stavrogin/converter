package com.ynap.converter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Consumer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class XMLGenerator {
	
	private static final String PATH = "c:/csv_converter/";
	private static final String FULL_CSV = PATH + "UtentiFast_YNAP.csv";
	private static final String FAST_CSV = PATH + "UtentiFull_YNAP.csv";
	private static final Logger logger = LogManager.getLogger(XMLGenerator.class);
	
	public void generateXML() throws IOException {
		Reader in = new FileReader(FULL_CSV);
    	Iterable<CSVRecord> records = CSVFormat.EXCEL.withFirstRecordAsHeader().parse(in);
//    	CSVFormat.DEFAULT
//    	withDelimiter
//    	withQuote
    	
    	for (CSVRecord record : records) {
    	    String lastName = record.get("RegisteredCountry");
    	    System.out.println(lastName);
    	}
	}

	/*
	private static Consumer<CSVRecord> getFullUserCSVConsumer() {
		Consumer<CSVRecord> consumer = (row) -> {
		};
		return consumer;
	}
	*/

}
