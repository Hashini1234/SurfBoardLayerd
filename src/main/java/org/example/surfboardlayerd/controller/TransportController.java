package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class TransportController {

    @FXML
    private ComboBox<?> cmbTourist;

    @FXML
    private ComboBox<?> cmbVehicle;

    @FXML
    private TableColumn<?, ?> colCost;

    @FXML
    private TableColumn<?, ?> colLocation;

    @FXML
    private TableColumn<?, ?> colTouristId;

    @FXML
    private TableColumn<?, ?> colTransportId;

    @FXML
    private TableColumn<?, ?> colVehicleType;

    @FXML
    private TableView<?> tblTransport;

    @FXML
    private TextField txtCost;

    @FXML
    private TextField txtLocation;

    @FXML
    private TextField txtTransportId;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void clickOnAction(MouseEvent event) {

    }

}
