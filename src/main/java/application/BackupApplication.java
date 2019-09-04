package application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import setup.Configure;

public class BackupApplication {
	static Logger log = LogManager.getLogger(BackupApplication.class.getName());

	public static void main(String[] args) {
		try {
			final String dir = System.getProperty("user.dir");
			System.out.println("##### APPLICATION DIR IS :  " + dir);
		} catch (Exception e) {
			log.error("NO HOME DIRECTORY WAS FOUND");
			System.exit(0);
		}
		Boolean check = new InitialCheck().getCheck();

		if (check) {
			new LaunchBackupService().run();
		} else {
			new Configure();
		}
	}

}
