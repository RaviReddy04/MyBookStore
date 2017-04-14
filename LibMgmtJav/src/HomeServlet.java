

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		PrintWriter out= response.getWriter();
		String collegeId= request.getParameter("collegeID");
		
		String password= request.getParameter("Password");
		String role= request.getParameter("role");
		System.out.println(collegeId+password+role);
		
		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);
		//System.out.println(u.getFirstname());
		
		
		
		int count=MySQLDataStoreUtilities.getEnrollCount(collegeId);
		System.out.println(count);
		
		
		
		
	if(collegeId!=null && password!=null && role!=null){
		 if(collegeId.equals(u.getCollegeid())&& password.equals(u.getPassword())&& role.equals(u.getRole())){
				 
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
				out.println("</i>  Welcome "+u.getFirstname()+" "+u.getLastname()+" </a>");
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
				
				
				out.println("<div class='list-group'>");
				out.println("<a href='courseListServlet' class='list-group-item active'>");
				out.println("<h4 class='list-group-item-heading'>All Courses</h4>");
				out.println("<p class='list-group-item-text'>List All the coursesi offered at the college</p>");
				out.println("</a>");
				out.println("</div>");
				
				
				out.println("<div class='list-group'>");
				out.println("<a href='MyCoursesServlet' class='list-group-item active'>");
				out.println("<h4 class='list-group-item-heading'>My Courses</h4>");
				out.println("<p class='list-group-item-text'>List All the coursesi am Enrolled in</p>");
				out.println("</a>");
				out.println("</div>");
				
				
				
				
				
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
	
	else{
			
			RequestDispatcher dis = request.getRequestDispatcher("/LoginFailure");
			dis.forward(request, response);
			//response.sendRedirect("/LoginFailure");
			
			response.setContentType("text/html;charset=UTF-8");

			
	}
		
	}	else{
		RequestDispatcher dis = request.getRequestDispatcher("/LoginFailure");
		dis.forward(request, response);
	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
