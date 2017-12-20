package com.ynap.converter;

import com.ynap.converter.constants.Constants;

public class XMLGeneratorFactory {
	
	public XMLGenerator getXMLGenerator(Constants.UserType userType) {
		switch (userType) {
		case FULL:
			return new FullUserXMLGenerator();
			
		case FAST:
			return new FastUserXMLGenerator();

		default:
			throw new IllegalArgumentException("User type " + userType + " unknown");
		}
	}

}
