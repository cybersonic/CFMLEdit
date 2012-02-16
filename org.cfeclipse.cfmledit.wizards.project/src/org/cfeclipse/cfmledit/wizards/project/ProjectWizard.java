package org.cfeclipse.cfmledit.wizards.project;

import java.net.URI;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

public class ProjectWizard extends Wizard implements INewWizard {

	private WizardNewProjectCreationPage _pageOne;

	
	public ProjectWizard() {
		 setWindowTitle("CFMLEdit New Project Wizard");

	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {

	}

	@Override
	public boolean performFinish() {
		
		String projectName = _pageOne.getProjectName();
		URI location = null;
		if(!_pageOne.useDefaults()){
			location = _pageOne.getLocationURI();
		}
		
		ProjectSupport.createProject(projectName, location);
			
		return true;
	}

	@Override
	public void addPages() {
		// TODO Auto-generated method stub
		super.addPages();
		_pageOne = new WizardNewProjectCreationPage("New CFMLEdit Project");
		_pageOne.setTitle("CFMLEdit Project");
		addPage(_pageOne);
	}
	
	

}
