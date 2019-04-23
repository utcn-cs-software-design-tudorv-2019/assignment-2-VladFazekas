package model.services;

import com.google.inject.AbstractModule;

import model.repositories.ClassRepo;
import model.repositories.ClassRepoImpl;
import model.repositories.StudentRepo;
import model.repositories.StudentRepoImpl;
import model.repositories.TeacherRepo;
import model.repositories.TeacherRepoImpl;

public class DalModule extends AbstractModule {

	@Override
	protected void configure() {
		 bind(StudentRepo.class).to(StudentRepoImpl.class);
		 bind(TeacherRepo.class).to(TeacherRepoImpl.class);
		 bind(ClassRepo.class).to(ClassRepoImpl.class);
		
	}

}
