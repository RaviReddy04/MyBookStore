

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginFailure
 */
@WebServlet("/LoginFailure")
public class LoginFailure extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public LoginFailure() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		PrintWriter out= response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>");
		out.println("</title>");
		out.println("<link rel='stylesheet' type='text/css' href='bootstrap.css'>");

		out.println(
				"<link rel='stylesheet' type='text/css' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css'>");
		out.println(
				"<style type='text/css'> form{ color: white; } h1{ color: white; } body{ background : url('https://images.unsplash.com/photo-1422112528461-3186878f87dc?dpr=1&auto=compress,format&fit=crop&w=1199&h=899&q=80&cs=tinysrgb&crop='); background-size: cover; background-position: center;	 } </style>");
		out.println("</head>");

		out.println("<body>");
		
		out.println("<div class='container'>");
		out.println("<div class='row'>");
		out.println("<div class='col-lg-12'>");
		out.println("<div id='content'>");
		
		
		out.println("<h1 align='center'><p><strong>Sorry you are not Registered!</strong></p></h1>");
		out.println("<h2 align='center'><a  href='RegisterServlet'> Click here To Register </a></h2>");
		out.println("<h2 align='center'><a href='Login.html'> Click here To Login Again </a></h2>");
		
		out.println("</div>");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
