package com.example.springbootToHibernate.controller;


import com.example.springbootToHibernate.entity.Student;
import com.example.springbootToHibernate.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class MainController {

	@Autowired
   StudentService studentService;

	@PostMapping("/add")
	public void insertStudentData(@RequestBody Student student)
	{

		studentService.insertStudentRecord(student);
	}

	@PostMapping("insert")
	public String insertData(@RequestBody Student student)
	{
		return studentService.insertData(student);
	}

	@GetMapping("/get")
	public List getData()
	{
		return studentService.getData();
	}

	@GetMapping("byid/{id}")
	public Student getDataById(@PathVariable int id) {
         return studentService.getDataById(id);
	}

	@PutMapping("update/{id}")
	public Student updateDataById(@PathVariable int id,@RequestBody Student student) {
		return studentService.updateDataById(id,student);
	}

	@DeleteMapping("delete/{id}")
	public Student deleteByID(@PathVariable int id)
	{
		return studentService.deleteById(id);
	}
}

