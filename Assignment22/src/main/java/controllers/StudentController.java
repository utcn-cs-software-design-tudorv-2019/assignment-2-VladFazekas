package controllers;


import java.io.IOException;
import java.util.Collections;
import java.util.List;

import business.ClassesLogic;
import business.StudentLogic;
import entity.Materie;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StudentController {

    public Label succesInfoUpdate;
    public Button addStudInfo;
    public Button updateStudInfo;
    public Button deleteStudInfo;
    @FXML
    Button logoutButton;
    @FXML
    Button persInfo;
    @FXML
    Button studentProfile;
    @FXML
    Button classEnrolments;
    @FXML
    TextField userID;

    @FXML
    Pane infopanel;
    @FXML
    TextField userName;
    @FXML
    TextField cnp;
    @FXML
    TextField adress;

    @FXML
    Pane studentInfoPanel;
    @FXML
    TextField icn;
    @FXML
    TextField group;
    @FXML
    TextArea classes;

    @FXML
    Pane classesEnroll;
    @FXML
    ComboBox classesCombo;
    @FXML
    Label succesLable;
    @FXML
    Button classEnroll;

    StudentLogic studentLogic;
    ClassesLogic classesLogic;

    public void initialize(){
        userID.setEditable(false);
        userID.setText("User ID: " + String.valueOf(id));
        infopanel.setVisible(true);
        studentInfoPanel.setVisible(false);
        classes.setEditable(false);
        classesEnroll.setVisible(false);
        succesLable.setVisible(false);
        studentLogic = new StudentLogic();
        classesLogic = new ClassesLogic();
        succesInfoUpdate.setVisible(false);
        Student student = studentLogic.getStudentInfo(id);
        userName.setText(student.getName());
        cnp.setText(student.getCnp());
        adress.setText(student.getAddress());

    }

    private int id;

    public void setId(int id){
        this.id = id;
    }


    public void handleLogoutClick(ActionEvent event) {
        System.out.println("Logout succesfull");
        Parent loginViewParent = null;
        try {
            loginViewParent = FXMLLoader.load(getClass().getResource("../gui/login.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene loginViewScene = new Scene(loginViewParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(loginViewScene);
        window.show();
    }

    public void personalInfoButton(ActionEvent actionEvent) {

        Student student = studentLogic.getStudentInfo(id);

        userName.setText(student.getName());
        cnp.setText(student.getCnp());
        adress.setText(student.getAddress());
        infopanel.setVisible(true);
        studentInfoPanel.setVisible(false);
        classesEnroll.setVisible(false);
    }

    public void studentInfoButton(ActionEvent event) {
        succesInfoUpdate.setVisible(false);
        Student student = studentLogic.getStudentInfo(id);

        icn.setText(student.getIcn());
        group.setText(student.getGrupa());
        classes.clear();
        List<String> classesList = studentLogic.parseList(student.getMaterii());
        classesList.forEach(c-> classes.appendText(c + "\n"));

        infopanel.setVisible(false);
        studentInfoPanel.setVisible(true);
        classesEnroll.setVisible(false);
    }

    public void enrollToClass(ActionEvent event) {

        succesLable.setVisible(false);
        List<Materie> classes2 = classesLogic.getClasses();
        classesCombo.getItems().setAll(Collections.emptyList());
        classes2.forEach(c -> classesCombo.getItems().add(c.getNume()));

        infopanel.setVisible(false);
        studentInfoPanel.setVisible(false);
        classesEnroll.setVisible(true);
    }

    public void enrollToSpecifiedClass(ActionEvent event) {

        try{
            studentLogic.enroll(id,classesCombo.getValue().toString());
            succesLable.setText("Succes!");
            succesLable.setVisible(true);
        } catch(IllegalArgumentException e){
            succesLable.setText("user already enrolled to that class!");
            succesLable.setVisible(true);
        }
    }

    public void updateInfoButton(ActionEvent event) {

        if (!cnp.getText().isEmpty() && !userName.getText().isEmpty() && !adress.getText().isEmpty()) {
            if (String.valueOf(Long.parseLong(cnp.getText())).length() == 13) {
                studentLogic.updateInfo(id, cnp.getText(), userName.getText(), adress.getText());
                succesInfoUpdate.setText("Succes");
                succesInfoUpdate.setVisible(true);
                return;
            }
        }
        else {
            succesInfoUpdate.setText("Incorrect data!");
            succesInfoUpdate.setVisible(true);
        }
    }

    public void addStudInfo(ActionEvent event) {
        if (!icn.getText().isEmpty() && !group.getText().isEmpty()) {
                studentLogic.addStudInfo(id, icn.getText(), group.getText());
        }
    }

    public void updateStudButton(ActionEvent event) {
        if (!icn.getText().isEmpty() && !group.getText().isEmpty()) {
            studentLogic.updateStudInfo(id, icn.getText(), group.getText());
        }
    }

    public void deleteStudButton(ActionEvent event) {
        studentLogic.deleteStudInfo(id);
        succesInfoUpdate.setVisible(false);
        Student student = studentLogic.getStudentInfo(id);

        icn.setText(student.getIcn());
        group.setText(student.getGrupa());
        classes.clear();
        List<String> classesList = studentLogic.parseList(student.getMaterii());
        classesList.forEach(c-> classes.appendText(c + "\n"));

        infopanel.setVisible(false);
        studentInfoPanel.setVisible(true);
        classesEnroll.setVisible(false);
    }
}
