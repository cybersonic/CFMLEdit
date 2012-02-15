package org.cfeclipse.cfmledit.dictionary;


public class Tag {
	/** the name of the tag **/
	protected String name = null; 

	protected boolean single = false;
	protected boolean xmlstyle = false;
	protected boolean hybrid = false;
	protected boolean anyAttribute = false;
	protected boolean endtagrequired = false;
	protected boolean allowanyattribute = false;
	protected boolean canHaveAttributeCollection = false;
	protected boolean createsScopeVar = false;
	
	
	/**
	 * Create a tag with all the attributes as they should be set
	 * @param name
	 * @param single
	 * @param xmlstyle
	 * @param hybrid
	 * @param anyAttribute
	 * @param endtagrequired
	 * @param allowanyattribute
	 * @param canHaveAttributeCollection
	 * @param createsScopeVar
	 */
	
	public Tag(String name, boolean single, boolean xmlstyle, boolean hybrid,
			boolean anyAttribute, boolean endtagrequired,
			boolean allowanyattribute, boolean canHaveAttributeCollection,
			boolean createsScopeVar) {
		super();
		this.name = name;
		this.single = single;
		this.xmlstyle = xmlstyle;
		this.hybrid = hybrid;
		this.anyAttribute = anyAttribute;
		this.endtagrequired = endtagrequired;
		this.allowanyattribute = allowanyattribute;
		this.canHaveAttributeCollection = canHaveAttributeCollection;
		this.createsScopeVar = createsScopeVar;
	}


	public String getName() {
		return name;
	}


	public boolean isSingle() {
		return single;
	}


	public boolean isXmlstyle() {
		return xmlstyle;
	}


	public boolean isHybrid() {
		return hybrid;
	}


	public boolean isAnyAttribute() {
		return anyAttribute;
	}


	public boolean isEndtagrequired() {
		return endtagrequired;
	}


	public boolean isAllowanyattribute() {
		return allowanyattribute;
	}


	public boolean isCanHaveAttributeCollection() {
		return canHaveAttributeCollection;
	}


	public boolean isCreatesScopeVar() {
		return createsScopeVar;
	}

}
