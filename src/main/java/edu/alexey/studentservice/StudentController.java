package edu.alexey.studentservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.alexey.studentservice.entities.Student;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = { "/student", "/students" })
	public List<Student> getAllStudents() {
		log.info("Получить всех");

		return studentService.queryAll();
	}

	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer studentId) {
		log.info("Поиск по ключу: '{}'", studentId);

		Student student = studentService.get(studentId);
		if (student == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(student);
	}

	@GetMapping("/group/{groupId}/student")
	public List<Student> findStudentsByGroupId(@PathVariable("groupId") String groupId) {
		log.info("Поиск по группе: '{}'", groupId);

		return studentService.findByGroupId(groupId);
	}

	@GetMapping("/student/search")
	public List<Student> findStudentsByName(@RequestParam(name = "name", required = true) String namePattern) {
		log.info("Поиск по имени: '{}'", namePattern);

		return studentService.findByName(namePattern);
	}

	@DeleteMapping("/student/{id}")
	public ResponseEntity<Student> deleteStudentById(@PathVariable("id") Integer studentId) {
		log.info("Удаление по ключу: '{}'", studentId);

		var responseEntity = getStudentById(studentId);
		if (responseEntity.hasBody()) {
			studentService.delete(studentId);
		}
		return responseEntity;
	}

	@PostMapping("/student")
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		log.info("Добавление нового: '{}'", student);

		if (student == null || student.getName() == null || student.getName().isBlank()) {
			return ResponseEntity.badRequest().build();
		}
		student.setStudentId(null);
		var entry = studentService.save(student);
		return ResponseEntity.ok(entry);
	}

}
