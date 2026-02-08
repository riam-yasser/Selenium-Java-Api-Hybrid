package com.tests.automation.customtypes;

import com.tests.automation.constants.Language;

import io.cucumber.java.ParameterType;

public class CustomParameterType {

	@ParameterType(".*")
	public Language language(String languageName) {
		return Language.valueOf(languageName);
	}
}
