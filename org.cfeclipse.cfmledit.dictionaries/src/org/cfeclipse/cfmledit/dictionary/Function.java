package org.cfeclipse.cfmledit.dictionary;

public class Function {
	protected String name = null; 
	protected String returns = "void";
	protected String help = "";

	public Function(String name, String returns) {
		this.name = name;
		this.returns = returns;
	}

	public String getName() {
		return name;
	}

	public String getReturns() {
		return returns;
	}

	public String getHelp() {
		return help;
	}

	public void setHelp(String help) {
		this.help = help;
	}
	

}
