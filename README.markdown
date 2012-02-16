CFEDit: an IDE for CFML based languages
=======================================
CFEdit is a re-write of the popular [CFEclipse project](https://github.com/cfeclipse/cfeclipse). 

Why a re-write?
---------------
CFEclipse was written over a long period of time, by a number of developers. A lot of the knowledge and best practices have been lost in the mysts of time so the idea is to start organising parts of the editor into sub plugins. 

Also, by splitting the main project out into sub-plugins, Unit Tests can be run, which in turn allow new developers and contributors to see how the API should be used and the ideas behind it. 


What's here?
------------
You will notice that there are three plugins currently:

org.cfeclipse.cfmledit.libraries
org.cfeclipse.cfmledit.dictionaries
org.cfeclipse.cfmledit.tests

*	org.cfeclipse.cfmledit.libraries : This is the plugin that currently
holds all the external JAR's and libraries. Currently only JDOM (for
XML parsing and creation) is there along with Jaxer.
*	org.cfeclipse.cfmledit.dictionaries: This is where the Dictionary
Loader, Tags, Functions and Scopes are held. They are loaded from the
XML files (that we all know and love) that define all the lookups that
will be used with other plugins. It is dependent on the .libraries
project
*	 org.cfeclipse.cfmledit.tests: which holds all
the tests and the JUnit jar. You can check them out, and if you want
to run them, you can right click on a test and do run as ... JUnit
Plug in Test, it will then create a "run configuration".go and edit
your run configurations (menu: run -> run configurations) and in the
Main tab, make sure it's set as a Run an application:
org.eclipse.ui.workbench. And the tests should run.


