package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.UserBO;
import org.example.surfboardlayerd.HelloApplication;
import org.example.surfboardlayerd.model.UserDto;

import java.io.IOException;

public class LoggingPageController {

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    @FXML
    void loginOnAction(ActionEvent event) {
        String username = txtUsername.getText();
        String password = txtPassword.getText();

        try {
            boolean existingUser = userBO.checkUser(username);
            if (existingUser) {
                UserDto user = userBO.getUser(username);
                if (user.getPassword().equals(password)) {
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/DashBoard.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage newStage = new Stage();
                    newStage.setTitle("Main");
                    newStage.setScene(scene);
                    newStage.show();

                    Stage currentStage = (Stage) btnLogin.getScene().getWindow();
                    currentStage.close();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Invalid password").show();
                }
            } else {
                new Alert(Alert.AlertType.ERROR, "Invalid Username").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void signUpOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/signup.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage newStage = new Stage();
            newStage.setTitle("Sign Up");
            newStage.setScene(scene);
            newStage.show();
            Stage currentStage = (Stage) btnLogin.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            throw new RuntimeException(e);
        }

    }

}
