package de.axp.openbrowser;

public enum BrowserParameters {

	CHROME("-incognito", "-new-window"), //
	IE("-nosessionmerging", "-noframemerging", "-private"), //
	FIREFOX("-private-window");

	private final String[] params;

	BrowserParameters(String... params) {
		this.params = params;
	}

	public String[] getParams() {
		return params;
	}
}
