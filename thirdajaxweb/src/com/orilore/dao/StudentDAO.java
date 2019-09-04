package com.orilore.dao;

import java.util.List;

import com.orilore.entity.Area;
import com.orilore.entity.Student;

public class StudentDAO implements IStudentDAO {

	@Override
	public void close() {
	}

	@Override
	public boolean insert(Student student) {

		return false;
	}

	@Override
	public boolean delete(int id) {

		return false;
	}

	@Override
	public boolean update(Student student) {

		return false;
	}

	@Override
	public List<Student> select() {

		return null;
	}

	@Override
	public Area selectOne(int id) {

		return null;
	}

}
