package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import sample.DatabaseHandler;
import sample.User;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignUpController{

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_filed;

    @FXML
    private Button authSignInButton;

    @FXML
    private PasswordField password_filed1;

    @FXML
    private TextField email_field;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(event -> {
            System.out.println("Test");
            signUpNewUser();
        });
    }
    private void signUpNewUser(){
        DatabaseHandler dbHandler = new DatabaseHandler();
            String username = login_field.getText();
            String email = email_field.getText();
            String password= password_filed.getText();
            String password_reset = password_filed1.getText();
            User user = new User(username, email, password, password_reset);
            dbHandler.signUpUser(user);//signUpUser
    }
    private void userLogin(String login_field, String password_filed) throws SQLException {
        DatabaseHandler dbHandler = new DatabaseHandler();
        User user = new User();
        user.setUsername(login_field);
        user.setPassword(password_filed);
        ResultSet resultSet = dbHandler.getUser(user);//signUpUser
        int count = 0;

        while (resultSet.next()){
            count++;
        }
        if(count >= 1){
            System.out.println("Success!");
        }
    }
}