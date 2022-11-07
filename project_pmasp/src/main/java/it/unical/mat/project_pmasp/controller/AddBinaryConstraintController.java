package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;

import it.unical.mat.project_pmasp.enums.BinaryConstraints;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddBinaryConstraintController {

    @FXML
    private ChoiceBox<String> constraintChoice;
    
    @FXML
	private void initialize() {
		ArrayList<String> binaryConstarints = new ArrayList<>();
		binaryConstarints.add(BinaryConstraints.ALTERNATE_PRECEDENCE);
		binaryConstarints.add(BinaryConstraints.ALTERNATE_RESPONSE);
		binaryConstarints.add(BinaryConstraints.ALTERNATE_SUCCESSION);
		binaryConstarints.add(BinaryConstraints.CHAIN_PRECEDENCE);
		binaryConstarints.add(BinaryConstraints.CHAIN_RESPONSE);
		binaryConstarints.add(BinaryConstraints.CHAIN_SUCCESSION);
		binaryConstarints.add(BinaryConstraints.COEXISTENCE);
		binaryConstarints.add(BinaryConstraints.NOT_CHAIN_SUCCESSION);
		binaryConstarints.add(BinaryConstraints.NOT_COEXISTENCE);
		binaryConstarints.add(BinaryConstraints.NOT_SUCCESSION);
		binaryConstarints.add(BinaryConstraints.PRECEDENCE);
		binaryConstarints.add(BinaryConstraints.RESPONDED_EXISTENCE);
		binaryConstarints.add(BinaryConstraints.RESPONSE);
		binaryConstarints.add(BinaryConstraints.SUCCESSION);
		constraintChoice.setItems((ObservableList<String>) FXCollections.observableList(binaryConstarints));
	}

    @FXML
    void addConstraintPressed(MouseEvent event) {
    	if (constraintChoice.getSelectionModel().getSelectedItem() != null)
			GraphView.getInstance().addBinaryConstraint(constraintChoice.getSelectionModel().getSelectedItem());
    }

    @FXML
    void cancelPressed(MouseEvent event) {
    	GraphView.getInstance().resetBoolean();
    	Stage stage = (Stage) constraintChoice.getScene().getWindow();
        stage.close();
    }

}
