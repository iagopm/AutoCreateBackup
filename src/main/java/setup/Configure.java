package setup;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import writers.PathWriter;

public class Configure {
	private String path;

	public Configure() {
		setBackupFile();
		setBackupDir();
		JOptionPane.showMessageDialog(null, "RESTART MANUALLY");

	}

	private void setBackupFile() {
		JOptionPane.showMessageDialog(null, "SET THE FILE YOU WANT TO BACKUP");
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		Integer returnValue = jfc.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			path = selectedFile.getAbsolutePath();
			new PathWriter(path, 0);
		}
	}

	private void setBackupDir() {
		JOptionPane.showMessageDialog(null, "SET THE DIRECTORY TO STORE THE BACKUPS");
		JFileChooser jfc2 = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		jfc2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Integer returnValue2 = jfc2.showOpenDialog(null);
		if (returnValue2 == JFileChooser.APPROVE_OPTION) {
			File selectedFile2 = jfc2.getSelectedFile();
			path = selectedFile2.getAbsolutePath();
			new PathWriter(path, 1);
		}
	}
}
