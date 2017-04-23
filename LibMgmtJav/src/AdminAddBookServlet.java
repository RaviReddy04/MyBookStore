
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/AdminAddBookServlet")
public class AdminAddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String collegeId = request.getParameter("collegeID");

		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);

		int count = MySQLDataStoreUtilities.getEnrollCount(collegeId);
		System.out.println(count);

		session.setAttribute("collegeId", collegeId);
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("</title>");
		out.println("<link rel='stylesheet' type='text/css' href='bootstrap.css'>");

		out.println(
				"<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println(
				"<style type='text/css'> form{ color: white; } h1{ color: white; } body{ background : url('https://images.unsplash.com/photo-1431608660976-4fe5bcc2112c?dpr=1&auto=compress,format&fit=crop&w=376&h=251&q=80&cs=tinysrgb&crop='); background-size: cover; background-position: center;	 } </style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<nav class='navbar navbar-default'>");
		out.println("<div class='container'>");

		out.println("<div class='navbar-header'>");
		out.println(
				"<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'>");
		out.println("<span class='sr-only'>' Toggle navigation </span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("</button>");
		out.println("<a class='navbar-brand' href='#'>");
		out.println("<i class='fa fa-book' aria-hidden='tr'<e> </i> My Book Tracker</a>");
		out.println("</div>");

		out.println("<!-- Collect the nav links, forms, and other content for toggling -->");
		out.println("<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>");
		out.println("<ul class='nav navbar-nav'>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-pencil-square' aria-hidden='true'>");
		out.println("</i> About Us <span class='sr-only'> (current) </span>");
		out.println("</a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-phone-square' aria-hidden='true'>");
		out.println("</i> Contact</a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");

		out.println("<ul class='nav navbar-nav navbar-right'>");
		out.println("<li>");
		out.println("<a href='myAccountServlet'>");
		out.println("<i class='fa fa-address-card' aria-hidden='true'>");
		out.println("</i> My Account </a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-sign-in' aria-hidden='true'>");
		out.println("</i>  Welcome " + u.getFirstname() + " " + u.getLastname() + " </a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<!-- /.navbar-collapse -->");
		out.println("</div>");
		out.println("<!-- /.container-fluid -->");
		out.println("</nav>");

		out.println("<div class='container'>");
		out.println("<div class='col-lg-6'>");

		out.println("<form method='post' action='AdminAddBookServlet' >");
		out.println("<h1>Add a new Book to My Book Tracker </h1>");
		out.println("<div class='form-group'>");
		out.println("<label for='KeyWord'> KeyWords </label>");
		out.println("<input name='KeyWord' type='text' class='form-control'  placeholder='Enter KeyWords To Search'>");
		out.println("<button type='submit' class='btn btn-default'>Update</button>");
		out.println("</form>");
		out.println("</div>");

		//
		// out.println("<h1>Add a new Book to My Book Tracker </h1>");
		// out.println("<div class='form-group'>");
		// out.println("<label for='ASIN'> ASIN </label>");
		// out.println("<input name='ASIN' type='text' class='form-control'
		// placeholder='ASIN'>");
		// out.println("</div>");

		out.println("</div>");
		out.println("</div>");

		out.println(
				"<script src='https://code.jquery.com/jquery-3.1.1.js' integrity='sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=' crossorigin='anonymous'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/bootstrap.min.js'>");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String collegeId = request.getParameter("collegeID");

		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);

		response.setContentType("text/html;charset=UTF-8");

		String Keyword = request.getParameter("KeyWord");
		System.out.println(Keyword);
		List<products> prodList = new ArrayList<products>();
		// sample newSearch = new sample();
		sample.searchBook(Keyword);

		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("</title>");
		out.println("<link rel='stylesheet' type='text/css' href='bootstrap.css'>");

		out.println(
				"<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println(
				"<style type='text/css'> form{ color: white; } h1{ color: white; } body{ background : url('https://images.unsplash.com/photo-1431608660976-4fe5bcc2112c?dpr=1&auto=compress,format&fit=crop&w=376&h=251&q=80&cs=tinysrgb&crop='); background-size: cover; background-position: center;	 } </style>");
		out.println("</head>");

		out.println("<body>");
		out.println("<nav class='navbar navbar-default'>");
		out.println("<div class='container'>");

		out.println("<div class='navbar-header'>");
		out.println(
				"<button type='button' class='navbar-toggle collapsed' data-toggle='collapse' data-target='#bs-example-navbar-collapse-1' aria-expanded='false'>");
		out.println("<span class='sr-only'>' Toggle navigation </span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("<span class='icon-bar'>");
		out.println("</span>");
		out.println("</button>");
		out.println("<a class='navbar-brand' href='#'>");
		out.println("<i class='fa fa-book' aria-hidden='tr'<e> </i> My Book Tracker</a>");
		out.println("</div>");

		out.println("<!-- Collect the nav links, forms, and other content for toggling -->");
		out.println("<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>");
		out.println("<ul class='nav navbar-nav'>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-pencil-square' aria-hidden='true'>");
		out.println("</i> About Us <span class='sr-only'> (current) </span>");
		out.println("</a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-phone-square' aria-hidden='true'>");
		out.println("</i> Contact</a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");

		out.println("<ul class='nav navbar-nav navbar-right'>");
		out.println("<li>");
		out.println("<a href='myAccountServlet'>");
		out.println("<i class='fa fa-address-card' aria-hidden='true'>");
		out.println("</i> My Account </a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-sign-in' aria-hidden='true'>");
		out.println("</i>  Welcome " + u.getFirstname() + " " + u.getLastname() + " </a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<!-- /.navbar-collapse -->");
		out.println("</div>");
		out.println("<!-- /.container-fluid -->");
		out.println("</nav>");

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

				if (nNode.getNodeType() == Node.ELEMENT_NODE && nNode1.getNodeType() == Node.ELEMENT_NODE) {
					products p = new products();
					Element eElement = (Element) nNode;
					Element eElement1 = (Element) nNode1;

					String ASIN = eElement.getElementsByTagName("ASIN").item(0).getTextContent();
					String ISBN = eElement.getElementsByTagName("ISBN").item(0).getTextContent();
					String Title = eElement.getElementsByTagName("Title").item(0).getTextContent();
					String ImageURL = eElement.getElementsByTagName("LargeImage").item(0).getTextContent();
					String Publisher = eElement.getElementsByTagName("Publisher").item(0).getTextContent();
					String PublicationDate = eElement.getElementsByTagName("PublicationDate").item(0).getTextContent();
					String Price = eElement.getElementsByTagName("FormattedPrice").item(0).getTextContent();
					String ProductGroup = eElement.getElementsByTagName("ProductGroup").item(0).getTextContent();
					String DetailURL = eElement.getElementsByTagName("DetailPageURL").item(0).getTextContent();

					p.setASIN(ASIN);
					p.setISBN(ISBN);
					p.setTitle(Title);
					p.setImageURL(ImageURL);
					p.setPublisher(Publisher);
					p.setPublicationDate(PublicationDate);
					p.setPrice(Price);
					p.setProductGroup(ProductGroup);
					p.setDetailsURL(DetailURL);
					prodList.add(p);

				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (products p : prodList) {
			out.println("<div class='row'>");

			out.println("<div style='color:black' class='col-lg-11 col-md-4 col-sm-6'>");

			out.println("<div class='thumbnail'>");
			
			out.println("<img src=" + p.getImageURL() + ">");
			out.println("<p> ASIN: " + p.getASIN() + "</p>");
			out.println("<p> ISBN: " + p.getISBN() + "</p>");
			out.println("<p> Title: " + p.getTitle() + "</p>");
			out.println("<p> Details URL:<a href=' " + p.getDetailsURL() + "'>Purchase On Amazon</a></p>");
			out.println("<form method='get' action='AddBookToDatabase'>");
			
			out.println("<input type='hidden' name='ASIN' value='" + p.getASIN() + "'>");
			out.println("<input type='hidden' name='ISBN' value='" + p.getISBN() + "'>");
			out.println("<input type='hidden' name='Title' value='" + p.getTitle() + "'>");
			out.println("<input type='hidden' name='ImageURL' value='" + p.getImageURL() + "'>");
			out.println("<input type='hidden' name='Publisher' value='" + p.getPublisher() + "'>");
			out.println("<input type='hidden' name='PublicationDate' value='" + p.getPublicationDate() + "'>");
			out.println("<input type='hidden' name='Price' value='" + p.getPrice() + "'>");
			out.println("<input type='hidden' name='ProductGroup' value='" + p.getProductGroup() + "'>");
			out.println("<input type='hidden' name='DetailPageURL' value='" + p.getDetailsURL() + "'>");
			out.println("<button type='submit' class='btn btn-default'>Add To Database</button>");
			
			
			out.println("</form'>");
			out.println("</div>");

			out.println("</div>");
			out.println("</div>");

		}

		out.println(
				"<script src='https://code.jquery.com/jquery-3.1.1.js' integrity='sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=' crossorigin='anonymous'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/bootstrap.min.js'>");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");

	}

}
