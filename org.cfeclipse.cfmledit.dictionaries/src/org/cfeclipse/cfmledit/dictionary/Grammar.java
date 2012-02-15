package org.cfeclipse.cfmledit.dictionary;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.osgi.framework.Bundle;

public class Grammar {
	
	private String location = null;

	public Grammar(String location) throws IOException, JDOMException {
		this.location = location;
		loadLocation();
	}

	private void loadLocation() throws IOException, JDOMException {
		Bundle bundle = Platform.getBundle(DictionaryPlugin.ID);
		URL eclipsePath = FileLocator.find(bundle, new Path("dictionary/dictionaryconfig.xml"),null); 
		URL filePath = FileLocator.toFileURL(eclipsePath);
		
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(filePath);
		
		System.out.println(doc.getContent());
		
	}
	
	
	

}
