package org.cfeclipse.cfmledit.dictionary;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.osgi.framework.Bundle;

public class Dictionary {

	//Myself
	public static Dictionary instance = null;
	//Lightweight listing of server versions
	public static ArrayList<Version> serverVersion = new ArrayList<Version>();

	protected Dictionary() throws Exception{
		parseDictionaryConfig();
	}
	
	public static Dictionary getInstance() throws Exception {
		
		if(instance == null){
			instance = new Dictionary();
		}
		return instance;
	}

	private void parseDictionaryConfig() throws Exception {
		// Get the file and set the names in the dictionaryconfig.xml
		Bundle bundle = DictionaryActivator.getBundle();
		URL eclipsePath = FileLocator.find(bundle, new Path("dictionary/dictionaryconfig.xml"),null); 
		URL filePath = FileLocator.toFileURL(eclipsePath);
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(filePath);
		Element cfmlversions = (Element)doc.getRootElement().getChildren().get(0);
		
		if(!cfmlversions.getAttributeValue("id").equalsIgnoreCase("CF_DICTIONARY")){
			throw new Exception("CFML Dictionary information not found");
		}
		loadVersions(cfmlversions);
	}

	private void loadVersions(Element cfmlversions) throws IOException,
			JDOMException {
		List<Element> versions = cfmlversions.getChildren();
		for (Element vers : versions) {
			Version version = new Version(vers.getAttributeValue("key"), vers.getAttributeValue("label"));
			List<Element> grammars = vers.getChildren();
				for (Element gramr : grammars) {
					Grammar gram = new Grammar(gramr.getAttributeValue("location"));
					version.addGrammar(gram);
				}
				
			serverVersion.add(version);
		}
	}

	public ArrayList<Version> getVersions() {
		return serverVersion;
	}
	
	
	

}
