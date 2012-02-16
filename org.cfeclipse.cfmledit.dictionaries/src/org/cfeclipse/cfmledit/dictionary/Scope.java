package org.cfeclipse.cfmledit.dictionary;


/**
 * Global scope object that holds scopes like FORM, SERVER, SESSION etc. 
 * <scope type="String" value="Server.ColdFusion.ProductName">
		-
		<help>
		ColdFusion product name, usually "ColdFusion Server" 
		</help>
		</scope>
		-
 * @author markdrew
 *
 */
public class Scope {
	protected String type = null;
	protected String value = "";
	protected String help = "";
	public Scope(String type, String value, String help) {
		super();
		this.type = type;
		this.value = value;
		this.help = help;
	}
	public String getHelp() {
		return help;
	}
	public void setHelp(String help) {
		this.help = help;
	}
	public String getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	
}
