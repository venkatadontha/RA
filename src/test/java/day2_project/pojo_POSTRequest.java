package day2_project;

public class pojo_POSTRequest 
{

	String name;
	String location;
	String phone;
	String courses[];
	
	//To genreate the getters and setters
	//First select the 4 variables and then goto Source --> Generate Getters and Setters option
	//Select all the variable and click on Generate
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String[] getCourses() {
		return courses;
	}
	public void setCourses(String[] courses) {
		this.courses = courses;
	}
}