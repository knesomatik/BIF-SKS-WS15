package at.kleinknes.BookServiceWebApp;

import java.io.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class Main{

    public static void main (String[] args) throws IOException{
    	
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
        				
        		System.out.println("\nCurrent Element :" + nNode.getNodeName());
        				
        		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

        			Element eElement = (Element) nNode;

        			System.out.println("Book id : " + eElement.getAttribute("id"));
        			System.out.println("Title : " + eElement.getElementsByTagName("title").item(0).getTextContent());
        			System.out.println("PubYear : " + eElement.getElementsByTagName("pubYear").item(0).getTextContent());
        		}
        	}
            } catch (Exception e) {
        	e.printStackTrace();
            }
          }
  }