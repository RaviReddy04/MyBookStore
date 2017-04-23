
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXMLFile {

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
			 

			System.out.println("----------------------------");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

//					System.out.println("Staff id : " + eElement.getAttribute("id"));
//					System.out.println(
//							"ASIN: " + eElement.getElementsByTagName("ASIN").item(0).getTextContent());
//					NodeList nList1 = doc.getElementsByTagName("MediumImage");
//					System.out.println(
//							"Detail Page URL : " + eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent());
					
					
					
					
					

					NodeList nList1 = doc.getElementsByTagName("MediumImage");
					 

					System.out.println("----------------------------");

					for (int t = 0; t < nList1.getLength(); t++) {

						Node nNode1 = nList1.item(t);

						System.out.println("\nCurrent Element :" + nNode1.getNodeName());

						if (nNode1.getNodeType() == Node.ELEMENT_NODE) {

							Element eElemen1t = (Element) nNode;

//							System.out.println("Staff id : " + eElement.getAttribute("id"));
//							System.out.println(
//									"ASIN: " + eElement.getElementsByTagName("ASIN").item(0).getTextContent());
//							NodeList nList1 = doc.getElementsByTagName("MediumImage");
//							System.out.println(
//									"Detail Page URL : " + eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent());
							System.out.println(
									"Description : " + eElemen1t.getElementsByTagName("URL").item(0).getTextContent());
//							System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
		//
						}
						
						
						
						
					}	
						
						
					
//					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
//
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}