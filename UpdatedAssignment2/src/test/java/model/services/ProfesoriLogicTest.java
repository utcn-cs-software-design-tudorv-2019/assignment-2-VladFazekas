package model.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.entities.Exam;
import model.entities.Profesor;
import model.entities.Student;
import model.repositories.TeacherRepoImpl;

public class ProfesoriLogicTest {

	private ProfesorLogic profesorLogic;

	private TeacherRepoImpl teacherDAL;

	@Before
	public void setUp() {

		teacherDAL = mock(TeacherRepoImpl.class);
		profesorLogic = mock(ProfesorLogic.class);
	}

	@After
	public void tearDown() {
		teacherDAL = null;
		profesorLogic = null;
	}

	@Test
	public void getStudentTableData() {

		when(profesorLogic.getTeacherDal()).thenReturn(teacherDAL);
		List<Student> studenti = new ArrayList<>();
		when(profesorLogic.getStudentTableData()).thenCallRealMethod();
		when(teacherDAL.getStudentTableData()).thenReturn(studenti);

		assertEquals(studenti, profesorLogic.getStudentTableData());

	}
	
	@Test
	public void getTeacherInfoById() {

		when(profesorLogic.getTeacherDal()).thenReturn(teacherDAL);
		Profesor profesor = new Profesor();
		when(profesorLogic.getTeacherInfoById(1)).thenCallRealMethod();
		when(teacherDAL.getTeacherInfoById(1)).thenReturn(profesor);

		assertEquals(profesor, profesorLogic.getTeacherInfoById(1));

	}
	
	@Test
	public void getExamTableData() {

		when(profesorLogic.getTeacherDal()).thenReturn(teacherDAL);
		List<Exam> exam = new ArrayList<>();
		when(profesorLogic.getExamTableData("","","")).thenCallRealMethod();
		when(teacherDAL.getExamTableData("","","")).thenReturn(exam);

		assertEquals(exam, profesorLogic.getExamTableData("","",""));

	}
	
	@Test
	public void gradeExam() {
		
		when(profesorLogic.getTeacherDal()).thenReturn(teacherDAL);
		doCallRealMethod().when(profesorLogic).gradeExam("","","",null);
		doNothing().when(teacherDAL).gradeExam("","","",null);
		
		profesorLogic.gradeExam("","","",null);
		
		verify(teacherDAL,times(1)).gradeExam("","","",null);
		
	}
	
	@Test
	public void deleteStudent() {
		
		when(profesorLogic.getTeacherDal()).thenReturn(teacherDAL);
		doCallRealMethod().when(profesorLogic).deleteStudent(null);
		doNothing().when(teacherDAL).deleteStudent(null);
		
		profesorLogic.deleteStudent(null);
		
		verify(teacherDAL,times(1)).deleteStudent(null);
		
	}
}
