package com.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.student.entity.CourseEntity;
import com.student.entity.StudentEntity;

public interface CourseRepository extends CrudRepository<CourseEntity, Integer>
{

	//   @Query
	  // public void 
	// List<CourseEntity>  findByStudent(StudentEntity student);
	 
	 @Query(value="select * from  course c where c.student_id=:sid",nativeQuery=true) 
	 public List<CourseEntity>   getAllCoursesByStudentId(@Param("sid") int sid);
	 
	

	 
	
 }
