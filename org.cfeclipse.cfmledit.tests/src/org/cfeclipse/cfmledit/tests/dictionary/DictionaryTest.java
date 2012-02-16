package org.cfeclipse.cfmledit.tests.dictionary;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.cfeclipse.cfmledit.dictionary.Dictionary;
import org.cfeclipse.cfmledit.dictionary.Version;
import org.junit.Test;

public class DictionaryTest {

	public void startup(){
		
	}
	
	@Test
	public void TestIsSingleton() {
		try{
			Dictionary dic1 = Dictionary.getInstance();
			Dictionary dic2 = Dictionary.getInstance();
			assertEquals(dic1, dic2);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	public void TestLoadDictionary() throws Exception{
		Dictionary dict = Dictionary.getInstance();
		ArrayList<Version> versions = dict.getVersions();
		assertTrue(versions.size()>0);
		
		
	}

}
