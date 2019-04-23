package model.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.entities.Student;
import model.repositories.StudentRepoImpl;

public class StudentLogicTest {

	private StudentLogic stLogic;
	
	private StudentRepoImpl studentDAL;
	
	@Before
	public void setUp() {
		
		studentDAL = mock(StudentRepoImpl.class);
		stLogic = mock(StudentLogic.class);
	}
	
	@After
	public void tearDown() {
		studentDAL = null;
		stLogic = null;
	}
	
	@Test
	public void getStudentInfo() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		Student student = new Student();
		when(stLogic.getStudentInfo(1)).thenCallRealMethod();
		when(studentDAL.getStudentInfo(1)).thenReturn(student);
		
		assertEquals(student,stLogic.getStudentInfo(1));
		
	}
	
	@Test
	public void enroll() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).enroll(1,"");
		doNothing().when(studentDAL).enroll(1,"");
		
		stLogic.enroll(1,"");
		
		verify(studentDAL,times(1)).enroll(1,"");
		
	}
	
	@Test
	public void deleteStudent() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).deleteStudent(1);
		doNothing().when(studentDAL).deleteStudent(1);
		
		stLogic.deleteStudent(1);
		
		verify(studentDAL,times(1)).deleteStudent(1);
		
	}
	
	@Test
	public void updateInfo() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).updateInfo(1,"","","");
		doNothing().when(studentDAL).updateInfo(1,"","","");
		
		stLogic.updateInfo(1,"","","");
		
		verify(studentDAL,times(1)).updateInfo(1,"","","");
		
	}
	
	@Test
	public void addStudInfo() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).addStudInfo(1,"","");
		doNothing().when(studentDAL).addStudInfo(1,"","");
		
		stLogic.addStudInfo(1,"","");
		
		verify(studentDAL,times(1)).addStudInfo(1,"","");
		
	}
	
	@Test
	public void deleteStudInfo() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).deleteStudInfo(1);
		doNothing().when(studentDAL).deleteStudInfo(1);
		
		stLogic.deleteStudInfo(1);
		
		verify(studentDAL,times(1)).deleteStudInfo(1);
		
	}
	
	@Test
	public void updateStudInfo() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).updateStudInfo(1,"","");
		doNothing().when(studentDAL).updateStudInfo(1,"","");
		
		stLogic.updateStudInfo(1,"","");
		
		verify(studentDAL,times(1)).updateStudInfo(1,"","");
		
	}
	
	@Test
	public void addStudent() {
		
		when(stLogic.getStudentDal()).thenReturn(studentDAL);
		doCallRealMethod().when(stLogic).addStudent("","","");
		doNothing().when(studentDAL).addStudent("","","");
		
		stLogic.addStudent("","","");
		
		verify(studentDAL,times(1)).addStudent("","","");
		
	}
}
