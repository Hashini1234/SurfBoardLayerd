package org.example.surfboardlayerd.controller;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.BO.custom.ItemBO;
import org.example.surfboardlayerd.BO.custom.SurfBoardBO;
import org.example.surfboardlayerd.entity.SupplierEntity;
import org.example.surfboardlayerd.entity.SurfBoardEntity;
import org.example.surfboardlayerd.model.ItemDto;
import org.example.surfboardlayerd.model.SupplierDto;
import org.example.surfboardlayerd.model.SurfBoardDto;

import java.sql.SQLException;
import java.util.ArrayList;

import static sun.net.www.MimeTable.loadTable;


public class SurfBoardController {
    private final SurfBoardBO surfBoardBO = (SurfBoardBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.SURFBOARD);

    @FXML
    private TableColumn<?, ?> colBrand;

    @FXML
    private TableColumn<?, ?> colCondition;

    @FXML
    private TableColumn<?, ?> colSurfboardId;

    @FXML
    private Label lblSurfBoard;

    @FXML
    private TableView<?> tblSurfboards;

    @FXML
    private TextField txtBrand;

    @FXML
    private TextField txtCondition;

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
        SurfBoardDto dto = new SurfBoardDto(lblSurfBoard.getText(), txtBrand.getText(), txtCondition.getText());

        try {
            if (checkFields()) {
                boolean saved = SurfBoardBO.save(dto);
                if (saved) {
                    loadTable();
                    lblSurfBoard.setText(surfBoardBO.getNextId());
                    new Alert(Alert.AlertType.INFORMATION, "Saved!").show();
                    clearFields();
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, "Something went wrong").show();
            throw new RuntimeException(e);

        }


        private void clearFields () {
        }

        private boolean checkFields () {
        }

    }

    private boolean checkFields() {

    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void clickOnAction(MouseEvent event) {

    }

}
