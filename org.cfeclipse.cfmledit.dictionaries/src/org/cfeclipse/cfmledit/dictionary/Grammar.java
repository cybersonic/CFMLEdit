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
	private Map<String, Tag> tags = null;

	public Grammar(String location) throws IOException, JDOMException {
		this.location = location;
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
	
	/**
	 * Parses all the tag elements and adds them to the tags Map
	 * <tag xmlns="http://www.cfeclipse.org/version1/dictionary" name="cfabort" single="true" xmlstyle="false">
	<help><![CDATA[
		Stops the processing of a CFML page at the tag location.
		CFML returns everything that was processed before the
		tag. The tag is often used with conditional logic to stop
		processing a page when a condition occurs.
	]]></help>
	<parameter name="showerror" type="String" required="false">
		<help><![CDATA[
			Error to display, in a standard CFML error page,
			when tag executes
		]]></help>
		<values/>
	</parameter>
		</tag>

		Tag attributes: 
			name="cfabort"
			endtagrequired="false"
			canHaveAttributeCollection="false"
			allowanyattribute="true"
			name="cfargument"
			single="true"
            xmlstyle="false"
            createsScopeVar="true"
            
            
            

	 * @param elements
	 * @param createsScopeVar 
	 * @param allowanyattribute 
	 */

	private void parseTags(Element elements) {
		this.tags = new HashMap<String, Tag>();
		List<Element> tags = elements.getChildren();
		for (Element el: tags) {
			
			String name = el.getAttributeValue("name");
			boolean single = setFromBooleanAttribute(el, "single");
			boolean xmlstyle = setFromBooleanAttribute(el, "xmlstyle");
			boolean hybrid = setFromBooleanAttribute(el, "hybrid");
			boolean anyAttribute = setFromBooleanAttribute(el, "anyAttribute");
			boolean endtagrequired = setFromBooleanAttribute(el, "anyAttribute");
			boolean allowanyattribute = setFromBooleanAttribute(el, "allowanyattribute");
			boolean canHaveAttributeCollection = setFromBooleanAttribute(el, "allowanyattribute");
			boolean createsScopeVar = setFromBooleanAttribute(el, "allowanyattribute");
			
			Tag item = new Tag(name,single,xmlstyle,hybrid,anyAttribute,endtagrequired,allowanyattribute,canHaveAttributeCollection,createsScopeVar);
			this.tags.put(name, item);
		}
		
	}
	/**
	 * Helper function to get a boolean from an {@link org.jdom.Attribute} in an {@link Element} 
	 * @param element
	 * @param attributeName
	 * @return
	 */
	private boolean setFromBooleanAttribute(Element element, String attributeName){
		if(element.getAttributeValue(attributeName) == null){
			return false;
		}
		if(element.getAttributeValue(attributeName).equalsIgnoreCase("true")){
			return true;
		}
		return false;
	}
	
	public int getTagCount(){
		if(this.tags == null){
			return 0;
		}
		return this.tags.size();
	}

	public Tag getTag(String tagname) throws IOException, JDOMException {
		
		//Lazy Loading
		if(this.tags == null){
			loadLocation();
		}
		
		return this.tags.get(tagname);
	}
	

}
