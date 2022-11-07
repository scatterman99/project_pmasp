package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;

import it.unical.mat.project_pmasp.model.ActivityNode;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RemoveBinaryConstraintController {

    @FXML
    private ChoiceBox<String> constraintChoice;
    
    @FXML
    private void initialize() {
    	String source = GraphView.getInstance().getSelectedActivity();
    	String destination = GraphView.getInstance().getSelectedActivity2();
    	System.out.println(source);
    	System.out.println(destination);
    	ArrayList<String> oldConstraints = GraphModelHandler.getInstance().getBinaryConstraints(source, destination);
    	System.out.println(oldConstraints);
    	ArrayList<String> newConstraints = new ArrayList<>();
    	if(oldConstraints != null)
    		newConstraints.addAll(oldConstraints);
    	constraintChoice.setItems((ObservableList<String>) FXCollections.observableList(newConstraints));
    }

    @FXML
    void cancelPressed(MouseEvent event) {
    	GraphView.getInstance().resetBoolean();
    	Stage stage = (Stage) constraintChoice.getScene().getWindow();
        stage.close();
    }

    @FXML
    void removeConstraintPressed(MouseEvent event) {
    	if (constraintChoice.getSelectionModel().getSelectedItem() != null) {
			GraphView.getInstance().removeBinaryConstraint(constraintChoice.getSelectionModel().getSelectedItem());
			constraintChoice.getItems().remove(constraintChoice.getSelectionModel().getSelectedItem());
			constraintChoice.getSelectionModel().selectFirst();
    	}
    }

}
