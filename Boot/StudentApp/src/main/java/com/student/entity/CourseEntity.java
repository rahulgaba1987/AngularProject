package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "course")
public class CourseEntity
{
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private int courseId;
	 
	 @Column(nullable = false)
	 private String courseName;
	 
	 @Column(nullable = false)
	 private String courseDuration;
	 
	 @Column(nullable = false)
	 private int fees;
	 
	 @ManyToOne
	 @JoinColumn(name="studentId")
	  @JsonBackReference
	 private StudentEntity student;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "CourseEntity [courseId=" + courseId + ", courseName=" + courseName + ", courseDuration="
				+ courseDuration + ", fees=" + fees + ", student=" + student + "]";
	}

	public CourseEntity(int courseId, String courseName, String courseDuration, int fees, StudentEntity student) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.fees = fees;
		this.student = student;
	}

	public CourseEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	 
	 
	 

}
