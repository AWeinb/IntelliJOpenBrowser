package de.axp.openbrowser;

import com.intellij.ide.browsers.BrowserFamily;

public class OpenFirefoxAction extends AbstractBrowserAction {

	@Override
	protected BrowserFamily getBrowserFamily() {
		return BrowserFamily.FIREFOX;
	}

	@Override
	protected String[] getAdditionalParameters() {
		return BrowserParameters.FIREFOX.getParams();
	}
}
