package com.ynap.converter;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.function.Consumer;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

	public static void main(String[] args) throws IOException {
		// read file into stream, try-with-resources
//		try (Stream<String> stream = Files.lines(Paths.get(FULL_CSV))) {
//			stream.forEach(System.out::println);
//		} catch (IOException e) {
//			logger.error(e);
//		}
		
		
		XMLGenerator g = new XMLGenerator();
		g.generateXML();
		
	}

	

	
	
}
