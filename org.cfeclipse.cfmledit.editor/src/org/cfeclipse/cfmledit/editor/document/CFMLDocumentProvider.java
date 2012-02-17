package org.cfeclipse.cfmledit.editor.document;

import org.cfeclipse.cfmledit.editor.partitioner.CFMPartitionScanner;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class CFMLDocumentProvider extends FileDocumentProvider {

	protected IDocument createDocument(Object element) throws CoreException {
		IDocument document = super.createDocument(element);
		if (document != null){
		//Attach the partitioner for .cfm files. looks for and comments tags mainly
		IDocumentPartitioner cmfPartitioner = 
				new FastPartitioner(
				new CFMPartitionScanner(), 
				new String[]{
					CFMPartitionScanner.CF_COMMENT
				}
				);
		
		cmfPartitioner.connect(document);
		document.setDocumentPartitioner(cmfPartitioner);
		}
		return document;
	}


}
