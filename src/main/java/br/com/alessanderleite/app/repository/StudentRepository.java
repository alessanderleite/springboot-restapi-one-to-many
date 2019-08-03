package br.com.alessanderleite.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.app.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
