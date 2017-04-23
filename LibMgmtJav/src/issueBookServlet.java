
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/issueBookServlet")
public class issueBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();

		String me=request.getParameter("Issue");
				System.out.println(me);
		String collegeId = (String) request.getParameter("collegeId");
		String ISBN = (String) request.getParameter("BookISBN");
		String status = "pending";
		
		System.out.println(collegeId + ISBN + status);
		User u = MySQLDataStoreUtilities.getSignInDetails(collegeId);

		MySQLDataStoreUtilities.insertIssuedBooks(collegeId, ISBN, status);
		//
		 RequestDispatcher rd = request.getRequestDispatcher("bookServlet");
		 rd.forward(request, response);

		// response.setContentType("text/html;charset=UTF-8");
		session.setAttribute("collegeId", collegeId);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
