package edu.alexey.studentservice;

import java.util.List;

import edu.alexey.studentservice.entities.Student;

public interface StudentService {

	Student save(Student student);

	List<Student> queryAll();

	Student get(int studentId);

	List<Student> findByGroupId(String groupId);

	List<Student> findByName(String namePattern);

	Student update(Student student);

	void delete(Integer studentId);
}
