package br.com.alessanderleite.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alessanderleite.app.model.Assignment;

public interface AssignmentRepository extends JpaRepository<Assignment, Long>{
	List<Assignment> findByStudentId(Long studentId);
}
