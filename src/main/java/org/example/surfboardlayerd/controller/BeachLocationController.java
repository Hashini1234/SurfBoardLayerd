package org.example.surfboardlayerd.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.custom.impl.BOFactory;
import org.example.surfboardlayerd.BO.custom.impl.BeachLocationBoiMPLl;
import org.example.surfboardlayerd.BeachLocationDTO;

import java.sql.SQLException;
import java.util.List;
import javafx.fxml.FXML;
import org.example.surfboardlayerd.BO.custom.BeachLocationBO;

@FXML
public Label lblId;
@FXML
public TableColumn<BeachLocationDTO, String> clmbeach_location;
@FXML
public TableColumn<BeachLocationDTO, String> clmlocation_name;
@FXML
public TableColumn<BeachLocationDTO, String> clmpeak_season;
@FXML
public TableColumn<BeachLocationDTO, String> clmmonth;
@FXML
private ComboBox<String> cbMonth;
@FXML
private ComboBox<String> cbSeason;
@FXML
private TableView<BeachLocationDTO> tblBeach_Location;
@FXML
private TextField txtLocationName;

private final BeachLocationBO beachLocationBO = (BeachLocationBO) BOFactory.getBOFactory()
        .getBO(BOFactory.BOTypes.BEACH_LOCATION);

public void initialize() throws SQLException, ClassNotFoundException {
    setCellValueFactory();
    setNextId();
    loadComboBoxes();
    loadTable();
    clearFields();
}

private void loadTable() throws SQLException, ClassNotFoundException {
    List<BeachLocationDTO> beachLocations = beachLocationBO.getAllBeachLocations();
    ObservableList<BeachLocationDTO> observableList = FXCollections.observableArrayList(beachLocations);
    tblBeach_Location.setItems(observableList);
}

private void setNextId() throws SQLException, ClassNotFoundException {
    String nextId = beachLocationBO.getNextBeachLocationId();
    lblId.setText(nextId);
}

private void setCellValueFactory() {
    clmbeach_location.setCellValueFactory(new PropertyValueFactory<>("beachId"));
    clmlocation_name.setCellValueFactory(new PropertyValueFactory<>("name"));
    clmpeak_season.setCellValueFactory(new PropertyValueFactory<>("peakSeason"));
    clmmonth.setCellValueFactory(new PropertyValueFactory<>("month"));
}

private void loadComboBoxes() {
    cbMonth.setItems(FXCollections.observableArrayList(beachLocationBO.getAllMonths()));
    cbSeason.setItems(FXCollections.observableArrayList(beachLocationBO.getAllSeasons()));
}

private void clearFields() {
    txtLocationName.clear();
    cbSeason.setValue(null);
    cbMonth.setValue(null);
}

@FXML
void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    if (!validateFields()) return;

    BeachLocationDTO dto = createBeachLocationDTO();
    boolean isSaved = beachLocationBO.saveBeachLocation(dto);

    if (isSaved) {
        showAlert(Alert.AlertType.INFORMATION, "Success", "Beach Location Saved Successfully!");
        refreshTable();
        clearFields();
    } else {
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to Save Beach Location!");
    }
}

@FXML
void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    if (!validateFields()) return;

    BeachLocationDTO dto = createBeachLocationDTO();
    boolean isUpdated = beachLocationBO.updateBeachLocation(dto);

    if (isUpdated) {
        showAlert(Alert.AlertType.INFORMATION, "Success", "Beach Location Updated Successfully!");
        refreshTable();
        clearFields();
    } else {
        showAlert(Alert.AlertType.ERROR, "Error", "Failed to Update Beach Location!");
    }
}

@FXML
void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    String id = lblId.getText();
    if (id.isEmpty()) {
        showAlert(Alert.AlertType.WARNING, "Warning", "Please select a beach location to delete!");
        return;
    }

    Alert confirmAlert = new Alert(Alert.AlertType.CONFIRMATION,
            "Are you sure you want to delete this beach location?",
            ButtonType.YES, ButtonType.NO);
    confirmAlert.showAndWait();

    if (confirmAlert.getResult() == ButtonType.YES) {
        boolean isDeleted = beachLocationBO.deleteBeachLocation(id);

        if (isDeleted) {
            showAlert(Alert.AlertType.INFORMATION, "Success", "Beach Location Deleted Successfully!");
            refreshTable();
            clearFields();
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Failed to Delete Beach Location!");
        }
    }
}

@FXML
void btnResetOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
    clearFields();
    setNextId();
}

@FXML
void btnGenerateReportOnAction(ActionEvent event) {
    // Implementation for report generation
    showAlert(Alert.AlertType.INFORMATION, "Info", "Report generation feature coming soon!");
}

public void tblClickOnAction(MouseEvent mouseEvent) {
    BeachLocationDTO selectedItem = tblBeach_Location.getSelectionModel().getSelectedItem();

    if (selectedItem != null) {
        lblId.setText(selectedItem.getBeachId());
        txtLocationName.setText(selectedItem.getName());
        cbSeason.setValue(selectedItem.getPeakSeason());
        cbMonth.setValue(selectedItem.getMonth());
    }
}

