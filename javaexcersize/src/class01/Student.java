package class01;

import java.io.Serializable;

public class Student implements Serializable{

	Integer stuNum;
	String stuName;
	Integer checkAttmpet;
	Integer homworkScore;
	Integer experimentsScore;
	Integer midTermScore;
	Integer endTermScore;
	Double sumScore;
	
	
	
	
	public Student(Integer stuNum, String stuName, Integer checkAttmpet, Integer homworkScore, Integer experimentsScore,
			Integer midTermScore, Integer endTermScore, Double sumScore) {
		super();
		this.stuNum = stuNum;
		this.stuName = stuName;
		this.checkAttmpet = checkAttmpet;
		this.homworkScore = homworkScore;
		this.experimentsScore = experimentsScore;
		this.midTermScore = midTermScore;
		this.endTermScore = endTermScore;
		this.sumScore = sumScore;
	}
	
	public Double getSumScore() {
		return sumScore;
	}
	public void setSumScore(Double sumScore) {
		this.sumScore = sumScore;
	}
	public Integer getStuNum() {
		return stuNum;
	}
	public void setStuNum(Integer stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public Integer getCheckAttmpet() {
		return checkAttmpet;
	}
	public void setCheckAttmpet(Integer checkAttmpet) {
		this.checkAttmpet = checkAttmpet;
	}
	public Integer getHomworkScore() {
		return homworkScore;
	}
	public void setHomworkScore(Integer homworkScore) {
		this.homworkScore = homworkScore;
	}
	public Integer getExperimentsScore() {
		return experimentsScore;
	}
	public void setExperimentsScore(Integer experimentsScore) {
		this.experimentsScore = experimentsScore;
	}
	public Integer getMidTermScore() {
		return midTermScore;
	}
	public void setMidTermScore(Integer midTermScore) {
		this.midTermScore = midTermScore;
	}
	public Integer getEndTermScore() {
		return endTermScore;
	}
	public void setEndTermScore(Integer endTermScore) {
		this.endTermScore = endTermScore;
	}
	
	
}
