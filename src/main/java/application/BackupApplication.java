package application;

import setup.Configure;

public class BackupApplication {

	public static void main(String[] args) {
		try {
			final String dir = System.getProperty("user.dir");
			System.out.println("##### APPLICATION DIR IS :  " + dir);
		} catch (Exception e) {
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
