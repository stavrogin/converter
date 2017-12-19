package com.ynap.converter.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ContextAttribute {

	@JsonProperty("AttributeName")
	private String attributeName;
	
	@JsonProperty("AttributeValue")
	private AttributeValue attributeValue;

	
	
	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public AttributeValue getAttributeValue() {
		return attributeValue;
	}

	public void setAttributeValue(AttributeValue attributeValue) {
		this.attributeValue = attributeValue;
	}
	
}
