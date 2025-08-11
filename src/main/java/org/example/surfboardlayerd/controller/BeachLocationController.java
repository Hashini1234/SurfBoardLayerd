package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BeachLocationController {

    @FXML
    private ComboBox<?> cbMonth;

    @FXML
    private ComboBox<?> cbSeason;

    @FXML
    private TableColumn<?, ?> clmbeach_location;

    @FXML
    private TableColumn<?, ?> clmlocation_name;

    @FXML
    private TableColumn<?, ?> clmmonth;

    @FXML
    private TableColumn<?, ?> clmpeak_season;

    @FXML
    private Label lblId;

    @FXML
    private TableView<?> tblBeach_Location;

    @FXML
    private TextField txtLocationName;

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnGenarateROnAction(ActionEvent event) {

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
    void tblClickOnAction(MouseEvent event) {

    }

}
