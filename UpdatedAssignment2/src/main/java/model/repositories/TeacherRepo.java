package model.repositories;

import java.time.LocalDate;
import java.util.List;

import model.entities.Exam;
import model.entities.Profesor;
import model.entities.Student;

public interface TeacherRepo {

	public List<Student> getStudentTableData();

	public Profesor getTeacherInfoById(int id);

	public List<Exam> getExamTableData(String numestudent, String data1, String data2);

	public void gradeExam(String name, String numematerie, String nota, LocalDate data);

	public void deleteStudent(Student student);
}
