
public class Enroll {
	
	private String collegeID;
	
	private String courseId;
	
	private String courseName;


	
	
	public Enroll(String collegeID, String courseId, String courseName) {
		super();
		this.collegeID = collegeID;
		this.courseId = courseId;
		this.courseName = courseName;
	}
	
	
	
	
	
	public Enroll() {
		// TODO Auto-generated constructor stub
	}





	public String getCollegeID() {
		return collegeID;
	}


	public void setCollegeID(String collegeID) {
		this.collegeID = collegeID;
	}


	public String getCourseId() {
		return courseId;
	}


	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}


	public String getCourseName() {
		return courseName;
	}


	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



}
