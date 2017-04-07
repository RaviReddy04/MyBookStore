
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		String id = "A";
		Random number = new Random();
		int n = number.nextInt(10000) + 100000;
		String StudentID = id + n;
		System.out.println(StudentID);
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

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

		out.println("<div class='container'>");
		out.println("<div class='col-lg-6'>");
		out.println("<h1> My Book Tracker </h1>");
		out.println("<form method='post' action='RegisterServlet' >");

		out.println("<div class='form-group'>");
		out.println("<label for='FirstName'> First Name </label>");
		out.println("<input name='FirstName' type='text' class='form-control'  placeholder='First Name'>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='LastName'> Last Name </label>");
		out.println("<input name='LastName' type='text' class='form-control' placeholder='Last Name'>");
		out.println("</div>");
		out.println("<div class='form-group'>");
		out.println("<label for='StudentID'> Student ID  </label>");
		out.println("<input name='StudentID' value='" + StudentID + "' class='form-control' readonly>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='Email'> Email address </label>");
		out.println("<input	type='email' class='form-control' name='Email' placeholder='Email'>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for'gender'> Gender </label>");

		out.println("<select name='gender'>");

		out.println("<option>Male</option>");
		out.println("<option>Female</option>");
		out.println("</select>");
		// out.println("<input type='radio' class='form-control' name='gender'
		// value='Male'>Male ");
		// out.println("<input type='radio' class='form-control' name='gender'
		// value='Female'>Female");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='DOB'> Date Of Birth </label>");
		out.println("<input name='DOB' type='date' class='form-control'  placeholder='Date'>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='Address'> Address </label>");
		out.println("<textarea	rows='3' cols='10' class='form-control' name='Address' placeholder='Address'>");
		out.println("</textarea>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<label for='exampleInputPassword1'> Password </label>");
		out.println(
				"<input type='password' name='password' class='form-control' id='exampleInputPassword1' placeholder='Password'>");
		out.println("</div>");

		out.println("<div class='form-group'>");
		out.println("<div class='form-inline'>");
		out.println("<label> Role??? </label><br>");
		out.println(
				"<label for='student'> Student </label> <input id='student' name='role' type='radio' class='form-control' value='student'>");
		out.print("  &emsp;  ");
		out.println(
				"<label for='instructor'>    Instructor </label>  <input name='role' id='instructor' type='radio' class='form-control' value='instructor'>");
		out.println("</div>");
		out.println("</div>");

		out.println("<button type='submit' class='btn btn-default'>Submit</button>");
		out.println("</form>");
		out.println("</div>");
		out.println("</div>");

		out.println(
				"<script src='https://code.jquery.com/jquery-3.1.1.js' integrity='sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=' crossorigin='anonymous'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/bootstrap.min.js'>");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session = request.getSession();

		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String CollegeID = request.getParameter("StudentID");
		String Email = request.getParameter("Email");
		String gender = request.getParameter("gender");
		String DOB = request.getParameter("DOB");
		String Address = request.getParameter("Address");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		System.out.println(FirstName + LastName + CollegeID + Email + gender + DOB + Address + password + role);

		MySQLDataStoreUtilities.insertSignINDetails(CollegeID,FirstName, LastName, Email, gender, DOB, Address,
				password, role);
		// out.println("<h1>Registered Succesfully</h1>");
		// out.println("<h1>Enjoy Shopping at Best Deal</h1>");
		// out.println("<h2>Click here to login and Experience Best Deal
		// <h2>");out.println("<a href='Login'>Sign in</a>");

		
		response.setContentType("text/html;charset=UTF-8");

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
		out.println("<a href='RegisterServlet'>");
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

		out.println("<div class='container'>");
		out.println("<div class='col-lg-6'>");
		out.println("<h1> My Book Tracker </h1>");
		out.println("<h2> Registered Successfully </h2>");
		out.println("<button type='submit' href='Login.html' class='btn btn-default'>Login</button>");
		out.println("</div>");
		out.println("</div>");

		out.println(
				"<script src='https://code.jquery.com/jquery-3.1.1.js' integrity='sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=' crossorigin='anonymous'>");
		out.println("</script>");
		out.println("<script src='/LibMgmtJav/WebContent/bootstrap.min.js'>");
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
		

		// TODO Auto-generated method stub

	}

}
