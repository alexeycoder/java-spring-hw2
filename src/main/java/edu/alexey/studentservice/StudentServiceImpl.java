package edu.alexey.studentservice;

import java.util.List;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.stereotype.Service;

import edu.alexey.studentservice.entities.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public List<Student> queryAll() {
		return StreamSupport.stream(studentRepository.findAll().spliterator(), false).toList();
	}

	@Override
	public Student get(int studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public List<Student> findByGroupId(String groupId) {
		return studentRepository.findAllByGroupId(groupId);
	}

	@Override
	public List<Student> findByName(String namePattern) {
		var matcher = ExampleMatcher.matchingAll()
				.withMatcher("name", GenericPropertyMatchers.contains().ignoreCase())
				.withIgnorePaths("groupId");
		return studentRepository.findAll(Example.of(new Student(null, namePattern, null), matcher));
	}

	@Override
	public Student update(Student student) {

		if (student.getName() == null) {
			throw new IllegalArgumentException();
		}

		Student entry = studentRepository.findById(student.getStudentId()).get();

		entry.setName(student.getName());
		entry.setGroupId(student.getGroupId());

		return studentRepository.save(entry);
	}

	@Override
	public void delete(Integer studentId) {
		studentRepository.deleteById(studentId);
	}

}
