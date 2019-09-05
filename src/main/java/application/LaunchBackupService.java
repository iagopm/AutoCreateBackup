package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import readers.PathReader;

public class LaunchBackupService extends Thread {
	private String backupFile = new PathReader(0).getBackupPath();
	private String backupDir = new PathReader(1).getBackupPath();
	private Integer day = 86400000;
	private Integer year = 365;

	public LaunchBackupService() {

	}

	@Override
	public void run() {
		super.run();
		System.out.println(backupDir);
		initDirectory();
		Integer iterator = 0;
		while (iterator < year) {
			makeBackup();
			iterator++;
			try {
				sleep(day);
			} catch (InterruptedException e) {
			}
		}
	}

	private void initDirectory() {
		Path backupPath = Paths.get(backupDir);
		try {
			Files.createDirectory(backupPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void makeBackup() {
		try {
			Path originalPath = Paths.get(backupFile);
			Path copied = Paths.get(backupDir+"/backup"+new Random().nextInt());
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("##### NEW BACKUP MADE");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
