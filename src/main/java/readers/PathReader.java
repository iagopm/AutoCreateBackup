package readers;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;

public class PathReader {
	static Logger log = LogManager.getLogger(PathReader.class.getName());

	private String backupPath;

	public PathReader() {
		File file = new File("paths.xml");
		System.out.println("##### paths.xml PATHS :  " + file.getAbsolutePath());
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;

		Document document;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);
			setBackupPath(document.getElementsByTagName("path").item(0).getTextContent());

			System.out.println("##### PATH TO BACKUP :  " + backupPath);
		} catch (Exception e) {
			log.error("PATH NOT FOUND OR XML IS DAMAGED");
		}
	}

	public String getBackupPath() {
		return backupPath;
	}

	public void setBackupPath(String backupPath) {
		this.backupPath = backupPath;
	}

}
