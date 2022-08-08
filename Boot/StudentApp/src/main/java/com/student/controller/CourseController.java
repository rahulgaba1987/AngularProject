package com.student.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.CourseEntity;
import com.student.entity.StudentEntity;
import com.student.exception.APIResponse;
import com.student.service.CourseService;

@RestController
@RequestMapping("/api/course")
@CrossOrigin(origins = { "http://localhost:4200"})
public class CourseController 
{
       @Autowired 
	   private CourseService courseService;
	
	   @PostMapping("/addCourse/{studentId}")
	   public ResponseEntity<CourseEntity>  createCourse(@RequestBody CourseEntity course, @PathVariable("studentId") int studentId)
	   {
		  CourseEntity createdcourse=   this.courseService.addCourse(course, studentId);
		   return new ResponseEntity<CourseEntity>(createdcourse,HttpStatus.CREATED);
	   }
	   
	   
	   @GetMapping("/getAllCourses")
	   public ResponseEntity<ArrayList<CourseEntity>>  getAllCourse()
	   {
		  ArrayList<CourseEntity> allCourseList=   (ArrayList<CourseEntity>) this.courseService.getAllCourses();
		   return new ResponseEntity<ArrayList<CourseEntity>>(allCourseList,HttpStatus.OK);
	   }
	   
	   @GetMapping("/getCourseById/{courseId}")
	   public ResponseEntity<CourseEntity>  getCourseById(@PathVariable("courseId") int courseId)
	   {
		      CourseEntity course = this.courseService.getCoursesById(courseId);
		      return new ResponseEntity<CourseEntity>(course,HttpStatus.OK);
	   }
	   
	   @DeleteMapping("/deleteCourseById/{courseId}")
	   public ResponseEntity<APIResponse>  deleteCourseById(@PathVariable("courseId") int courseId)
	   {
		       this.courseService.deleteCoursesById(courseId);
		    		  
		    return new ResponseEntity<APIResponse>(new APIResponse("Course is deleted successfully",true),HttpStatus.OK);
	   }
	   
	   @PutMapping("/updateCourseById/{courseId}")
	   public ResponseEntity<CourseEntity>  updateCourseById(@RequestBody CourseEntity courseEntity, @PathVariable("courseId") int courseId)
	   {
		       CourseEntity updatedCourse=   this.courseService.updateCoursesById(courseId, courseEntity);
		    		  
		    return new ResponseEntity<CourseEntity>(updatedCourse,HttpStatus.OK);
	   }
	   
	   @GetMapping("/getAllCoursesByStudent/{studentId}")
		public ResponseEntity<ArrayList<CourseEntity>>  getAllCoursesByStudnet(@PathVariable("studentId") int studentId)
		{
			ArrayList<CourseEntity>  courseList = (ArrayList<CourseEntity>) this.courseService.getAllCoursesByStudent(studentId);
			
			return new ResponseEntity<ArrayList<CourseEntity>>(courseList,HttpStatus.OK);
			
		}

}
