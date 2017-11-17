package fjnu.java.linli.io.serialize;

import java.io.Serializable;

public class Student implements Serializable{

	private String studentID = null;
	private String name = null ;
	private String sex = null;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}

