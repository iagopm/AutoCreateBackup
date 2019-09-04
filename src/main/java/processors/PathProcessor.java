package processors;

import java.io.File;

import readers.PathReader;

public class PathProcessor {
	private String path;

	public PathProcessor() {
		final File file = new File(new PathReader().getBackupPath());
		if (!file.getPath().isEmpty()) {
			path = file.getPath();
		} else {
			path="";
		}
	}

	public String getPath() {
		return path;
	}

}
