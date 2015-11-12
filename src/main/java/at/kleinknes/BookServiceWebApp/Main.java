package at.kleinknes.BookServiceWebApp;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BookWS myTest = new BookWS();
		int count = 1;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String test = br.readLine();

		try {

			File fXmlFile = new File(test);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("book");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				//System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;
					String newTitle = eElement.getAttribute("title");
					Book newBook = new Book();
					newBook.setTitle(newTitle);
					System.out.println("Book id : " + count);
					System.out.println("Title : " + eElement.getAttribute("title"));
					System.out.println("PubYear : " + eElement.getAttribute("pubYear") + "\n");
					//myTest.saveBook(newBook);
					count++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
