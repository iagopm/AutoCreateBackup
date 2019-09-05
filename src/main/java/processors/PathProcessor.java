package processors;

import java.io.File;

import readers.PathReader;

public class PathProcessor {
	private String path;

	public PathProcessor(Integer position) {
	
		File file = new File(new PathReader(position).getBackupPath());
	
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
