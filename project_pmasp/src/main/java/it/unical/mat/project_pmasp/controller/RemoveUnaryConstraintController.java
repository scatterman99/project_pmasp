package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;

import it.unical.mat.project_pmasp.model.Activity;
import it.unical.mat.project_pmasp.model.ActivityNode;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RemoveUnaryConstraintController {

    @FXML
    private ChoiceBox<String> constraintChoice;
    
    @FXML
    private void initialize() {
    	ArrayList<ActivityNode> activities = GraphModelHandler.getInstance().getActivityNodes();
    	ArrayList<String> constraints = new ArrayList<>();
    	System.out.println(GraphView.getInstance().getSelectedActivity());
    	for(ActivityNode a : activities) 
    		if(a.getActivity().getName().equals(GraphView.getInstance().getSelectedActivity())) {
    			constraints.addAll(a.getUnaryConstraints());
    			System.out.println("here");
    		}
    	constraintChoice.setItems((ObservableList<String>) FXCollections.observableList(constraints));		
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
			GraphView.getInstance().removeUnaryConstraint(constraintChoice.getSelectionModel().getSelectedItem());
			constraintChoice.getItems().remove(constraintChoice.getSelectionModel().getSelectedItem());
			constraintChoice.getSelectionModel().selectFirst();
    	}
    }

}
