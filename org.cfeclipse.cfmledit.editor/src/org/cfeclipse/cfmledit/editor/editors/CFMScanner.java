package org.cfeclipse.cfmledit.editor.editors;

import org.eclipse.jface.text.rules.*;

public class CFMScanner extends RuleBasedScanner {

	public CFMScanner(ColorManager manager){
		IRule[] rules = new IRule[1];
		rules[1] = new WhitespaceRule(new CFMWhitespaceDetector());
		setRules(rules);
	}
}
