package org.cfeclipse.cfmledit.tests.wizards;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import org.cfeclipse.cfmledit.ui.nature.Nature;
import org.cfeclipse.cfmledit.wizards.project.ProjectSupport;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.junit.Assert;
import org.junit.Test;
/*
 * More info: http://cvalcarcel.wordpress.com/2009/07/26/writing-an-eclipse-plug-in-part-4-create-a-custom-project-in-eclipse-new-project-wizard-the-behavior/
 */
public class ProjectTest {

	@Test
	public void testCreateProjectWithDifferentLocationArg() throws URISyntaxException, CoreException {
		String workspaceFilePath = "/Users/markdrew/Dropbox/Projects/testWorkspace";
		File workspace = createTempWorkspace(workspaceFilePath);
		String projectName = "delete-me";
		String projectPath = workspaceFilePath + "/" + projectName;
		URI location = new URI("file:/" + projectPath);
		
		assertProjectDotFileAndNatureExist(projectPath, projectName, location);
		
		
		//cleanup
		deleteTempWorkspace(workspace);
	}

	

	/* Assertion helper methods */
	
	
	private void assertProjectDotFileAndNatureExist(String projectPath,String projectName, URI location) throws CoreException {
			IProject project = ProjectSupport.createProject(projectName, location);
			String projectFilePath = projectPath + "/.project";
			
			assertNotNull(project);
			assertFileExists(projectFilePath);
			assertNatureIn(project);
			
			
			project.delete(true, null);
			
			
		
	}
	
	

	private void assertNatureIn(IProject project) throws CoreException {
		IProjectDescription descriptions = project.getDescription();
        String[] natureIds = descriptions.getNatureIds();
        if (natureIds.length != 1) {
           Assert.fail("No natures found in project."); //$NON-NLS-1$
        }
        
        if(!natureIds[0].equals(Nature.NATURE_ID)){
        	Assert.fail("CFMLEdit Natures not found in project");
        }
        	 

	}

	private void assertFileExists(String projectFilePath) {
		File file = new File(projectFilePath);
		        if (!file.exists()) {
		            Assert.fail("File " + projectFilePath + " does not exist.");
		        }
	}

	private File createTempWorkspace(String workspaceFilePath) {
		File workspace = new File(workspaceFilePath);
		if(!workspace.exists()){
			boolean dirCreated = workspace.mkdir();
			if(!dirCreated){
				Assert.fail("Unaable to create workspace at " + workspaceFilePath);
			}
		}
		return workspace;
	}
	
	private void deleteTempWorkspace(File workspace) {
		 boolean deleted = workspace.delete();
		 if (!deleted) {
			 Assert.fail("Unable to delete the new workspace dir at " + workspace); //$NON-NLS-1$
		 }
		
	}

}
