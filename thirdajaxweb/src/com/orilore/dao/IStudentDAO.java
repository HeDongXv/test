package com.orilore.dao;

import java.util.List;

import com.orilore.entity.Area;
import com.orilore.entity.Student;

public interface IStudentDAO {
	public void close();
	public boolean insert(Student student);
	public boolean delete(int id);
	public boolean update(Student student);
	public List<Student> select();
	public Area selectOne(int id);
}
