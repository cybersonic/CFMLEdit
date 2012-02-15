package org.cfeclipse.cfmledit.dictionary;


import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;
import org.osgi.framework.Bundle;

public class Grammar {
	
	private String location = null;
	private Map<String, Tag> tags = new HashMap<String, Tag>();

	public Grammar(String location) throws IOException, JDOMException {
		this.location = location;
		loadLocation();
	}

	public boolean loadLocation() throws IOException, JDOMException {
		Bundle bundle = Platform.getBundle(DictionaryActivator.PLUGIN_ID);
		URL eclipsePath = FileLocator.find(bundle, new Path("dictionary/" + this.location),null); 
		URL filePath = FileLocator.toFileURL(eclipsePath);
		SAXBuilder builder = new SAXBuilder();
		Document doc = builder.build(filePath);
		return parseChildren(doc);
	}
	
	public boolean parseChildren(Document doc) throws JDOMException{
	
		 List<Element> children = doc.getRootElement().getChildren();
		 
		 for (Element el : children) {
			if(el.getName().equalsIgnoreCase("tags")){
				parseTags(el);
			}
		}
		 
		return false;
		
	}

	private void parseTags(Element el) {
		List<Element> tags = el.getChildren();
		for (Element element : tags) {
			
		}
		System.out.println("Tags: " + tags.size());
		
	}
	
	public int getTagCount(){
		return this.tags.size();
	}
	

}
