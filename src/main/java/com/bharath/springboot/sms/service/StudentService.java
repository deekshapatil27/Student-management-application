package com.bharath.springboot.sms.service;

import java.util.List;

import com.bharath.springboot.sms.entity.Student;

public interface StudentService {
	List<Student> findallstudents();

    Student saveStudent(Student s);
    Student UpdateStudent(Student s);
    void deleteStudent(Long id);
    Student getStudentById(Long id);
}
