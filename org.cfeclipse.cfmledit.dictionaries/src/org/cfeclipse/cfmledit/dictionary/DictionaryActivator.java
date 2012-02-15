package org.cfeclipse.cfmledit.dictionary;


import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class DictionaryActivator implements BundleActivator {

	public static final String PLUGIN_ID = "org.cfeclipse.cfmledit.dictionaries";
	
	@Override
	public void start(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub

	}

	public static Bundle getBundle() {
		return Platform.getBundle(PLUGIN_ID);
	}

}
