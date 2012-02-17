package org.cfeclipse.cfmledit.editor.editors;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

public class CFMWhitespaceDetector implements IWhitespaceDetector {

	@Override
	public boolean isWhitespace(char c) {
		return (c == ' ' || c == '\t' || c == '\n' || c == '\r');
	}

}