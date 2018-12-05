package de.axp.openbrowser;

import com.intellij.ide.browsers.BrowserFamily;

public class OpenChromeAction extends AbstractBrowserAction {

	@Override
	protected BrowserFamily getBrowserFamily() {
		return BrowserFamily.CHROME;
	}

	@Override
	protected String[] getAdditionalParameters() {
		return BrowserParameters.CHROME.getParams();
	}
}
