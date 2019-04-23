package model.repositories;
import java.util.List;

import model.entities.Student;

public interface StudentRepo {

	public Student getStudentInfo(int id);

	public void enroll(int id, String classs);

	public List<String> parseList(String classes);

	public void deleteStudent(int id);
	
	public void updateInfo(int id, String cnp, String name, String adress);

	public void addStudInfo(int id, String text, String text1);

	public void deleteStudInfo(int id);

	public void updateStudInfo(int id, String text, String text1);

	public void addStudent(String username, String cnp, String adress);

}
