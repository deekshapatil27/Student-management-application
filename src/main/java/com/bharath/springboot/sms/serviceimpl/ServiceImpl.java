package com.bharath.springboot.sms.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bharath.springboot.sms.entity.Student;
import com.bharath.springboot.sms.repository.StudentRepository;
import com.bharath.springboot.sms.service.StudentService;

@Service
public class ServiceImpl implements StudentService {
	private StudentRepository sr;

	public ServiceImpl(StudentRepository sr) {
		super();
		this.sr = sr;
	}

	@Override
	public List<Student> findallstudents() {
		return sr.findAll();
	}

	@Override
	public Student saveStudent(Student s) {
		return sr.save(s);

	}

	public void deleteStudent(Long id) {
		sr.deleteById(id);			
	}

	@Override
	public Student UpdateStudent(Student s) {	
		return sr.save(s);
	}

	@Override
	public Student getStudentById(Long id) {
		return sr.findById(id).get();
	}
}
