package com.student.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.CourseEntity;
import com.student.entity.StudentEntity;
import com.student.exception.APIResponse;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/student")

@CrossOrigin(origins = { "http://localhost:4200"})
public class StudentController
{
	@Autowired
	private StudentService  studentService;
	
	//@RequestMapping(value="/addStudent",method = RequestMethod.POST)
	@PostMapping("/addStudent")
	public ResponseEntity<StudentEntity> createStudent(@RequestBody StudentEntity studentEntity)
	{
		
		   System.out.println(studentEntity);
	
	     StudentEntity createdStudent=	studentService.addStudent(studentEntity);
	     return new ResponseEntity<StudentEntity>(createdStudent,HttpStatus.CREATED);
		  
	}
	@GetMapping("/getAllStudents")
	public ResponseEntity<ArrayList<StudentEntity>>  getAllStudents()
	{
		ArrayList<StudentEntity>  studentList = this.studentService.getAllStudents();
		return new ResponseEntity<ArrayList<StudentEntity>>(studentList,HttpStatus.OK);
	}
	
	@GetMapping("/getStudent/{studentId}")  // URI template variable
	public ResponseEntity<StudentEntity> getStudentById(@PathVariable("studentId") int studentId)
	{
		    StudentEntity   student= this.studentService.getStudentById(studentId);
		    return new ResponseEntity<StudentEntity>(student,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteStudent/{studentId}")  // URI template variable
	public ResponseEntity<APIResponse>  deleteRecordById(@PathVariable("studentId") int studentId)
	{
		    this.studentService.deleteStudentbyId(studentId);
		    APIResponse response = new APIResponse();
		    response.setMessage("Student is successfully deleted");
		    response.setSuccess(true);
		    return new ResponseEntity<APIResponse>(response,HttpStatus.OK);
	}
	
	
	@PutMapping("/updateStudent/{studentId}")  // URI template variable
	public ResponseEntity<StudentEntity>  updateStudentById(@RequestBody StudentEntity studentEntity,@PathVariable("studentId") int studentId)
	{
		 StudentEntity updatedStudent=   this.studentService.updateStudentById(studentId, studentEntity);
		   
		    return new ResponseEntity<StudentEntity>(updatedStudent,HttpStatus.OK);
	}
	
	@GetMapping("/check")
	public ResponseEntity<StudentEntity> checkLogin(@RequestParam("email") String email,@RequestParam("password") String password)
	{
		System.out.println("Original     "+email+"    "+password);
		     //  JWT  2. RoutingGuards
		    String status="invalid";
		    // username="sagar@gmail.com";
		    // password="12345";
		     StudentEntity checkedStudentEntity=   this.studentService.checkLogin(email, password);
		    // System.out.println(checkedStudentEntity.getStudentEmail()+"-------------------"+checkedStudentEntity.getPassword());
		    
		     if(checkedStudentEntity!=null)
		     {
		    	 status="valid";
		     }

		     
		     return new ResponseEntity<StudentEntity>(checkedStudentEntity,HttpStatus.OK);
		   
		  
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
