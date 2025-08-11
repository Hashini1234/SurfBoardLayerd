package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.BeachLocationBO;
import org.example.surfboardlayerd.model.BeachLocationDto;
import java.sql.SQLException;
import static sun.net.www.MimeTable.loadTable;

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

    private  final BeachLocationBO beachLocationBO =(BeachLocationBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BeachLocation);

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (beachLocationBO.delete(lblId.getText())) {
            loadTable();
            lblId.setText(beachLocationBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
        }
    }

    @FXML
    void btnGenarateROnAction(ActionEvent event) {

    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        BeachLocationDto dto = new BeachLocationDto(
                lblId.getText(),
                txtLocationName.getText(),
                cbSeason.getValue(),
                cbMonth.getValue()
        );
        if (beachLocationBO.save(dto)) {
            loadTable();
            lblId.setText(beachLocationBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
        }


    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        BeachLocationDto dto = new BeachLocationDto(
                lblId.getText(),
                txtLocationName.getText(),
                cbSeason.getValue(),
                cbMonth.getValue()
        );
        if (beachLocationBO.update(dto)) {
            loadTable();
            lblId.setText(beachLocationBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Updated!").show();
        }

    }

    @FXML
    void tblClickOnAction(MouseEvent event) {
        BeachLocationDto selected = (BeachLocationDto) tblBeach_Location.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblId.setText(selected.getBeachId());
            txtLocationName.setText(selected.getName());
            cbSeason.setValue(selected.getPeakSeason());
            cbMonth.setValue(selected.getMonth());
        }
    }

    }


