package org.cfeclipse.cfmledit.tests.dictionary;

import static org.junit.Assert.*;

import java.io.IOException;

import org.cfeclipse.cfmledit.dictionary.CFScope;
import org.cfeclipse.cfmledit.dictionary.Function;
import org.cfeclipse.cfmledit.dictionary.Grammar;
import org.cfeclipse.cfmledit.dictionary.Scope;
import org.cfeclipse.cfmledit.dictionary.Tag;
import org.jdom.JDOMException;
import org.junit.Test;

public class GrammarTest {

	@Test
	public void testLoadLocation() throws IOException, JDOMException {
		
		Grammar g = new Grammar("railo3.xml");
		
		assertEquals(0, g.getTagCount());
		assertEquals(0, g.getFunctionCount());
		assertEquals(0, g.getScopeCount());
		assertEquals(0, g.getCFScopeCount());
		
		g.loadLocation();
		
		assertTrue("There should be more than 0 tags loaded now", g.getTagCount() > 0);
		assertTrue("There should be more than 0 functions loaded now", g.getFunctionCount() > 0);
		assertTrue("There should be more than 0 scopes loaded now", g.getScopeCount() > 0);
		assertTrue("There should be more than 0 CFScopes loaded now", g.getCFScopeCount() > 0);
		

	}
	/**
	 * Tests that we can get tags and they have some attributes associated with them
	 * I have added some tests but as bugs are found with tags, we should split this out to individual tag tests
	 * TODO: Create language/tag/function scope tests for each language version
	 */
	@Test 
	public void testGetTag() throws IOException, JDOMException {
		Grammar g = new Grammar("railo3.xml");
		Tag tag = g.getTag("cfabort");
		assertEquals(tag.getName(), "cfabort");
		assertTrue(tag.getHelp().length()>0);
		assertTrue(tag.isSingle());
		assertFalse(tag.isXMLStyle());
		
		Tag tag1 = g.getTag("cfif");
		assertFalse("CFFIF should allow any tag", tag1.isCanHaveAttributeCollection());
		assertFalse("CFFIF needs a closing CFIF", tag1.isSingle());
		
		
	}
	
	@Test
	public void testGetFunction() throws IOException, JDOMException {
		Grammar g = new Grammar("railo3.xml");
		Function function = g.getFunction("imageDrawRect");
		assertEquals(function.getName(), "imageDrawRect");
		assertEquals(function.getReturns(), "void");
		assertTrue(function.getHelp().length()>0);
		
	}
	
	@Test
	public void testGetScope() throws IOException, JDOMException {
		Grammar g = new Grammar("railo3.xml");
		//type="String" value="Server.ColdFusion.ProductName">
		Scope scope= g.getScope("Server.ColdFusion.ProductName");
		assertEquals(scope.getValue(), "Server.ColdFusion.ProductName");
		assertEquals(scope.getType(), "String");
		assertTrue(scope.getHelp().length()>0);
	}
	
	@Test
	public void testGetCFScope() throws IOException, JDOMException {
		Grammar g = new Grammar("railo3.xml");
		//type="String" value="Server.ColdFusion.ProductName">
		CFScope cfscope= g.getCFScope("Client");
		assertEquals(cfscope.getName(), "Client");
		assertTrue(cfscope.getHelp().length()>0);
	}
}
