package class01;

import java.io.Serializable;

public class Course implements Serializable{
	String CourseName;
	String term;
	String className;
	
	public Course(String courseName, String term, String className) {
		super();
		CourseName = courseName;
		this.term = term;
		this.className = className;
	}
	
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	

}
