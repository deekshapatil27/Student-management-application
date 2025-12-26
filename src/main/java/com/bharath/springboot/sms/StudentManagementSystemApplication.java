package com.bharath.springboot.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bharath.springboot.sms.entity.Student;
import com.bharath.springboot.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository sr;

	@Override
	public void run(String... args) throws Exception {
		sr.save(new Student("minni","patil","mpatil@gmail.com"));


	}

}
