package br.com.alessanderleite.app.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alessanderleite.app.exception.NotFoundException;
import br.com.alessanderleite.app.model.Student;
import br.com.alessanderleite.app.repository.StudentRepository;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/students")
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable Long id) {
		Optional<Student> optionalOptional = studentRepository.findById(id);
		if (optionalOptional.isPresent()) {
			return optionalOptional.get();
		} else {
			throw new NotFoundException("Student not found with id " + id);
		}
	}
	
	@PostMapping("/students")
	public Student createStudent(@Valid @RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@PutMapping("/students/{id}")
	public Student updateStudent(@PathVariable Long id,
							@Valid @RequestBody Student studentUpdated) {
		return studentRepository.findById(id)
				.map(student -> {
					student.setName(studentUpdated.getName());
					student.setAge(studentUpdated.getAge());
					return studentRepository.save(student);
				}).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentRepository.findById(id)
				.map(student -> {
					studentRepository.delete(student);
					return "Delete Successfully!";
				}).orElseThrow(() -> new NotFoundException("Student not found with id " + id));
	}
}
















