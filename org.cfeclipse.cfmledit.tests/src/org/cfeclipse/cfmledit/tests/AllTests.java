package org.cfeclipse.cfmledit.tests;

import org.cfeclipse.cfmledit.tests.dictionary.ActivatorTest;
import org.cfeclipse.cfmledit.tests.dictionary.DictionaryTest;
import org.cfeclipse.cfmledit.tests.dictionary.GrammarTest;
import org.cfeclipse.cfmledit.tests.dictionary.VersionTest;
import org.cfeclipse.cfmledit.tests.wizards.ProjectTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DictionaryTest.class, VersionTest.class,ActivatorTest.class,GrammarTest.class, ProjectTest.class })
public class AllTests {

}
