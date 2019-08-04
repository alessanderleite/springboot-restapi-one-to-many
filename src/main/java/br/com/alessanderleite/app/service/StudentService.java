package br.com.alessanderleite.app.service;

import java.util.List;
import java.util.Optional;

import br.com.alessanderleite.app.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	Optional<Student> getStudentsById(Long id);
	void createStudent(Student student);
	void updateStudent(Long id);
	void deleteStudent(Long id);
	
}
