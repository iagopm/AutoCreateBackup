package setup;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

import writers.PathWriter;

public class Configure {
	private String path;
	public Configure() {
		JOptionPane.showMessageDialog(null, "SET YOUR PATH");
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		Integer returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			path=selectedFile.getAbsolutePath();
			new PathWriter(path);
		}
		JOptionPane.showMessageDialog(null, "RESTART MANUALLY");

	}
}
