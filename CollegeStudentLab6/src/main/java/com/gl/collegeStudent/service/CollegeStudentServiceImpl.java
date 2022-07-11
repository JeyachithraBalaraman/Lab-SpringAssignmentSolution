package com.gl.collegeStudent.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gl.collegeStudent.entity.CollegeStudent;
import com.gl.collegeStudent.repository.CollegeStudentRepository;
@Service
public class CollegeStudentServiceImpl implements CollegeStudentService {
	@Autowired
	CollegeStudentRepository collegeStudentRepository;

	@Override
	public List<CollegeStudent> findAll() {
		
		List<CollegeStudent> collegeStudents=collegeStudentRepository.findAll();
		return collegeStudents;
	}

	@Override
	public CollegeStudent findById(int theId) {
		
		return collegeStudentRepository.findById(theId).get();
	}

	@Override
	public void save(CollegeStudent thecollegeStudent) {
		collegeStudentRepository.save(thecollegeStudent);
		
	}

	@Override
	public void deleteById(int theId) {
			collegeStudentRepository.deleteById(theId);
		
	}

	@Override
	public List<CollegeStudent> searchBy(String firstname, String lastname) {
		
		List<CollegeStudent> collegeStudents=collegeStudentRepository.findByFirstnameContainsAndLastnameContainsAllIgnoreCase(firstname, lastname);
		return collegeStudents;
	}
}

