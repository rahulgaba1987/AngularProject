package com.student.service;

import java.util.ArrayList;

import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.student.entity.StudentEntity;

public interface StudentService
{
	public StudentEntity addStudent(StudentEntity student);
	
	public StudentEntity getStudentById(int studentId);
	
	public ArrayList<StudentEntity> getAllStudents();
	
	public StudentEntity updateStudentById(int studentId,StudentEntity studentEntity);
	
	public void deleteStudentbyId(int studentId);
	
	public StudentEntity  checkLogin(String username,String password);
	
	
	
	

}
