package model.services;

import java.time.LocalDate;
import java.util.List;

import com.google.inject.Inject;

import model.entities.Exam;
import model.entities.Profesor;
import model.entities.Student;
import model.repositories.ClassRepo;
import model.repositories.TeacherRepo;

public class ProfesorLogic {

	@Inject
    TeacherRepo teacherDAL;

    public List<Student> getStudentTableData() {
        return getTeacherDal().getStudentTableData();
    }

    public Profesor getTeacherInfoById(int id) {
        return getTeacherDal().getTeacherInfoById(id == 0 ? 1 : id);
    }


    public List<Exam> getExamTableData(String numestudent, String data1, String data2) {
        return getTeacherDal().getExamTableData(numestudent, data1, data2);
    }

    public void gradeExam(String name, String numematerie, String nota, LocalDate data) {
    	getTeacherDal().gradeExam(name, numematerie, nota, data);
    }

	public void deleteStudent(Student student) {
		
		getTeacherDal().deleteStudent(student);
	}
	
	public TeacherRepo getTeacherDal() {
		return teacherDAL;
	}
}
