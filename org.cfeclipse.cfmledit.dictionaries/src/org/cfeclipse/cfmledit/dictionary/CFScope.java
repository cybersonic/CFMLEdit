package org.cfeclipse.cfmledit.dictionary;

public class CFScope {
		
		protected String name = "";
		protected String help = "";
		public CFScope(String name) {
			super();
			this.name = name;
		}
		
		
		

		public String getName() {
			return name;
		}

		public String getHelp() {
			return help;
		}
		public void setHelp(String help) {
			this.help = help;
		}
		
}
