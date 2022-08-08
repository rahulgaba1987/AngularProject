package com.student.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
//  ORM OBJECT RELATION(TABLE)
@Entity
@Table(name="student")
public class StudentEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentRoll;
	
	@Column
	@NonNull
	private String studentName;
	
	@Column
	@NonNull
	private String studentClass;
	
	@Column
	@NonNull
	private String studentEmail;
	
	@Column
	@NonNull
	private String address;
	
	@Column
	@NonNull
	private String password;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<CourseEntity> courseList = new ArrayList<CourseEntity>();
	
	

	
	

	public List<CourseEntity> getCourseList() {
		return courseList;
	}

	public int getStudentRoll() {
		return studentRoll;
	}

	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}




	@Override
	public String toString() {
		return "StudentEntity [studentRoll=" + studentRoll + ", studentName=" + studentName + ", studentClass="
				+ studentClass + ", studentEmail=" + studentEmail + ", address=" + address + ", password=" + password
				+ ", courseList=" + courseList + "]";
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCourseList(List<CourseEntity> courseList) {
		this.courseList = courseList;
	}

	public StudentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
