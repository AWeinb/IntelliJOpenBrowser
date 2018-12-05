package de.axp.openbrowser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jetbrains.annotations.NotNull;

import com.intellij.execution.ExecutionManager;
import com.intellij.execution.process.BaseOSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.openapi.project.Project;

public final class UrlComputation {

	@NotNull
	public static String executeFor(Project project) {
		String commandLine = getCommandLineOfAllRunning(project);
		String port = getPort(commandLine);
		String mode = isSuperDevModeRunning(commandLine) ? "/?superdevmode" : "";
		return "http://localhost" + ":" + port + "/XYZ" + mode;
	}

	private static String getCommandLineOfAllRunning(Project project) {
		ExecutionManager instance = ExecutionManager.getInstance(project);
		ProcessHandler[] runningProcesses = instance.getRunningProcesses();
		StringBuilder commandLine = new StringBuilder();
		for (ProcessHandler runningProcess : runningProcesses) {
			BaseOSProcessHandler p = (BaseOSProcessHandler) runningProcess;
			commandLine.append(" ").append(p.getCommandLine());
		}
		return commandLine.toString();
	}

	private static String getPort(String commandLine) {
		Matcher matcher = Pattern.compile(".*-port\\s(?<port>\\d{2,4})\\s.*").matcher(commandLine);
		if (matcher.matches()) {
			String port = matcher.group("port");
			return port == null ? "80" : port;
		}
		return "80";
	}

	private static boolean isSuperDevModeRunning(String commandLine) {
		return commandLine.contains("run-codeserver");
	}
}
