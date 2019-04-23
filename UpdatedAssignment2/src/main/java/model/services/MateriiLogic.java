package model.services;

import java.util.List;

import com.google.inject.Inject;

import model.entities.Materie;
import model.repositories.ClassRepo;
import model.repositories.StudentRepo;

public class MateriiLogic {

	@Inject
    ClassRepo classDAL;

    public List<Materie> getClasses(){
        return getClassDal().getClasses();
    }
    
    public ClassRepo getClassDal() {
		return classDAL;
	}
}
