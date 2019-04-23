package model.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.entities.Materie;
import model.repositories.ClassRepoImpl;

public class MateriiLogicTest {

	private MateriiLogic materiiLogic;
	
	private ClassRepoImpl materiiDAL;
	
	@Before
	public void setUp() {
		
		materiiDAL = mock(ClassRepoImpl.class);
		materiiLogic = mock(MateriiLogic.class);
	}
	
	@After
	public void tearDown() {
		materiiDAL = null;
		materiiLogic = null;
	}
	
	@Test
	public void getStudentInfo() {
		
		when(materiiLogic.getClassDal()).thenReturn(materiiDAL);
		List<Materie> materii = new ArrayList<>();
		when(materiiLogic.getClasses()).thenCallRealMethod();
		when(materiiDAL.getClasses()).thenReturn(materii);
		
		assertEquals(materii,materiiLogic.getClasses());
		
	}

}
