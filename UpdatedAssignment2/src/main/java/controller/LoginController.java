package controller;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;

import database.HibernateConfig;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.entities.Exam;
import model.entities.Student;


public class LoginController {

    public Button loginButton;
    public TextField userField;
    public PasswordField passwordField;
    public TextField id;
    public Label resultLabel;

    Session sessionObj; //= HibernateConfig.buildSessionFactory().openSession();
    
    public List<Student> aa() {
    	
    	sessionObj = HibernateConfig.buildSessionFactory().openSession();
//        Profesor prof = new Profesor(15, "amalia", "1534227191472");
//        try {
//			sessionObj.beginTransaction();
//			sessionObj.save(prof);
//			sessionObj.getTransaction().commit();
//			sessionObj.close();
//		}catch(HibernateException exception){
//		     System.out.println("Problem creating session factory");
//		     exception.printStackTrace();
//		  
//		} catch (Exception sqlException) {
//			if (null != sessionObj.getTransaction()) {
//				sessionObj.getTransaction().rollback();
//			}
//			sqlException.printStackTrace();
//			
//		} 
    	
    		List<Exam> students;
    		sessionObj.beginTransaction();
            students =  sessionObj.createCriteria(Exam.class).list();
            sessionObj.getTransaction().commit();
    	   // return allQuery.getResultList();
//    		try {
//    			sessionObj.beginTransaction();
//    			students = sessionObj.createCriteria(Profesor.class).list();
//    			sessionObj.getTransaction().commit();
//    		} catch (Exception e) {
//    			System.out.println("aaaaaaaaaa");
//    		} finally {
//    			sessionObj.close();
//    		}
    		students.forEach(s -> System.out.println(s.toString()));
			return null;
    	
    }

    public void handleLoginClick(ActionEvent event){

    	//aa();
        try {
            Integer.parseInt(id.getText());
        } catch(NumberFormatException e){
            resultLabel.setVisible(true);
            return;
        }

        if (userField.getText().equals("user") && passwordField.getText().equals("pass")) {
            resultLabel.setVisible(false);
            Parent studentViewParent = null;
            FXMLLoader loader = new FXMLLoader();
            try {

                loader.setLocation(getClass().getResource("../view/student.fxml"));
                studentViewParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            StudentController studentController = loader.getController();
            studentController.setId(Integer.parseInt(id.getText()));
            studentController.initialize();
            Scene studentViewScene = new Scene(studentViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(studentViewScene);
            window.show();

        }
        if (userField.getText().equals("admin") && passwordField.getText().equals("pass")) {
            resultLabel.setVisible(false);
            Parent teacherViewParent = null;
            FXMLLoader loader = new FXMLLoader();
            try {
                loader.setLocation(getClass().getResource("../view/teacher.fxml"));
                teacherViewParent = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            TeacherController teacherController = loader.getController();
            teacherController.setId(Integer.parseInt(id.getText()));
            teacherController.initialize();
            Scene teacherViewScene = new Scene(teacherViewParent);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(teacherViewScene);
            window.show();
        }
            resultLabel.setVisible(true);

    }

}
