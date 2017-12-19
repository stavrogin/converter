package com.ynap.converter;

import java.io.IOException;

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
