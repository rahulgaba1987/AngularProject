package com.student.serviceimplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.entity.CourseEntity;
import com.student.entity.StudentEntity;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.CourseRepository;
import com.student.repository.StudentRepository;
import com.student.service.CourseService;

@Service
public class CourseServiceImplementation implements CourseService
{
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	

	@Override
	public CourseEntity addCourse(CourseEntity courseEntity, int studentId) 
	{
				StudentEntity student=  this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","Student Id",studentId));

		courseEntity.setStudent(student);
		
      	CourseEntity savedCourse=	  this.courseRepository.save(courseEntity);
		
		
		return savedCourse;
	}

	@Override
	public List<CourseEntity> getAllCourses() {
		// TODO Auto-generated method stub
		
		ArrayList<CourseEntity>  courseList=      (ArrayList<CourseEntity>) this.courseRepository.findAll();
		
		return courseList;
	}

	@Override
	public CourseEntity getCoursesById(int courseId) {
		// TODO Auto-generated method stub
		
		CourseEntity courseEntity=  this.courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","course Id",courseId));

		return courseEntity;
	}

	@Override
	public void deleteCoursesById(int courseId) {
		CourseEntity courseEntity=  this.courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","course Id",courseId));
		
		this.courseRepository.delete(courseEntity);
	
	
	}

	@Override
	public CourseEntity updateCoursesById(int courseId, CourseEntity courseEntity) {
		// TODO Auto-generated method stub
		CourseEntity updatedCourseEntity=  this.courseRepository.findById(courseId).orElseThrow(()-> new ResourceNotFoundException("Course","course Id",courseId));
		
		updatedCourseEntity.setCourseId(courseEntity.getCourseId());
		updatedCourseEntity.setCourseName(courseEntity.getCourseName());
		updatedCourseEntity.setFees(courseEntity.getFees());
		updatedCourseEntity.setCourseDuration(courseEntity.getCourseDuration());
		//updatedCourseEntity.setStudent(courseEntity.getStudent());
		
		
		return this.courseRepository.save(updatedCourseEntity);		
	}

	@Override
	public List<CourseEntity> getAllCoursesByStudent(int studentId) {
		// TODO Auto-generated method 
		
		
		return this.courseRepository.getAllCoursesByStudentId(studentId);

//		StudentEntity student=  this.studentRepository.findById(studentId).orElseThrow(()-> new ResourceNotFoundException("Student","Student Id",studentId));
//		 return  this.courseRepository.findByStudent(student);
		
	}

}
