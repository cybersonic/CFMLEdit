package org.cfeclipse.cfmledit.editor.editors;

import org.cfeclipse.cfmledit.editor.partitioner.CFMPartitionScanner;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;




public class CFMConfiguration extends SourceViewerConfiguration {
	private ColorManager colorManager;
	private CFMScanner scanner;
	
	
	public CFMConfiguration(ColorManager colorManager){
		this.colorManager = colorManager;
	}
	
	public String[] getConfiguredContentTypes(ISourceViewer sourceViewer) {
		return new String[] {
			IDocument.DEFAULT_CONTENT_TYPE,
				CFMPartitionScanner.CF_COMMENT
			};
	}
	
	protected CFMScanner getXMLScanner() {
		if (scanner == null) {
			scanner = new CFMScanner(colorManager);
			scanner.setDefaultReturnToken(
				new Token(
					new TextAttribute(
						colorManager.getColor(CFMColorConstants.DEFAULT))));
		}
		return scanner;
	}
	
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer){
		PresentationReconciler reconciler = new PresentationReconciler();
		
		NonRuleBasedDamagerRepairer ndr = 
				new NonRuleBasedDamagerRepairer(
					new TextAttribute(
							colorManager.getColor(CFMColorConstants.CF_COMMENT)));
		reconciler.setDamager(ndr, CFMPartitionScanner.CF_COMMENT);
		reconciler.setRepairer(ndr, CFMPartitionScanner.CF_COMMENT);
		
		return reconciler;
		
	}
}
