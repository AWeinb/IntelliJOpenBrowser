package de.axp.openbrowser;

import com.intellij.ide.browsers.BrowserFamily;
import com.intellij.ide.browsers.BrowserLauncher;
import com.intellij.ide.browsers.WebBrowser;
import com.intellij.ide.browsers.WebBrowserManager;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;

public abstract class AbstractBrowserAction extends AnAction {

	@Override
	public void actionPerformed(AnActionEvent e) {
		Project project = e.getData(PlatformDataKeys.PROJECT);
		if (project == null) {
			return;
		}

		String url = UrlComputation.executeFor(project);
		WebBrowser firstBrowser = WebBrowserManager.getInstance().getFirstBrowser(getBrowserFamily());
		BrowserLauncher.getInstance().browseUsingPath(url, null, firstBrowser, null, getAdditionalParameters());
	}

	protected abstract BrowserFamily getBrowserFamily();

	protected abstract String[] getAdditionalParameters();
}
