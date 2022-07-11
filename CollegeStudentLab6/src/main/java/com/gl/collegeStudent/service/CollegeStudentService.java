package com.gl.collegeStudent.service;
import java.util.List;
import com.gl.collegeStudent.entity.CollegeStudent;

public interface CollegeStudentService {

	public List<CollegeStudent> findAll();

	public CollegeStudent findById(int theId);

	public void save(CollegeStudent collegeStudent);

	public void deleteById(int theId);

	public List<CollegeStudent> searchBy(String firstname, String lastname);

}
