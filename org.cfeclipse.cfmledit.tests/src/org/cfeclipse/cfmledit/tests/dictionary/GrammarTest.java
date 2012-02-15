package org.cfeclipse.cfmledit.tests.dictionary;

import static org.junit.Assert.*;

import java.io.IOException;

import org.cfeclipse.cfmledit.dictionary.Grammar;
import org.cfeclipse.cfmledit.dictionary.Tag;
import org.jdom.JDOMException;
import org.junit.Test;

public class GrammarTest {

	@Test
	public void testLoadTags() throws IOException, JDOMException {
		
		Grammar g = new Grammar("railo3.xml");
		
		assertEquals(0, g.getTagCount());
		
		g.loadLocation();
		
		assertTrue("There should be more than 0 tags loaded now", g.getTagCount() > 0);
		
	}
	
	@Test
	public void testGetTag() throws IOException, JDOMException {
		Grammar g = new Grammar("railo3.xml");
		Tag tag = g.getTag("cfabort");
		
		assertEquals(tag.getName(), "cfabort");
		
	}

}
