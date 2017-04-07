
public class courseList{
	
	private String courseId;
	private String courseName;
	
	
	
	public courseList(){
		
	}
	
	public courseList(String courseId, String courseName){
		this.courseId=courseId;
		this.courseName=courseName;
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