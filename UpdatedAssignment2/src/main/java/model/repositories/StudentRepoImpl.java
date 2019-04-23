package model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import com.google.inject.Guice;
import com.google.inject.Injector;

import database.DatabaseConnection;
import database.HibernateConfig;
import model.entities.Profesor;
import model.entities.Student;
import model.services.DalModule;

public class StudentRepoImpl implements StudentRepo {

	Injector injector = Guice.createInjector(new DalModule());
	DatabaseConnection database = injector.getInstance(DatabaseConnection.class);
	String query = null;

	public Student getStudentInfo(int id) {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();

		Student student;
		sessionObj.beginTransaction();
		student = (Student) sessionObj.get(Student.class, id);
		sessionObj.getTransaction().commit();

		return student;
	}

	public void enroll(int id, String classs) throws IllegalArgumentException {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = getStudentInfo(id);

		List<String> classesList = this.parseList(student.getMaterii());
		if (classesList.contains(classs)) {
			throw new IllegalArgumentException();
		} else {
			student.setMaterii(student.getMaterii() + "," + classs);
			sessionObj.beginTransaction();
			sessionObj.update(student);
			sessionObj.getTransaction().commit();
		}

	}

	public List<String> parseList(String classes) {
		return Arrays.asList(classes.split(","));
	}

	public void updateInfo(int id, String cnp, String name, String adress) {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();

		Student student = this.getStudentInfo(id);
		student.setCnp(cnp);
		student.setName(name);
		student.setAddress(adress);
		sessionObj.beginTransaction();
		sessionObj.update(student);
		sessionObj.getTransaction().commit();

	}

	public void addStudInfo(int id, String icn, String group) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = this.getStudentInfo(id);
		
		student.setIcn(Integer.parseInt(icn));
		student.setGrupa(Integer.parseInt(group));
		
		sessionObj.beginTransaction();
		sessionObj.update(student);
		sessionObj.getTransaction().commit();
	}

	public void deleteStudInfo(int id) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = this.getStudentInfo(id);
		
		student.setIcn(-1);
		student.setGrupa(-1);
		student.setMaterii("");
		
		sessionObj.beginTransaction();
		sessionObj.update(student);
		sessionObj.getTransaction().commit();
	}

	public void updateStudInfo(int id, String icn, String group) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = this.getStudentInfo(id);
		
		student.setIcn(Integer.parseInt(icn));
		student.setGrupa(Integer.parseInt(group));
		
		sessionObj.beginTransaction();
		sessionObj.update(student);
		sessionObj.getTransaction().commit();
	}

	@Override
	public void deleteStudent(int id) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = this.getStudentInfo(id);
		
		sessionObj.beginTransaction();
		sessionObj.delete(student);
		sessionObj.getTransaction().commit();
		
	}

	@Override
	public void addStudent(String username, String cnp, String adress) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		Student student = new Student(username, cnp, adress);
		
		sessionObj.beginTransaction();
		sessionObj.save(student);
		sessionObj.getTransaction().commit();
	}
}
