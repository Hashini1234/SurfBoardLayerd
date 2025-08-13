package org.example.surfboardlayerd.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.ItemBO;
import org.example.surfboardlayerd.model.ItemDto;
import org.example.surfboardlayerd.view.tdm.ItemTM;

import java.sql.SQLException;
import java.util.ArrayList;


public class ItemController {
    private final ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Item);
    @FXML
    private TableView<ItemTM> tblItems;
    @FXML
    private TableColumn<ItemDto, String> colItemId;
    @FXML
    private TableColumn<ItemDto, String> colName;
    @FXML
    private TableColumn<ItemDto, String> colType;
    @FXML
    private TableColumn<ItemDto, String> colCondition;
    @FXML
    private TableColumn<ItemDto, String> colAvailability;
    @FXML
    private Label lblid;
    @FXML
    private TextField txtAvailability;

    @FXML
    private TextField txtCondition;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtType;

    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        loadTable();
        lblid.setText(itemBO.getNextId());
    }

    private void setCellValueFactory() {
        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colCondition.setCellValueFactory(new PropertyValueFactory<>("conditions"));
        colAvailability.setCellValueFactory(new PropertyValueFactory<>("availabilityStatus"));


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Are you sure you want to delete this item?");
        alert.setContentText("This action cannot be undone.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                try {
                    boolean deleted = itemBO.delete(lblid.getText());
                    if (deleted) {
                        loadTable();
                        lblid.setText(itemBO.getNextId());
                        new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
                        clearFields();
                    }else {
                        new Alert(Alert.AlertType.ERROR, "Can't find item, please try again").show();
                    }
                } catch (SQLException | ClassNotFoundException e) {
                    new Alert(Alert.AlertType.ERROR, "Something went wrong!").show();
                    throw new RuntimeException(e);
                }
            } else if (response == ButtonType.CANCEL) {
                alert.close();
                clearFields();
            }
        });
    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("This function can’t be used now. Try again later.");
        alert.showAndWait();
    }

    @FXML
    void btnResetOnAction(ActionEvent event) {
        clearFields();
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(lblid.getText(), txtName.getText(), txtType.getText(), txtCondition.getText(), txtAvailability.getText());

        try {
            if (checkFields()) {
                boolean saved = itemBO.save(dto);
                if (saved) {
                    loadTable();
                    lblid.setText(itemBO.getNextId());
                    new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
                    clearFields();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            throw new RuntimeException(e);

        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(lblid.getText(), txtName.getText(), txtType.getText(), txtCondition.getText(), txtAvailability.getText());
        try {
            if (checkFields()) {
                boolean updated = itemBO.update(dto);
                if (updated) {
                    loadTable();
                    lblid.setText(itemBO.getNextId());
                    new Alert(Alert.AlertType.INFORMATION, "Updated!").show();
                    clearFields();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            throw new RuntimeException(e);
        }
    }

    @FXML
    void tblClickOnAction(MouseEvent event) {
        ItemTM selected = (ItemTM) tblItems.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblid.setText(selected.getItemId());
            txtName.setText(selected.getName());
            txtType.setText(selected.getType());
            txtCondition.setText(selected.getConditions());
            txtAvailability.setText(selected.getAvailabilityStatus());
        }
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<ItemDto> all = itemBO.getAll();
        ObservableList<ItemTM> observableList = FXCollections.observableArrayList();

        for (ItemDto dto : all) {
            observableList.add(new ItemTM(dto.getItemId(), dto.getName(), dto.getType(), dto.getConditions(), dto.getAvailabilityStatus()));
        }

        tblItems.setItems(observableList);
    }

    public void clearFields() {
        try {
            lblid.setText(itemBO.getNextId());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            throw new RuntimeException(e);
        }

        txtName.setText("");
        txtType.setText("");
        txtCondition.setText("");
        txtAvailability.setText("");
    }

    public boolean checkFields() {
        if (txtName.getText().isEmpty() || txtName.getText().trim().isEmpty()) {
            showFieldAlert("Name", "Please enter the item name.");
            txtName.requestFocus();
            return false;
        }

        if (txtType.getText().isEmpty() || txtType.getText().trim().isEmpty()) {
            showFieldAlert("Type", "Please enter the item type.");
            txtType.requestFocus();
            return false;
        }

        if (txtCondition.getText().isEmpty() || txtCondition.getText().trim().isEmpty()) {
            showFieldAlert("Condition", "Please enter the item condition.");
            txtCondition.requestFocus();
            return false;
        }

        if (txtAvailability.getText().isEmpty() || txtAvailability.getText().trim().isEmpty()) {
            showFieldAlert("Availability", "Please enter the availability status.");
            txtAvailability.requestFocus();
            return false;
        }

        return true;
    }



    private void showFieldAlert(String fieldName, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Field Validation Error");
        alert.setHeaderText(fieldName + " field is required");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
