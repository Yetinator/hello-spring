package org.launchcode.models;

import java.util.ArrayList;
import java.util.HashMap;

public class HelloMessage {
	
	
	
	public static String getMessage(String name, String language){
		LanguageMap instance = new LanguageMap();
		String hi = instance.hiLanguage.get(language);
		return hi + ", " + name + "!";
		
	}
}
