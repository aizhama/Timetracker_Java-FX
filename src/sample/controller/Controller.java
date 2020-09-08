package sample.controller;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_filed;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private Button authSignInButton;

    @FXML
    void initialize(){
        //trim löscht Leertaste
        loginSignUpButton.setOnAction(event ->{  //signUpUser
            String loginText = login_field.getText().trim();
            String loginPassword = password_filed.getText().trim();

            //wenn login nicht = " " und password nicht = " " -> method
            //wen user hat alles ausgefüllt, dann authorisieren wir ihn, sonst nicht
            if(!loginText.equals("")&& !loginPassword.equals(""))
                loginUser(loginText, loginPassword);
            else
                System.out.println("Login and Password is empty");
            });

        loginSignUpButton.setOnAction(event ->{//getUser
            //System.out.println("Sie haben auf den Button Anmeldung geklickt");
            loginSignUpButton.getScene().getWindow().hide();
            FXMLLoader loader =new FXMLLoader();//wir zuweisen Speicher
            loader.setLocation(getClass().getResource("/sample/signUp.fxml"));// wir zuweisen pfad für File zu finden
            try {
                loader.load();//file loaden
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();//pfad zu den File
            Stage stage= new Stage();//
            stage.setScene(new Scene(root));//stage --> Scene
            stage.setWidth(700);
            stage.setHeight(500);
            stage.show();//Abwarten und zeigen
        });
    }

    private void loginUser(String loginText, String loginPassword) {
    }
}
