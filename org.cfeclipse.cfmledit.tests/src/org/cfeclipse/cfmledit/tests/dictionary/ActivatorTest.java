package org.cfeclipse.cfmledit.tests.dictionary;

import static org.junit.Assert.*;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.junit.Test;
import org.osgi.framework.Bundle;

public class ActivatorTest {

	@Test
	public void testDictionaryPath() {
		try{
			Bundle bundle = Platform.getBundle("org.cfeclipse.cfmledit.dictionaries");
			assertNotNull(bundle);
			URL eclipsePath = FileLocator.find(bundle, new Path("dictionary/dictionaryconfig.xml"),null); 
			URL filePath = FileLocator.toFileURL(eclipsePath);
			assertEquals(filePath.toString(),"file:/Users/markdrew/Dropbox/Projects/cybersonic_CFMLEdit/org.cfeclipse.cfmledit.dictionaries/dictionary/dictionaryconfig.xml");
			
		}
		catch(Exception e){
			fail(e.getMessage());
		}
	}

}
