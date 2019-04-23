package model.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.google.inject.Guice;
import com.google.inject.Injector;

import database.DatabaseConnection;
import database.HibernateConfig;
import model.entities.Exam;
import model.entities.Materie;
import model.services.DalModule;

public class ClassRepoImpl implements ClassRepo{

	Injector injector = Guice.createInjector(new DalModule());
    DatabaseConnection database = injector.getInstance(DatabaseConnection.class);
    String query = null;
    Session sessionObj;

    public List<Materie> getClasses(){

    	sessionObj = HibernateConfig.buildSessionFactory().openSession();
    	
    	List<Materie> materii;
		sessionObj.beginTransaction();
		materii =  sessionObj.createCriteria(Materie.class).list();
        sessionObj.getTransaction().commit();
        
        return materii;
    }

}
