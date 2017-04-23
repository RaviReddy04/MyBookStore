
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.authentication.MysqlClearPasswordPlugin;

@WebServlet("/courseListServlet")
public class courseListServlet extends HttpServlet {
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

		System.out.println(collegeId);
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

		out.println("<form method='post' action='courseListServlet''>");
		out.println("<div class='container'>");
		out.println("<div class='col-lg-6'>");
		out.println("<h1><strong>Courses Offered</strong></h1>");

		out.println("<table class='table table-bordered'>");
		out.println("<thead>");

		out.println("<th>Enrolled</th>");
		out.println("<th>Course Id</th>");
		out.println("<th>Course Name</th>");
		out.println("</thead>");

		out.println("<tbody>");

		List<courseList> mycourses = MySQLDataStoreUtilities.courseListFetch();
		for (courseList course : mycourses) {
			String courseid = course.getCourseId();
			String coursename = course.getCourseName();

			out.println("<tr>");
			System.out.println(courseid+coursename);

			out.println("<td><input type='checkbox' name='courseid' value='" + courseid + "'></td> ");
			out.println("<input type='hidden' name='coursename' value='" + coursename + "'></td> ");
			out.println("<td>" + course.getCourseId() + "</td>");
			out.println("<td>" + course.getCourseName() + "</td>");
			out.println("</tr>");

		}

		out.println("</tbody>");

		out.println("</table>");

		out.println("<input type='submit'>");
		out.println("</div>");
		out.println("</div>");

		out.println("</form>");

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String collegeId = (String) session.getAttribute("collegeId");
		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);

		session.setAttribute("collegeId", collegeId);

//		BLAAAAAAAAAAAAAAAAAAAHHHHHH

		String[] coursesids = request.getParameterValues("courseid");
		
		//String[] coursesNames = MySQLDataStoreUtilities.getCourseDetails("courseid");
		// String[] courses= request.getParameterValues("course");

		if (MySQLDataStoreUtilities.getEnrollDetails(collegeId) != null) {
			MySQLDataStoreUtilities.updateEnrollDetails(collegeId);
			for (int i = 0; i < coursesids.length; i++) {
				courseList c=MySQLDataStoreUtilities.getCourseDetails(coursesids[i]);
				System.out.println(collegeId+coursesids[i]+c.getCourseName());
				
				
				MySQLDataStoreUtilities.insertsEnrolledCoursesDetails(collegeId, coursesids[i], c.getCourseName());
			}
			
		} else {
			for (int i = 0; i < coursesids.length; i++) {
				courseList c=MySQLDataStoreUtilities.getCourseDetails(coursesids[i]);
				System.out.println(collegeId);
				System.out.println(coursesids[i]);
				System.out.println(c.getCourseName());
				MySQLDataStoreUtilities.insertsEnrolledCoursesDetails(collegeId, coursesids[i], c.getCourseName());
			}
		}

	}

}
