package org.cfeclipse.cfmledit.dictionary;

import java.util.ArrayList;

public class Version {
	private String label = "";
	private String key = "";
	private ArrayList<Grammar> grammars = new ArrayList<Grammar>();
	public Version(String key, String label) {
		this.key = key;
		this.label = label;
	}
	
	//Load grammar
	public String toString(){
		return "Server Version label: " + label + " key: " + key;
	}

	public void addGrammar(Grammar gram) {
		grammars.add(gram);
	}
	
	public ArrayList<Tag> getTags(){
		//TODO: Implement
		return null;
	}
	
	public ArrayList<Function> getFunctions(){
		//TODO: Implement
		return null;
	}

}
