package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;

import readers.PathReader;

public class LaunchBackupService extends Thread {
	private String backupFile = new PathReader().getBackupPath();
	private Integer day = 86400000;
	private Integer year = 365;

	public LaunchBackupService() {

	}

	@Override
	public void run() {
		super.run();
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
		final String dir = System.getProperty("user.home");
		System.out.println("##### HOME DIR :  " + dir + "  ##### BACKUP TARGET DIR :  " + backupFile);
		Path backupPath = Paths.get(dir + "//BACKUPS");
		try {
			Files.createDirectory(backupPath);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void makeBackup() {
		final String dir = System.getProperty("user.home");
		System.out.println("##### HOME DIR :  " + dir + "  ##### FROM :  " + backupFile);

		String dirPath = dir + "/BACKUPS/BACKUP_" + new Random().nextInt();

		try {
			Path originalPath = Paths.get(backupFile);
			Path copied = Paths.get(dirPath);
			Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("##### HOME DIR :  " + dir + "  ##### TARGET :  " + dirPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
