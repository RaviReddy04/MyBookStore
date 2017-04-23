
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String collegeId = (String) session.getAttribute("collegeId");
		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);

		session.setAttribute("collegeId", collegeId);

		response.setContentType("text/html;charset=UTF-8");

		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("</title>");
		out.println("<link rel='stylesheet' type='text/css' href='bootstrap.css'>");

		out.println(
				"<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println(
				"<style type='text/css'> table{ color: white; } h1{ color: white; } body{ background : url('https://images.unsplash.com/photo-1470173274384-c4e8e2f9ea4c?dpr=1&auto=compress,format&fit=crop&w=376&h=251&q=80&cs=tinysrgb&crop='); background-size: cover; background-position: center;	 } </style>");
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
		
		
		
//		out.println("<li>");
//		out.println("<form class='navbar-form navbar-left' name='autofillform' action='autocomplete'>");
//		out.println("<div class='form-group'>");
//		out.println("<input type='text' class='form-control' placeholder='Search'>");
//		out.println("</div>");
//		out.println("<button type='submit' class='btn btn-default'>Submit</button>");
//		out.println("</form>");
//		out.println("</li>");
//		
		
		
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");
		
		
		
		out.println("<ul class='nav navbar-nav navbar-right'>");
		out.println("<li>");
		out.println("<a href='#'>");
		out.println("<i class='fa fa-user-plus' aria-hidden='true'>");
		out.println("</i> Sign Up </a>");
		out.println("</li>");
		out.println("<li>");
		out.println("<a href='Login.html'>");
		out.println("<i class='fa fa-sign-in' aria-hidden='true'>");
		out.println("</i>  Login In </a>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</li>");
		out.println("</ul>");
		out.println("</div>");
		out.println("<!-- /.navbar-collapse -->");
		out.println("</div>");
		out.println("<!-- /.container-fluid -->");
		out.println("</nav>");

		
		
		
//		out.println("<div class='container'>");
//
//	
//		out.println("<ul class='nav navbar-nav navbar-right'>");
//		out.println("<li>");
//		
//		out.println("</ul>");
//		out.println("</li>");
//		out.println("</div>");
		
		
		
		out.println("<div class='container'>");
		
		
		out.println("<form name='autofillform' action='autocomplete'>");
		out.println("<table border='0' cellpadding='5'>");
		out.println("<tbody>");
		out.println("<tr>");
		out.println(
				"<input type='text' class='form-control' placeholder='Search'  id='complete-field' onkeyup='doCompletion()'>");
		out.println("</td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td id='auto-row' colspan='2'>");

		out.println("<table id='complete-table' class='popupBox' />");
		out.println("</td>");
		out.println("</tr>");
		out.println("</tbody>");
		out.println("</table>");
		out.println("</form>");
		out.println("<br><br><br><br><br><br>");

		
		List<products> myproducts = MySQLDataStoreUtilities.productsListFetch();
		for (products p : myproducts) {

			String ASIN = p.getASIN();
			String ISBN = p.getISBN();
			out.println("<div class='row'>");

			out.println("<div style='color:black' class='col-lg-11 col-md-4 col-sm-6'>");

			out.println("<div class='thumbnail'>");
			out.println("<img src=" + p.getImageURL() + ">");
			out.println("<p> ASIN: " + p.getASIN() + "</p>");
			out.println("<p> ISBN: " + p.getISBN() + "</p>");
			out.println("<p> Title: " + p.getTitle() + "</p>");
			out.println("<p> Details URL:<a href=' " + p.getDetailsURL() + "'>Purchase O	n Amazon</a></p>");

			if (MySQLDataStoreUtilities.checkBookStatus(collegeId, ISBN) == null) {
				out.println("<form class = 'submit-button' method='get' action='issueBookServlet'>");
				out.println("<input type='hidden' name='collegeId' value='" + collegeId + "'>");
				out.println("<input type='hidden' name='BookISBN' value='" + ISBN + "'>");
				
				out.println("<input class = 'submit-button' type = 'submit' name = 'Issue' value = 'Issue Book'>");
				//out.println("<input  type='hidden' name='Issue' value='Issue Book'>");

				out.println("</form>");
			} else if (MySQLDataStoreUtilities.checkBookStatus(collegeId, ISBN)=="pending"){
				out.println("<input type = 'submit' name = 'Issue' value = 'Pending'>");
				
			} else if(MySQLDataStoreUtilities.checkBookStatus(collegeId, ISBN)== "granted"){
				out.println("<form class = 'submit-button' method='get' action='issueBookServlet'>");
				out.println("<input class = 'submit-button' type = 'submit' name = 'Issue' value = 'Return'>");
				//out.println("<input  type='hidden' name='Issue' value='Return'>");
				out.println("</form>");
			}

			out.println("</div>");

			out.println("</div>");
			out.println("</div>");

		}

		out.println("</div>");

		out.println(
				"<script src='https://code.jquery.com/jquery-3.1.1.js' integrity='sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=' crossorigin='anonymous'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/bootstrap.min.js'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/courseCheck.js'>");
		out.println("</script>");

		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

}
