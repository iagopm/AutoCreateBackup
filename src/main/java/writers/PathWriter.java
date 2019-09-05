package writers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class PathWriter {

	public PathWriter(String path) {
		final File file = new File("paths.xml");
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder;
		Document document;
		try {
			documentBuilder = documentBuilderFactory.newDocumentBuilder();
			document = documentBuilder.parse(file);

			System.out
					.println("##### OLD PATH IS :  " + document.getElementsByTagName("path").item(0).getTextContent());
			System.out.println("##### PATH SET TO :  " + path);

			document.getElementsByTagName("path").item(0).setTextContent(path);

			System.out
					.println("##### NEW PATH IS :  " + document.getElementsByTagName("path").item(0).getTextContent());

			Transformer tf = TransformerFactory.newInstance().newTransformer();
			tf.setOutputProperty(OutputKeys.INDENT, "yes");
			tf.setOutputProperty(OutputKeys.METHOD, "xml");
			tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource domSource = new DOMSource(document);

			StreamResult sr = new StreamResult(new File("paths.xml"));

			tf.transform(domSource, sr);
		} catch (Exception e) {
		}
	}
}
