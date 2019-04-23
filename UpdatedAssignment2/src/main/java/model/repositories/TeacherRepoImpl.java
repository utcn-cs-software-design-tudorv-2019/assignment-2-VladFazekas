package model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;

import com.google.inject.Guice;
import com.google.inject.Injector;

import database.DatabaseConnection;
import database.HibernateConfig;
import database.TeacherQueries;
import model.entities.Exam;
import model.entities.Profesor;
import model.entities.Student;
import model.services.DalModule;

public class TeacherRepoImpl implements TeacherRepo {

	Injector injector = Guice.createInjector(new DalModule());
	DatabaseConnection database = injector.getInstance(DatabaseConnection.class);
	TeacherQueries teacherQueries = injector.getInstance(TeacherQueries.class);
	String query = null;

	public List<Student> getStudentTableData() {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();

		List<Student> studenti;
		sessionObj.beginTransaction();
		studenti = sessionObj.createCriteria(Student.class).list();
		sessionObj.getTransaction().commit();

		return studenti;

	}

	public Profesor getTeacherInfoById(int id) {

		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();

		Profesor profesor;
		sessionObj.beginTransaction();
		profesor = (Profesor) sessionObj.get(Profesor.class, id);
		sessionObj.getTransaction().commit();

		return profesor;

	}

	public List<Exam> getExamTableData(String numestudent, String data1, String data2) {
		
		 query = teacherQueries.getExamTableData(numestudent,data1,data2);
	        ResultSet result = database.getResultByStatement(query);
	        List<Exam>  examList = new ArrayList<>();
	        String string = "yyyy-MM-dd";
			DateFormat format = new SimpleDateFormat(string);
	        try {
	            while(result.next()) {
	                examList.add(new Exam(result.getObject(2).toString(),
	                        result.getObject(3).toString(),
	                        Integer.parseInt(result.getObject(4).toString()),
	                        ((Date) result.getObject(5))));
	            }
	            return examList;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return null;
	        }
	        

//			Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
//
//			List<Exam> examene;
//			sessionObj.beginTransaction();
//			examene = sessionObj.createQuery("from Exam").list(); 
//			sessionObj.getTransaction().commit();
//			
//			String string = "yyyy-MM-dd";
//			DateFormat format = new SimpleDateFormat(string);
//			List<Exam> exameneBune = new ArrayList<>();
//			try {
//				Date dateFrom = format.parse(data1);
//				Date dateTo = format.parse(data2);
//				examene.forEach(e -> {
//					System.out.println(e.toString());
//					if (e.getNumestudent().equals(numestudent)
//							&& dateFrom.compareTo(e.getDataexamen()) * e.getDataexamen().compareTo(dateTo) >= 0) {
//						exameneBune.add(e);
//					}
//				});
//			} catch (ParseException e1) {
//				e1.printStackTrace();
//			}
	//
//			return exameneBune;
	}
	
	public void deleteStudent(Student student) {
		
		Session sessionObj = HibernateConfig.buildSessionFactory().openSession();
		
		sessionObj.beginTransaction();
		sessionObj.delete(student);
		sessionObj.getTransaction().commit();
	}

	public void gradeExam(String name, String numematerie, String nota, LocalDate data) {

		DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String text = data.format(formatters);
		LocalDate parsedDate = LocalDate.parse(text, formatters);
		Date datet = (Date) Date.from(parsedDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Exam exam = new Exam(numematerie, name, Integer.parseInt(nota), datet);
		
		Session session = HibernateConfig.buildSessionFactory().openSession();
		session.beginTransaction();
		session.save(exam);
		session.getTransaction().commit();

	}

}
