package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;
import it.unical.mat.project_pmasp.model.Activity;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddActivityController {

    @FXML
    private ChoiceBox<String> activityChoice;
    
    @FXML
    private void initialize() {
    	ArrayList<Activity> activities = GraphModelHandler.getInstance().getActivities();
    	ArrayList<String> actStr = new ArrayList<>();
    	for(Activity a : activities) {
    		actStr.add(a.getName());
    		System.out.println(a.getName());
    	}
    	activityChoice.setItems((ObservableList<String>) FXCollections.observableList(actStr));
    }

    @FXML
    void addActivityPressed(MouseEvent event) {
    	if(activityChoice.getSelectionModel().getSelectedItem() != null)
    		GraphView.getInstance().addActivityCell(activityChoice.getSelectionModel().getSelectedItem());
    }

    @FXML
    void cancelPressed(MouseEvent event) {
    	Stage stage = (Stage) activityChoice.getScene().getWindow();
        stage.close();
    }

}
