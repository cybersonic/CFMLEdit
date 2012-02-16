package org.cfeclipse.cfmledit.tests;

import org.cfeclipse.cfmledit.tests.dictionary.DictionaryTest;
import org.cfeclipse.cfmledit.tests.dictionary.VersionTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DictionaryTest.class, VersionTest.class })
public class AllTests {

}
