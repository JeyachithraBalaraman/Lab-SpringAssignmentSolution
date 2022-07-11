package com.gl.collegeStudent.repository;
import com.gl.collegeStudent.entity.*;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;



public interface CollegeStudentRepository extends JpaRepository<CollegeStudent, Integer> {

	List<CollegeStudent> findByFirstnameContainsAndLastnameContainsAllIgnoreCase(String firstname,String lastname);
	
}