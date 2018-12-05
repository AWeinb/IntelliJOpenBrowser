package de.axp.openbrowser;

import com.intellij.ide.browsers.BrowserFamily;

public class OpenIEAction extends AbstractBrowserAction {

	@Override
	protected BrowserFamily getBrowserFamily() {
		return BrowserFamily.EXPLORER;
	}

	@Override
	protected String[] getAdditionalParameters() {
		return BrowserParameters.IE.getParams();
	}
}
