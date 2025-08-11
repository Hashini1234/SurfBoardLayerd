package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SessionController {

    @FXML
    private Button btnCheckBalance;

    @FXML
    private ComboBox<?> cmbBeachId;

    @FXML
    private ComboBox<?> cmbGuideId;

    @FXML
    private ComboBox<?> cmbMethod;

    @FXML
    private ComboBox<?> cmbStatus;

    @FXML
    private ComboBox<?> cmbSurfBoardId;

    @FXML
    private ComboBox<?> cmbTouristId;

    @FXML
    private TableColumn<?, ?> colBeachId;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableColumn<?, ?> colDuration;

    @FXML
    private TableColumn<?, ?> colGuideId;

    @FXML
    private TableColumn<?, ?> colSessionId;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTime;

    @FXML
    private TableColumn<?, ?> colTouristId;

    @FXML
    private DatePicker dateSession;

    @FXML
    private Label lblChange;

    @FXML
    private Label lblPaymentId;

    @FXML
    private Label lblSessionId;

    @FXML
    private Label lblTotalAmount;

    @FXML
    private TableView<?> tblSessions;

    @FXML
    private TextField txtDuration;

    @FXML
    private TextField txtPaidAmount;

    @FXML
    private TextField txtTime;

    @FXML
    void btnCheckBalanceOnAction(ActionEvent event) {

    }

    @FXML
    void btnPlaceSession(ActionEvent event) {

    }

    @FXML
    void clickOnAction(MouseEvent event) {

    }

}
