package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (StudentDAO studentDAO){
		return runner -> {
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLatName(studentDAO);

			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id : primary key

		int studentID =1;
		System.out.println("Getting student id : " + studentID);
		Student myStudent = studentDAO.findById(studentID);

		// change first name to Scooby
		System.out.println("Updating student id");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		//display the student
		System.out.println("Updated student : " + myStudent);
	}

	private void queryForStudentsByLatName(StudentDAO studentDAO) {
		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Duck");

		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of student
		List<Student> theStudents = studentDAO.findAll();

		// display the list of students
		for (Student tempStudent : theStudents ){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create a student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Daffy","Duck","daffy@luv2code.com");

		// save the student

		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of the saved student

		int theID = tempStudent.getId();
		System.out.println("The Id is  : " + theID);

		//retieve student based on the id : primary key

		System.out.println("Retrieving student with id : " + theID);
		Student myStudent = studentDAO.findById(theID);

		// display student
		System.out.println("Found the student : " + myStudent);


	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		//create multiple students
		System.out.println("Creating 3 student objects ...");
		Student tempStudent1 =new Student ("John","Doe","john@luv2code.com");
		Student tempStudent2 =new Student ("Mary","Public","mary@luv2code.com");
		Student tempStudent3 =new Student ("Bonita","Applebum","bonita@luv2code.com");



		//save the student objects
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO) {

		// craete the student object
		System.out.println("Creating new student object ...");
		Student tempStudent =new Student ("Paul","Doe","paul@luv2code.com");

		//save the student object
		System.out.println("Saving the new student ...");
		studentDAO.save(tempStudent);


		//display id of the saved student
		System.out.println("Saved student. Generated id : " +tempStudent.getId());
	}
}
