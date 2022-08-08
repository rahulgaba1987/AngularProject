package com.student.service;

import java.util.List;

import com.student.entity.CourseEntity;

public interface CourseService
{
     public CourseEntity  addCourse(CourseEntity courseEntity,int studentId);
     
     // Get all the courses
     public List<CourseEntity>  getAllCourses();
     
     
     // Get course by Id
     public CourseEntity  getCoursesById(int courseId);
     
     // delete course by Id
     public void  deleteCoursesById(int courseId);
     
     // update course by Id
     public CourseEntity  updateCoursesById(int courseId,CourseEntity courseEntity);
     
  // Get all the courses
     public List<CourseEntity>  getAllCoursesByStudent(int studentId);
     
}
