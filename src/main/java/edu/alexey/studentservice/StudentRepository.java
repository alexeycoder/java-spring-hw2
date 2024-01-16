package edu.alexey.studentservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.alexey.studentservice.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllByGroupId(String groupId);
}
