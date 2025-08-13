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

public class SignUpPageController {

    @FXML
    private Button btnSignUp;

    @FXML
    private ChoiceBox<String> choiceRole;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    private PasswordField txtPassword;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER);

    public void initialize() {
        try {
            txtId.setText(getNextId());
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Can't get id from database, please try again").show();
            throw new RuntimeException(e);
        }
        choiceRole.getItems().addAll("Admin", "User", "Manager");
        choiceRole.setValue("User");
    }

    @FXML
    void goToLogin(ActionEvent event) {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/View/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        Stage newStage = new Stage();
        newStage.setTitle("Login");
        newStage.setScene(scene);
        newStage.show();

        Stage currentStage = (Stage) btnSignUp.getScene().getWindow();
        currentStage.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    }

    @FXML
    void signUpOnAction(ActionEvent event) {

        if (!txtPassword.getText().equals(txtConfirmPassword.getText())) {
            new Alert(Alert.AlertType.ERROR, "Password doesn't match").show();
            return;
        }

        UserDto userDto = new UserDto(txtId.getText(), txtName.getText(), txtEmail.getText(), txtPassword.getText(), choiceRole.getValue().toString());
        try {
            userBO.add(userDto);
            new Alert(Alert.AlertType.INFORMATION, "User Saved").show();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            throw new RuntimeException(e);
        }


    }

    public String getNextId() throws Exception {
        return userBO.generateNewId();
    }

}
