
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

/*
 * This class shows how to make a simple authenticated call to the
 * Amazon Product Advertising API.
 *
 * See the README.html that came with this sample for instructions on
 * configuring and running the sample.
 */
public class sample {

	/*
	 * Your AWS Access Key ID, as taken from the AWS Your Account page.
	 */
	private static final String AWS_ACCESS_KEY_ID = "AKIAJ3ID733MYPBKPMUA";

	/*
	 * Your AWS Secret Key corresponding to the above ID, as taken from the AWS
	 * Your Account page.
	 */
	private static final String AWS_SECRET_KEY = "ATyAXNgHSIuUuOvPZSPq0avC6HlWd1lb8f+Z7cQO";

	/*
	 * Use the end-point according to the region you are interested in.
	 */
	private static final String ENDPOINT = "webservices.amazon.com";

//	public static void main(String[] args) {
//		sample.searchBook("Computer");
//		
//		
//	}
	
	public static void searchBook(String Keyword){

		/*
		 * Set up the signed requests helper.
		 */
		SignedRequestsHelper helper;

		try {
			helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		String requestUrl = null;

		Map<String, String> params = new HashMap<String, String>();

			params.put("Service", "AWSECommerceService");
	        params.put("Operation", "ItemSearch");
	        params.put("AWSAccessKeyId", "AKIAJ3ID733MYPBKPMUA");
	        params.put("AssociateTag", "ravireddy0491");
	        params.put("SearchIndex", "Books");
	        params.put("Keywords", Keyword);
	        params.put("ResponseGroup", "Images,ItemAttributes,ItemIds,Reviews");
	        params.put("Availability", "Available");
	        params.put("MerchantId", "Amazon");

		requestUrl = helper.sign(params);

		System.out.println("Signed URL: \"" + requestUrl + "\"");
		String url = helper.sign(params);
		try {
			Document response = getResponse(url);
			printResponse(response);
		} catch (Exception ex) {
			ex.getStackTrace();
			// Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null,
			// ex);
		}
		
	}

	private static Document getResponse(String url) throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document doc = builder.parse(url);
		return doc;
	}

	private static void printResponse(Document doc) throws TransformerException, FileNotFoundException {
		Transformer trans = TransformerFactory.newInstance().newTransformer();
		Properties props = new Properties();
		props.put(OutputKeys.INDENT, "yes");
		trans.setOutputProperties(props);
		StreamResult res = new StreamResult(new StringWriter());
		DOMSource src = new DOMSource(doc);
		trans.transform(src, res);
		String toString = res.getWriter().toString();
		System.out.println(toString);

		StreamResult result = new StreamResult(new File("/Users/ravireddy/Desktop/file.xml"));

		trans.transform(src, result);

		System.out.println("File saved!");
	}
}
