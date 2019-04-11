package business;

import database.ClassDAL;
import database.ClassesQueries;
import database.DatabaseConnection;
import entity.Materie;
import java.util.List;
import java.sql.ResultSet;

public class ClassesLogic {

    ClassDAL classDAL =  new ClassDAL();

    public List<Materie> getClasses(){
        return classDAL.getClasses();
    }
}
