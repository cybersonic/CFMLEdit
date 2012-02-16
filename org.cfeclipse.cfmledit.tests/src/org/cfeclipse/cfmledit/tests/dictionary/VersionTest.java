package org.cfeclipse.cfmledit.tests.dictionary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.cfeclipse.cfmledit.dictionary.Dictionary;
import org.cfeclipse.cfmledit.dictionary.Version;
import org.junit.Test;

public class VersionTest {

	@Test
	public void testGetVersionFromDictionary() throws Exception {
		Dictionary dict = Dictionary.getInstance();
		ArrayList<Version> versions = dict.getVersions();
		assertEquals("org.cfeclipse.cfmledit.dictionary.Version", versions.get(0).getClass().getName());
	}


}
