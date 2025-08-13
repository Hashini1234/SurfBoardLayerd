package org.example.surfboardlayerd.controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.SupplierBO;
import org.example.surfboardlayerd.model.ItemDto;
import org.example.surfboardlayerd.model.SupplierDto;
import org.example.surfboardlayerd.view.tdm.SupplierTM;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierController {
    private final SupplierBO supplierBO = (SupplierBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SUPPLIER);

    @FXML
    private TableColumn<?, ?> colContactInfo;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colSupplierId;

    @FXML
    private Label lblid;

    @FXML
    private TableView<SupplierTM> tblSuppliers;

    @FXML
    private TextField txtContactInfo;

    @FXML
    private TextField txtSupplierName;

    @FXML


    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        setNextId();
        loadTable();
    }


  public void btnDeleteOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Confirmation Dialog");
      alert.setHeaderText("Are you sure you want to delete this item?");
      alert.setContentText("This action cannot be undone.");

      alert.showAndWait().ifPresent(response -> {
          if (response == ButtonType.OK) {
              try {
                  boolean deleted = supplierBO.deleteSupplier(lblid.getText());
                  if (deleted) {
                      loadTable();
                      lblid.setText(supplierBO.getNextId());
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

    private void clearFields() {
        try {
            lblid.setText(supplierBO.getNextId());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            throw new RuntimeException(e);
        }

        colSupplierId.setText("");
        colName.setText("");
        txtContactInfo.setText("");
        txtSupplierName.setText("");
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

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isSaved = supplierBO.saveSupplier(
                new SupplierDto(lblid.getText(), txtSupplierName.getText(), txtContactInfo.getText())
        );
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Supplier Saved!").show();
            loadTable();
            setNextId();
        }
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        boolean isUpdated = supplierBO.updateSupplier(
                new SupplierDto(lblid.getText(), txtSupplierName.getText(), txtContactInfo.getText())
        );
        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Supplier Updated!").show();
            loadTable();
            setNextId();
        }

    }

    @FXML
    void clickOnAction(MouseEvent event) {
        SupplierTM selected = tblSuppliers.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblid.setText(selected.getSupplierId());
            txtSupplierName.setText(selected.getName());
            txtContactInfo.setText(selected.getContactInfo());
        }


    }

    private void setCellValueFactory() {
        colSupplierId.setCellValueFactory(new PropertyValueFactory<>("supplierId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactInfo.setCellValueFactory(new PropertyValueFactory<>("contactInfo"));
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierDto> all = (ArrayList<SupplierDto>) supplierBO.getAllSuppliers();
        ObservableList<SupplierTM> observableList = FXCollections.observableArrayList();

        for (SupplierDto dto : all) {
            observableList.add(new SupplierTM(dto.getSupplierId(), dto.getName(), dto.getContactInfo()));
        }

        tblSuppliers.setItems(observableList);
    }

    private void setNextId() throws SQLException, ClassNotFoundException {
        lblid.setText(supplierBO.getNextId());
    }
}
