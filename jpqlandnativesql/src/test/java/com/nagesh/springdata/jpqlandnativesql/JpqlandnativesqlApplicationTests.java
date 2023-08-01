package com.nagesh.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.nagesh.springdata.jpqlandnativesql.entities.Student;
import com.nagesh.springdata.jpqlandnativesql.repos.StudentRepository;


@SpringBootTest
class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;

	@Test
	void testStudentCreate() {

		Student student = new Student();
		student.setFirstName("Sharan");
		student.setLastName("Fhulari");
		student.setScore(85);

		Student student2 = new Student();
		student2.setFirstName("Nagesh");
		student2.setLastName("Jiddimani");
		student2.setScore(80);

		repository.save(student);
		repository.save(student2);
	}

	@Test
	public void testFindAllStudents() {

		System.out.println(repository.findAllStudents());
	}

	@Test
	public void testFindAllStudentsPartial() {

		List<Object[]> partialData = repository.findAllStudentsPartialData();
		for (Object[] objects : partialData) {
			System.out.println(objects[0]);
			System.out.println(objects[1]);

		}
	}

	@Test
	public void testFindAllStudentsByFirstName() {

		System.out.println(repository.findAllStudentsByFirstName("Sharan"));
	}

	@Test
	public void testFindAllStudentsByScores() {

		System.out.println(repository.findStudentsForGivenScores(80, 90));
	}

	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteStudentByFirstName() {
		repository.deleteStudentsByFirstName("Sharan");
	}
	
	@Test
	public void testFindAllStudentNQ() {
		
		System.out.println(repository.findAllStudentNQ());
	}

	@Test
	public void testFindByFistNameNQ() {
		System.out.println(repository.findByFirstNQ("Nagesh"));
	}
}








