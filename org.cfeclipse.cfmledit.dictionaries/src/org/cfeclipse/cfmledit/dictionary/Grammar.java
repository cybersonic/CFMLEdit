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
	private Map<String, Function> functions = null;
	private Map<String, Scope>  scopes = null;
	private Map<String, CFScope>  cfscopes = null;

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
			else if (el.getName().equalsIgnoreCase("functions")){
				parseFunctions(el);
			}
			else if (el.getName().equalsIgnoreCase("scopes")){
				parseScopes(el);
			}
			else if (el.getName().equalsIgnoreCase("cfscopes")){
				parseCFScopes(el);
			}
			else {
				System.out.println("Not handling " + el.getName());
			}
		}
		 
		return false;
		
	}
	private void parseCFScopes(Element elements) {
		this.cfscopes = new HashMap<String, CFScope>();
		List<Element> cfscopes = elements.getChildren();
		for (Element cfscope : cfscopes) {
			String name = cfscope.getAttributeValue("name");
			String help = "";
			if(cfscope.getChild("help") != null){
				help = cfscope.getChild("help").getTextTrim();
			}
			CFScope scope = new CFScope(name);
			scope.setHelp(help);
			this.cfscopes.put(name, scope);
		}
	}

	private void parseScopes(Element elements) {
		this.scopes = new HashMap<String, Scope>();
		elements = elements.getChild("scopes");
		List<Element> scopeel = elements.getChildren();
		for (Element element : scopeel) {
			String type = element.getAttributeValue("type");
			String value = element.getAttributeValue("value");
			String help = "";
			
			if(element.getChild("help") != null){
				help = element.getChild("help").getTextTrim();
			}
			Scope myScope = new Scope(type, value, help);
			this.scopes.put(value, myScope);
			
		}
		
	}

	/**
	 * Parses the functions in a similar way to tags and adds them to this.functions
	 * 
	 *   <function name="arrayClear" returns="boolean" >
	 * @param elements
	 */
	private void parseFunctions(Element elements) {
		this.functions = new HashMap<String, Function>();
		List<Element> funcs = elements.getChildren();
		for (Element func : funcs) {
			String name = func.getAttributeValue("name");
			String returns = "void";
			if(func.getAttributeValue("returns")!=null){
				returns = func.getAttributeValue("returns");
			}
			String help = "";
			if(func.getChild("help") != null){
				help = func.getChild("help").getTextTrim();
			}
			Function myFunction = new Function(name, returns);
			myFunction.setHelp(help);
			
			this.functions.put(name, myFunction);
		}
		
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
			
			String help = "";
			if(el.getChild("help") != null){
				help = el.getChild("help").getTextTrim();
			}
			
			
			Tag item = new Tag(name,single,xmlstyle,hybrid,anyAttribute,endtagrequired,allowanyattribute,canHaveAttributeCollection,createsScopeVar);
				item.setHelp(help);
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

	public Tag getTag(String tagName) throws IOException, JDOMException {
		//Lazy Loading
		if(this.tags == null){
			loadLocation();
		}
		return this.tags.get(tagName);
	}
	
	public Function getFunction(String functionName) throws IOException, JDOMException {
		//Lazy Loading
		if(this.functions == null){
			loadLocation();
		}
		return this.functions.get(functionName);
	}

	public Scope getScope(String scopeName) throws IOException, JDOMException {
		//Lazy Loading
		if(this.scopes == null){
			loadLocation();
		}
		return this.scopes.get(scopeName);
	}
	
	public CFScope getCFScope(String CfSCopeName) throws IOException, JDOMException {
		//Lazy Loading
		if(this.cfscopes == null){
			loadLocation();
		}
		return this.cfscopes.get(CfSCopeName);
	}
	
	public int getFunctionCount() {
		if(this.functions == null){
			return 0;
		}
		return this.functions.size();
	}

	public int getScopeCount() {
		if(this.scopes == null){
			return 0;
		}
		return this.scopes .size();
	}

	public int getCFScopeCount() {
		if(this.cfscopes == null){
			return 0;
		}
		return this.cfscopes .size();
	}

	

	
	

}
