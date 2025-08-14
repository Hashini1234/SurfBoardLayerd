package org.example.surfboardlayerd.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.example.surfboardlayerd.BO.custom.GuideBO;
import org.example.surfboardlayerd.BO.BOFactory;
import org.example.surfboardlayerd.Dao.DAOFactory;
import org.example.surfboardlayerd.Dao.custom.GuideDao;
import org.example.surfboardlayerd.entity.GuideEntity;
import org.example.surfboardlayerd.model.GuideDto;
import org.example.surfboardlayerd.view.tdm.GuideTM;

import java.sql.SQLException;
import java.util.List;

public class GuideFormController {
    private final GuideBO guideBO = (GuideBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.GUIDE);
    public TextField txtName;
    public TextField txtContactDetails;
    public TextField txtExperience_Year;
    public TextField txtPayForHour;
    public TableView< GuideTM> tblGuide;
    public TableColumn<?,?> clmGuideid;
    public TableColumn<?,?> clmName;
    public TableColumn<?,?> clmContact;
    public TableColumn<?,?> clmExperience;
    public TableColumn<?,?> clmPay;
    public Label lblId;



    public void initialize() throws SQLException, ClassNotFoundException {
        setCellValueFactory();
        setNextId();
        loadTable();
    }

    private void setCellValueFactory() {
        clmGuideid.setCellValueFactory(new PropertyValueFactory<>("guide_id"));
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmContact.setCellValueFactory(new PropertyValueFactory<>("contact_Details"));
        clmExperience.setCellValueFactory(new PropertyValueFactory<>("experience_Level"));
        clmPay.setCellValueFactory(new PropertyValueFactory<>("pay_for"));
    }

    public void btnGenarateROnAction(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("This function can’t be used now. Try again later.");
        alert.showAndWait();
    }

    private void loadTable() throws SQLException, ClassNotFoundException {
        List<GuideTM> list = guideBO.getAllGuides();
        tblGuide.setItems(FXCollections.observableArrayList(list));
    }
    private void setNextId() throws SQLException, ClassNotFoundException {
        lblId.setText(guideBO.getNextId());
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isUpdated = guideBO.updateGuide(new GuideEntity(
                lblId.getText(),
                txtName.getText(),
                txtContactDetails.getText(),
                txtExperience_Year.getText(),
                Double.valueOf(txtPayForHour.getText())
        ));
        if (isUpdated) {
            new Alert(Alert.AlertType.INFORMATION, "Guide Updated!").show();
            loadTable();
            setNextId();
        }
    }

    public void btnDeleteOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isDeleted = guideBO.deleteGuide(lblId.getText());
        if (isDeleted) {
            new Alert(Alert.AlertType.INFORMATION, "Guide Deleted!").show();
            loadTable();
            setNextId();
        }
    }

    public void btnResetOnAction(ActionEvent actionEvent) {
    }

    public void btnSaveOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isSaved = guideBO.saveGuide(new GuideEntity(
                lblId.getText(),
                txtName.getText(),
                txtContactDetails.getText(),
                txtExperience_Year.getText(),
                Double.valueOf(txtPayForHour.getText())
        ));
        if (isSaved) {
            new Alert(Alert.AlertType.INFORMATION, "Guide Saved!").show();
            loadTable();
            setNextId();
        }

    }

    public void clickOnAction(MouseEvent mouseEvent) {
        GuideTM selected =  tblGuide.getSelectionModel().getSelectedItem();
        if (selected != null) {
            lblId.setText(selected.getGuide_id());
            txtName.setText(selected.getName());
            txtContactDetails.setText(selected.getContact_Details());
            txtExperience_Year.setText(selected.getExperience_Level());
            txtPayForHour.setText(String.valueOf(selected.getPay_for()));
        }
    }
    }

