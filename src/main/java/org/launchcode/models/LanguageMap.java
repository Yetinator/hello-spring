package org.launchcode.models;

import java.util.ArrayList;
import java.util.HashMap;

public class LanguageMap {
	
protected HashMap<String, String> hiLanguage = new HashMap<String, String>();
	
	public LanguageMap() {
		hiLanguage.put("English", "Hello");
		hiLanguage.put("French", "Salut");
		hiLanguage.put("German", "Hallo");
		hiLanguage.put("Italian", "Ciao");
		hiLanguage.put("Czech", "Ahoj");
		hiLanguage.put("Greek", "Yah sahs");
		hiLanguage.put("Croation", "Bog");
		hiLanguage.put("Dutch", "Hallo");
		hiLanguage.put("Hungarian", "Udvozlom");
		hiLanguage.put("Swedish", "Hej");
	}
	
	public ArrayList<String> getLanguages() {
		ArrayList<String> thisList = new ArrayList<String>();
		for(String key : hiLanguage.keySet()){
			thisList.add(key);
		}
		return thisList;	
	}

}
