
public class User {

	
	private String firstname;
	private String lastname;
	private String collegeid;
	private String email;
	private String gender;
	private String dob;
	private String address;
	private String password;
	private String role;
	
	
	public User() {
		super();
	}
	
	public User(String firstname, String lastname, String collegeid, String email, String gender, String dob,
			String address, String password, String role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.collegeid = collegeid;
		this.email = email;
		this.gender = gender;
		this.dob = dob;
		this.address = address;
		this.password = password;
		this.role = role;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(String collegeid) {
		this.collegeid = collegeid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
