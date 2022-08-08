package com.student.repository;

import org.springframework.data.repository.CrudRepository;

import com.student.entity.StudentEntity;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer>
{
	
	   public StudentEntity  findByStudentEmailAndPassword(String studentEmail,String password);

}
