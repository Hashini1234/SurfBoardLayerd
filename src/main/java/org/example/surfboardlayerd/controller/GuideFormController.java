package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.custom.GuideBO;
import org.example.surfboardlayerd.BO.custom.impl.BOFactory;

public class GuideFormController {
    private final GuideBO guideBO = (GuideBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GUIDE);
    public TextField txtName;
    public TextField txtContactDetails;
    public TextField txtExperience_Year;
    public TextField txtPayForHour;
    public TableView tblGuide;
    public TableColumn clmGuideid;
    public TableColumn clmName;
    public TableColumn clmContact;
    public TableColumn clmExperience;
    public TableColumn clmPay;

    public void btnGenarateROnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
    }

    public void clickOnAction(MouseEvent mouseEvent) {
    }
}
