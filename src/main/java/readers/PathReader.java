package readers;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class PathReader {

	private String backupPath;

	public PathReader(Integer position) {
		File file = new File("paths.xml");
		System.out.println("##### paths.xml PATHS :  " + file.getAbsolutePath());
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;

		Document document;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);
			setBackupPath(document.getElementsByTagName("path").item(position).getTextContent());
			System.out.println("##### PATHREADER :  " + backupPath);
		} catch (Exception e) {
		}
	}

	public String getBackupPath() {
		return backupPath;
	}

	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}

}
