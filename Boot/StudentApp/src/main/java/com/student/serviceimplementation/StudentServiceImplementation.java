package com.student.serviceimplementation;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.StudentEntity;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImplementation implements StudentService
{

	@Autowired
	 private StudentRepository studentRepository;
	
	@Override
	public StudentEntity addStudent(StudentEntity student) 
	{
		
		 StudentEntity savedstudent= studentRepository.save(student);
		 return savedstudent;
	}

	@Override
	public StudentEntity getStudentById(int studentId) {
		// TODO Auto-generated method stub
		
		      
		StudentEntity getStudent=      this.studentRepository.findById(studentId).orElseThrow(
				()-> new ResourceNotFoundException("Student","student Roll",studentId));
		return getStudent;
	}

	@Override
	public ArrayList<StudentEntity> getAllStudents() {
		// TODO Auto-generated method stub
		
		
		return (ArrayList<StudentEntity>) this.studentRepository.findAll();
//		ArrayList<StudentEntity> studentList=   (ArrayList<StudentEntity>) studentRepository.findAll();
//		return studentList;
	}

	@Override
	public StudentEntity updateStudentById(int studentId, StudentEntity studentEntity)
	{
		StudentEntity updatedStudent=      this.studentRepository.findById(studentId).orElseThrow(
				()-> new ResourceNotFoundException("Student","student Roll",studentId));
		
		
		updatedStudent.setStudentRoll(studentEntity.getStudentRoll());
		updatedStudent.setStudentName(studentEntity.getStudentName());
		updatedStudent.setPassword(studentEntity.getPassword());
		updatedStudent.setStudentEmail(studentEntity.getStudentEmail());
		updatedStudent.setStudentClass(studentEntity.getStudentClass());
		updatedStudent.setAddress(studentEntity.getAddress());
		
		
		
		return this.studentRepository.save(updatedStudent);
	}

	@Override
	public void deleteStudentbyId(int studentId) 
	{
		   
		StudentEntity getStudent=      this.studentRepository.findById(studentId).orElseThrow(
				()-> new ResourceNotFoundException("Student","student Roll",studentId));
		
		
		     this.studentRepository.delete(getStudent);		
		
	}

	@Override
	public StudentEntity checkLogin(String username, String password)
	{	
		   StudentEntity studentEntity=   this.studentRepository.findByStudentEmailAndPassword(username, password);
		return studentEntity;
	}

}
