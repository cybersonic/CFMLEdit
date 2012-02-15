package org.cfeclipse.cfmledit.dictionary;

import java.util.HashMap;
import java.util.Map;

public class Version {
	private String label = "";
	private String key = "";
	private Map<String, Grammar> grammars = new HashMap<String, Grammar>();
	public Version(String key, String label) {
		this.key = key;
		this.label = label;
	}
	
	//Load grammar
	
	public String toString(){
		return "Server Version label: " + label + " key: " + key;
	}

	public Map<String, Grammar> getGrammars() {
		return grammars;
	}

	public void setGrammars(Map<String, Grammar> grammers) {
		this.grammars = grammers;
	}
	
	/**	
	 * 
	 * @param the key
	 * @param path
	 */
	public void addGrammar(String name, String path){
		//grammars.put(name, grammar);
	}

}
