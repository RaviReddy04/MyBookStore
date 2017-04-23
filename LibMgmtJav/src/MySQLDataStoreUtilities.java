import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class MySQLDataStoreUtilities {

	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		Connection con;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/LibraryDataBase", "root",
					"root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public static String checkBookStatus(String collegeID, String BookISBN) {
		
		String present=null;
		int count = 0;
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String userQuery = "SELECT status FROM issuedBooks WHERE ISBN=? AND collegeID=?  ;";
			PreparedStatement pst = connect.prepareStatement(userQuery);
			pst.setString(1, BookISBN);
			pst.setString(2, collegeID);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {

				 present = resultSet.getString("status");

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		// return false;;
		System.out.println("Hello "+ present);
		return present;
	}

	public static void insertIssuedBooks(String collegeID, String ISBN, String status) {

		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String insertProductDetails = "INSERT INTO issuedBooks( collegeID,ISBN, status) " + "VALUES (?,?,?);";
			PreparedStatement pst = connect.prepareStatement(insertProductDetails);
			pst.setString(1, collegeID);
			pst.setString(2, ISBN);
			pst.setString(3, status);

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertProductsDetails(String ASIN, String ISBN, String title, String imageURL, String publisher,
			String publicationDate, String price, String productGroup, String detailsURL) {

		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String insertProductDetails = "INSERT INTO productsLoad( ASIN,ISBN, title,  imageURL,  publisher, publicationDate, price,  productGroup, detailsURL) "
					+ "VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = connect.prepareStatement(insertProductDetails);
			pst.setString(1, ASIN);
			pst.setString(2, ISBN);
			pst.setString(3, title);
			pst.setString(4, imageURL);
			pst.setString(5, publisher);
			pst.setString(6, publicationDate);
			pst.setString(7, price);
			pst.setString(8, productGroup);
			pst.setString(9, detailsURL);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<products> productsListFetch() {
		List<products> mylist = new ArrayList<>();

		try {

			Connection connect = MySQLDataStoreUtilities.getConnection();
			String getUsersQuery = "SELECT ASIN, ISBN, title,  imageURL,  publisher, publicationDate, price,  productGroup, detailsURL FROM productsLoad;";
			PreparedStatement pst = connect.prepareStatement(getUsersQuery);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				products c = new products();
				c.setASIN(resultSet.getString("ASIN"));
				c.setISBN(resultSet.getString("ISBN"));
				c.setTitle(resultSet.getString("title"));
				c.setImageURL(resultSet.getString("imageURL"));
				c.setPublisher(resultSet.getString("publisher"));
				c.setPublicationDate(resultSet.getString("publicationDate"));
				c.setPrice(resultSet.getString("price"));
				c.setProductGroup(resultSet.getString("productGroup"));
				c.setDetailsURL(resultSet.getString("detailsURL"));

				mylist.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		return mylist;

	}

	public static void insertSignINDetails(String collegeID, String firstName, String lastName, String email,
			String gender, String dOB, String address, String password, String role) {

		System.out.println(firstName + lastName + collegeID + email + gender + dOB + address + password + role);
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String insertCustomerDetails = "INSERT INTO userData( collegeID, firstName,  lastName,  email, gender, DOB,  address, password,  role) "
					+ "VALUES (?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = connect.prepareStatement(insertCustomerDetails);
			pst.setString(1, collegeID);
			pst.setString(2, firstName);
			pst.setString(3, lastName);
			pst.setString(4, email);
			pst.setString(5, gender);
			pst.setString(6, dOB);
			pst.setString(7, address);
			pst.setString(8, password);
			pst.setString(9, role);

			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insertsEnrolledCoursesDetails(String collegeID, String courseId, String courseName) {

		System.out.println(collegeID + courseId + courseName);
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String insertCustomerDetails = "INSERT INTO enrollmentData(  collegeID,  courseId,  courseName) "
					+ "VALUES (?,?,?);";
			PreparedStatement pst = connect.prepareStatement(insertCustomerDetails);
			pst.setString(1, collegeID);
			pst.setString(2, courseId);
			pst.setString(3, courseName);
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int getEnrollCount(String collegeID) {

		int count = 0;
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String userQuery = "SELECT * FROM enrollmentData WHERE collegeID=?;";
			PreparedStatement pst = connect.prepareStatement(userQuery);
			pst.setString(1, collegeID);
			ResultSet resultSet = pst.executeQuery();

			while (resultSet.next()) {
				++count;

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return count;
	}

	public static Enroll getEnrollDetails(String collegeID) {
		Enroll u = new Enroll();
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String userQuery = "SELECT  collegeID,courseId,courseName  FROM enrollmentData WHERE collegeID=?;";
			PreparedStatement pst = connect.prepareStatement(userQuery);
			pst.setString(1, collegeID);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				u.setCollegeID(collegeID);
				u.setCourseId(resultSet.getString("courseId"));
				u.setCourseName(resultSet.getString("courseName"));

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return u;
	}

	public static void updateEnrollDetails(String collegeID) {

		try {

			Connection connection = MySQLDataStoreUtilities.getConnection();
			String getProductsQuery = "delete from enrollmentData where collegeID=?;";
			PreparedStatement pst = connection.prepareStatement(getProductsQuery);
			pst.setString(1, collegeID);
			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static courseList getCourseDetails(String courseId) {
		courseList u = new courseList();
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String userQuery = "SELECT  courseID,courseName FROM courseListTable WHERE courseID=?;";
			PreparedStatement pst = connect.prepareStatement(userQuery);
			pst.setString(1, courseId);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				u.setCourseId(courseId);
				u.setCourseName(resultSet.getString("courseName"));

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return u;
	}

	public static List<Enroll> enrollCourseListFetch(String collegeID) {
		List<Enroll> mylist = new ArrayList<>();

		try {

			Connection connect = MySQLDataStoreUtilities.getConnection();
			String getUsersQuery = "SELECT courseId,courseName FROM enrollmentData where collegeID=?;";
			PreparedStatement pst = connect.prepareStatement(getUsersQuery);
			pst.setString(1, collegeID);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				Enroll c = new Enroll();
				c.setCollegeID(collegeID);
				c.setCourseId(resultSet.getString("courseId"));
				c.setCourseName(resultSet.getString("courseName"));
				mylist.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		return mylist;

	}

	public static User getSignInDetails(String collegeID) {
		User u = new User();
		try {
			Connection connect = MySQLDataStoreUtilities.getConnection();
			String userQuery = "SELECT  collegeID,firstName,lastName ,email,gender,DOB, address, password , role  FROM userData WHERE collegeID=?;";
			PreparedStatement pst = connect.prepareStatement(userQuery);
			pst.setString(1, collegeID);
			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				u.setCollegeid(collegeID);
				u.setFirstname(resultSet.getString("firstName"));
				u.setLastname(resultSet.getString("lastName"));
				u.setEmail(resultSet.getString("email"));
				u.setGender(resultSet.getString("gender"));
				u.setDob(resultSet.getString("DOB"));
				u.setAddress(resultSet.getString("address"));
				u.setPassword(resultSet.getString("password"));
				u.setRole(resultSet.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
		return u;
	}

	public static void updateSignInDetails(String collegeID, String firstName, String lastName, String email,
			String gender, String dOB, String address, String password, String role) {
		System.out.println(firstName + lastName + collegeID + email + gender + dOB + address + password + role);
		try {

			Connection connection = MySQLDataStoreUtilities.getConnection();
			String getProductsQuery = "update userData set firstName=?,lastName=?,email=?,gender=?,DOB=?,address=?,password=?,role=? where collegeID=?;";
			PreparedStatement pst = connection.prepareStatement(getProductsQuery);
			pst.setString(1, firstName);
			pst.setString(2, lastName);
			pst.setString(3, email);
			pst.setString(4, gender);
			pst.setString(5, dOB);
			pst.setString(6, address);
			pst.setString(7, password);
			pst.setString(8, role);
			pst.setString(9, collegeID);

			pst.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static List<courseList> courseListFetch() {
		List<courseList> mylist = new ArrayList<>();

		try {

			Connection connect = MySQLDataStoreUtilities.getConnection();
			String getUsersQuery = "SELECT courseID,courseName FROM courseListTable;";
			PreparedStatement pst = connect.prepareStatement(getUsersQuery);

			ResultSet resultSet = pst.executeQuery();
			while (resultSet.next()) {
				courseList c = new courseList();
				c.setCourseId(resultSet.getString("courseID"));
				c.setCourseName(resultSet.getString("courseName"));
				System.out.println(resultSet.getString("courseID"));
				System.out.println(resultSet.getString("courseName"));
				mylist.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}

		return mylist;

	}

}
