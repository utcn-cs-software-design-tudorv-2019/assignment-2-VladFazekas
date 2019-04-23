package model.services;

import database.DatabaseConnection;
import model.entities.Student;
import model.repositories.StudentRepo;
import model.repositories.StudentRepoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import com.google.inject.Inject;

public class StudentLogic {

	@Inject
    StudentRepo studentDAL;

    public Student getStudentInfo(int id){
        return getStudentDal().getStudentInfo(id == 0 ? 1 : id);
    }

    public void enroll(int id, String classs) throws IllegalArgumentException{
    	getStudentDal().enroll(id, classs);
    }

    public void deleteStudent(int id) {
    	getStudentDal().deleteStudent(id);
    }
    
    public void updateInfo(int id, String cnp, String name, String adress) {
    	getStudentDal().updateInfo(id, cnp, name, adress);
    }

    public void addStudInfo(int id, String text, String text1) {
    	getStudentDal().addStudInfo(id, text, text1);
    }

    public void deleteStudInfo(int id) {
    	getStudentDal().deleteStudInfo(id);
    }

    public void updateStudInfo(int id, String text, String text1) {
    	getStudentDal().updateStudInfo(id, text, text1);
    }

    public List<String> parseList(String classes){
        return Arrays.asList(classes.split(","));
    }

	public void addStudent(String username, String cnp, String adress) {
		getStudentDal().addStudent(username, cnp, adress);
	}
	
	public StudentRepo getStudentDal() {
		return studentDAL;
	}

}
