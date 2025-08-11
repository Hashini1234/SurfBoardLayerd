package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ItemController {

    @FXML
    private TableColumn<?, ?> colAvailability;

    @FXML
    private TableColumn<?, ?> colCondition;

    @FXML
    private TableColumn<?, ?> colItemId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private Label lblid;

    @FXML
    private TableView<?> tblItems;

    @FXML
    private TextField txtAvailability;

    @FXML
    private TextField txtCondition;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtType;

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
    void tblClickOnAction(MouseEvent event) {

    }

}
