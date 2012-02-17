package org.cfeclipse.cfmledit.wizards.project;

import java.net.URI;

import org.cfeclipse.cfmledit.ui.nature.Nature;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class ProjectSupport {

	public static IProject createProject(String projectName, URI location){
		Assert.isNotNull(projectName);
		Assert.isTrue(projectName.trim().length() > 0);
		
		IProject project = createBaseProject(projectName, location);
		
		try {
			addNature(project);
		} catch (CoreException e) {
			e.printStackTrace();
			project = null;
		}
		
		return project;
	}

	private static void addNature(IProject project) throws CoreException {

		if(!project.hasNature(Nature.NATURE_ID)){
			IProjectDescription description = project.getDescription();
			String[] prevNatures = description.getNatureIds();
			String[] newNatures = new String[prevNatures.length+1];
			System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
			newNatures[prevNatures.length] = Nature.NATURE_ID;
			description.setNatureIds(newNatures);
			project.setDescription(description, null);
		}
		
		
		
	}

	private static IProject createBaseProject(String projectName, URI location) {
		IProject newProject = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName);
		
		if(!newProject.exists()){
			URI projectLocation = location;
			IProjectDescription desc = newProject.getWorkspace().newProjectDescription(newProject.getName());
			
			if(location != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(location)){
				projectLocation = null;
			}
			
			desc.setLocationURI(projectLocation);
			
			try {
				newProject.create(desc, null);
				if(!newProject.isOpen()){
					newProject.open(null);
				}
			}catch (CoreException e){
				e.printStackTrace();
			}
		}
		
		return newProject;
		
	}
}
