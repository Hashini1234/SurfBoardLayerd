package org.example.surfboardlayerd.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.ItemBO;
import org.example.surfboardlayerd.model.ItemDto;

import java.sql.SQLException;




public class ItemController {
private  final ItemBO itemBO = (ItemBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.Item);
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
    void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        if (itemBO.delete(lblid.getText())) {
            loadTable();
            lblid.setText(itemBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Deleted!").show();
        }
    }

    @FXML
    void btnGenerateOnAction(ActionEvent event) {


    }

    @FXML
    void btnResetOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(
                lblid.getText(),
                txtName.getText(),
                Integer.parseInt(txtAvailability.getText()),
                Double.parseDouble(txtCondition.getText())
        );
        if (ItemBO.save(dto)) {
            loadTable();
            lblid.setText(ItemBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        ItemDto dto = new ItemDto(
                lblid.getText(),
                txtName.getText(),
                Integer.parseInt(txtAvailability.getText()),
                Double.parseDouble(txtCondition.getText())
        );
        if (ItemBO.update(dto)) {
            loadTable();
            lblid.setText(ItemBO.getNextId());
            new Alert(Alert.AlertType.INFORMATION, "Updated!").show();
        }

    }

    @FXML
    void tblClickOnAction(MouseEvent event) {
        ItemDto selected = tblItems.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblid.setText(selected.getItemId());
            txtName.setText(selected.getName());
            txtAvailability.setText(String.valueOf(selected.getQtyOnHand()));
            txtAvailability.setText(String.valueOf(selected.getUnitPrice()));
        }
    }

}
