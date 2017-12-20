package com.ynap.converter;

import java.io.IOException;

import com.ynap.converter.constants.Constants;

public class Main {

	public static void main(String[] args) throws IOException {

		XMLGeneratorFactory xmlGeneratorFactory = new XMLGeneratorFactory();
		
		XMLGenerator fullUsersXMLGenerator = xmlGeneratorFactory.getXMLGenerator(Constants.UserType.FULL);
		//XMLGenerator fastUsersXMLGenerator = xmlGeneratorFactory.getXMLGenerator(Constants.UserType.FAST);
		
		fullUsersXMLGenerator.generateXML();
		//fastUsersXMLGenerator.generateXML();

	}
	
}
