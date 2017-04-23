
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {

	public static void main(String argv[]) {

		try {

			File fXmlFile = new File("/Users/ravireddy/Desktop/file.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			

			NodeList nList = doc.getElementsByTagName("Item");
			NodeList nList1 = doc.getElementsByTagName("LargeImage");

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);
				Node nNode1 = nList1.item(temp);
				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode1.getNodeType() == Node.ELEMENT_NODE ) {

					Element eElement = (Element) nNode;
					Element eElement1 = (Element) nNode1;	
					
					  String ASIN=eElement.getElementsByTagName("ASIN").item(0).getTextContent();
					  String ISBN=eElement.getElementsByTagName("ISBN").item(0).getTextContent();
					  String Title=eElement.getElementsByTagName("Title").item(0).getTextContent();
					  String ImageURL=eElement.getElementsByTagName("LargeImage").item(0).getTextContent();
					  String Publisher=eElement.getElementsByTagName("Publisher").item(0).getTextContent();
					  String PublicationDate=eElement.getElementsByTagName("PublicationDate").item(0).getTextContent();
					  String Price=eElement.getElementsByTagName("FormattedPrice").item(0).getTextContent();
					  String ProductGroup=eElement.getElementsByTagName("ProductGroup").item(0).getTextContent();
					  String DetailURL=eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent();
					  
					  MySQLDataStoreUtilities.insertProductsDetails(ASIN,ISBN, Title, ImageURL, Publisher, PublicationDate, Price, ProductGroup, DetailURL);
					
					  System.out.println("ASIN: " + eElement.getElementsByTagName("ISBN").item(0).getTextContent());
					System.out.println("ASIN: " + eElement.getElementsByTagName("ASIN").item(0).getTextContent());
					System.out.println("Title: " + eElement.getElementsByTagName("Title").item(0).getTextContent());
					System.out.println("ImageURL: " + eElement1.getElementsByTagName("URL").item(0).getTextContent());		
					System.out.println("Publisher : " + eElement.getElementsByTagName("Publisher").item(0).getTextContent());
					System.out.println("PublicationDate: " + eElement.getElementsByTagName("PublicationDate").item(0).getTextContent());
					System.out.println("FormattedPrice : " + eElement.getElementsByTagName("FormattedPrice").item(0).getTextContent());
					System.out.println("ProductGroup: " + eElement.getElementsByTagName("ProductGroup").item(0).getTextContent());
					System.out.println("Detail Page URL : " + eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent());
					
//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}