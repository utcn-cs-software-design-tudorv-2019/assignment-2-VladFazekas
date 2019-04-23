package business;

import java.util.List;

import database.TeacherDAL;
import entity.Exam;
import entity.Profesor;
import entity.Student;

public class TeacherLogic {

    TeacherDAL teacherDAL = new TeacherDAL();

    public List<Student> getStudentTableData() {
        return teacherDAL.getStudentTableData();
    }

    public Profesor getTeacherInfoById(int id) {
        return teacherDAL.getTeacherInfoById(id == 0 ? 1 : id);
    }


    public List<Exam> getExamTableData(String numestudent, String data1, String data2) {
        return teacherDAL.getExamTableData(numestudent, data1, data2);
    }

    public void gradeExam(String name, String numematerie, String nota, String data) {
        teacherDAL.gradeExam(name, numematerie, nota, data);
    }
}
