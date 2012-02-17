package org.cfeclipse.cfmledit.editor.editors;

import org.cfeclipse.cfmledit.editor.document.CFMLDocumentProvider;
import org.eclipse.ui.editors.text.TextEditor;

public class CFMLEditor extends TextEditor {


	public CFMLEditor() {
		super();
		//colorManager = new ColorManager();
		//	setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new CFMLDocumentProvider());
	}
	public void dispose() {
		//colorManager.dispose();
		super.dispose();
	}

}
