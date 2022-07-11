package com.gl.collegeStudent.controller;

import java.security.Principal;
import java.util.List;

import com.gl.collegeStudent.entity.CollegeStudent;
import com.gl.collegeStudent.service.CollegeStudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/collegeStudents")
public class CollegeStudentController {

	@Autowired
	private CollegeStudentService collegeStudentService;

	// add mapping for "/list"

	@RequestMapping("/list")
	public String listCollegeStudent(Model theModel) {

		// get CollegeStudents from db
		List<CollegeStudent> thecollegeStudent = collegeStudentService.findAll();

		// add to the spring model
		theModel.addAttribute("CollegeStudents", thecollegeStudent);

		return "list-CollegeStudents";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		CollegeStudent theCollegeStudent = new CollegeStudent();

		theModel.addAttribute("CollegeStudent", theCollegeStudent);

		return "CollegeStudent-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {

		// get the CollegeStudent from the service
		CollegeStudent theCollegeStudent = collegeStudentService.findById(id);

		// set collegeStudent as a model attribute to pre-populate the form
		theModel.addAttribute("CollegeStudent", theCollegeStudent);

		// send over to our form
		return "CollegeStudent-form";
	}

	@PostMapping("/save")
	public String saveCollegeStudent(@RequestParam("id") int id, @RequestParam("firstname") String firstname,
			@RequestParam("lastname") String lastname, @RequestParam("course") String course,@RequestParam("country") String country) {

		System.out.println(id);
		CollegeStudent theCollegeStudent;
		if (id != 0) {
			theCollegeStudent = collegeStudentService.findById(id);
			theCollegeStudent.setFirstname(firstname);
			theCollegeStudent.setLastname(lastname);
			theCollegeStudent.setCourse(course);
			theCollegeStudent.setCountry(country);
		} else
			theCollegeStudent = new CollegeStudent(firstname, lastname, course,country);
		// save the Student
		collegeStudentService.save(theCollegeStudent);

		// use a redirect to prevent duplicate submissions
		return "redirect:/collegeStudents/list";

	}

	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int id) {

		// delete the Student
		collegeStudentService.deleteById(id);

		// redirect to /CollegeStudents/list
		return "redirect:/collegeStudents/list";

	}

	@RequestMapping("/search")
	public String search(@RequestParam("firstname") String firstname, @RequestParam("lastname") String lastname,
			Model theModel) {

		// check names, if both are empty then just give list of all Students

		if (firstname.trim().isEmpty() && lastname.trim().isEmpty()) {
			return "redirect:/collegeStudents/list";
		} else {
			// else, search by first name and last name
			List<CollegeStudent> theCollegeStudent = collegeStudentService.searchBy(firstname, lastname);

			// add to the spring model
			theModel.addAttribute("CollegeStudents", theCollegeStudent);

			// send to list-Books
			return "list-CollegeStudents";
		}

	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}
}
