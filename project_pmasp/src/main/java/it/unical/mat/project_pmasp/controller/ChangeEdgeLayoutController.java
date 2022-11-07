package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;

import com.fxgraph.edges.CorneredLoopEdge.Position;

import it.unical.mat.project_pmasp.enums.EdgeTypes;
import it.unical.mat.project_pmasp.model.ConstraintEdge;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ChangeEdgeLayoutController {

    @FXML
    private ChoiceBox<String> orientationPositionChoice;

    @FXML
    private ChoiceBox<String> typeChoice;
    
    private ArrayList<String> orientationPositions;
    private ArrayList<String> edgeLayouts;
    private String selectedActivity;
    private String selectedActivity2;
    
    @FXML
    void initialize() {
        selectedActivity = GraphView.getInstance().getSelectedActivity();
        selectedActivity2 = GraphView.getInstance().getSelectedActivity2();
        ConstraintEdge edge = GraphModelHandler.getInstance().getConstraintEdge(selectedActivity, selectedActivity2);
        edgeLayouts = new ArrayList<>();
        orientationPositions = new ArrayList<>();
        if(edge != null) {
        	if(!selectedActivity.equals(selectedActivity2)) {
        		edgeLayouts.add("Normal");
        		edgeLayouts.add("Cornered");
        		edgeLayouts.add("Double Cornered");
        		orientationPositions.add("Horizontal");
        		orientationPositions.add("Vertical");
        	}
        	else {
        		edgeLayouts.add("Cornered Loop");
        		orientationPositions.add("Bottom");
        		orientationPositions.add("Left");
        		orientationPositions.add("Right");
        		orientationPositions.add("Top");
        	}
        	orientationPositionChoice.setItems((ObservableList<String>) FXCollections.observableList(orientationPositions));
        	typeChoice.setItems((ObservableList<String>) FXCollections.observableList(edgeLayouts));
        }
    }

    @FXML
    void cancelPressed(MouseEvent event) {
    	GraphView.getInstance().resetBoolean();
		Stage stage = (Stage) typeChoice.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setEdgePressed(MouseEvent event) {
    	GraphView.getInstance().updateCellPosition();
    	if(typeChoice.getSelectionModel().getSelectedItem() != null && orientationPositionChoice.getSelectionModel().getSelectedItem() != null) {
    		if(!selectedActivity.equals(selectedActivity2)){
    			ConstraintEdge edge = GraphModelHandler.getInstance().getConstraintEdge(selectedActivity, selectedActivity2);
    			String selectedTypeItem = typeChoice.getSelectionModel().getSelectedItem();
    			String selectedOrientation = orientationPositionChoice.getSelectionModel().getSelectedItem(); 
    			if(!selectedTypeItem.equals("Normal"))
    				edge.setOrientation(selectedOrientation.equals("Horizontal") ? Orientation.HORIZONTAL : Orientation.VERTICAL);
    			if(selectedTypeItem.equals("Cornered"))
    				edge.setEdgeType(EdgeTypes.CORNERED);
    			else if(selectedTypeItem.equals("Double Cornered"))
    				edge.setEdgeType(EdgeTypes.DOUBLE_CORNERED);
    			else
    				edge.setEdgeType(EdgeTypes.NORMAL);
    		}
    		else {
    			ConstraintEdge edge = GraphModelHandler.getInstance().getConstraintEdge(selectedActivity, selectedActivity2);
    			String selectedPosition = orientationPositionChoice.getSelectionModel().getSelectedItem();
    			if(selectedPosition.equals("Top"))
    				edge.setPosition(Position.TOP);
    			else if(selectedPosition.equals("Bottom"))
    				edge.setPosition(Position.BOTTOM);
    			else if(selectedPosition.equals("Left"))
    				edge.setPosition(Position.LEFT);
    			else
    				edge.setPosition(Position.RIGHT);
    		}
    		GraphView.getInstance().updateGraph();
    	}
    }
    
    @FXML
    void typeChoicePressed(MouseEvent event) {
    	if(typeChoice.getSelectionModel().getSelectedItem() != null)
	    	if(typeChoice.getSelectionModel().getSelectedItem().equals("Normal")) {
	    		ArrayList<String> none = new ArrayList<>();
	    		none.add("None");
	    		orientationPositionChoice.setItems((ObservableList<String>) FXCollections.observableList(none));
	    		orientationPositionChoice.getSelectionModel().select(0);
	    	}
	    	else
	    		orientationPositionChoice.setItems((ObservableList<String>) FXCollections.observableList(orientationPositions));
    }
    
    @FXML
    void orientationPositionPressed(MouseEvent event) {
    	if(typeChoice.getSelectionModel().getSelectedItem() != null)
	    	if(typeChoice.getSelectionModel().getSelectedItem().equals("Normal")) {
	    		ArrayList<String> none = new ArrayList<>();
	    		none.add("None");
	    		orientationPositionChoice.setItems((ObservableList<String>) FXCollections.observableList(none));
	    		orientationPositionChoice.getSelectionModel().select(0);
	    	}
	    	else
	    		orientationPositionChoice.setItems((ObservableList<String>) FXCollections.observableList(orientationPositions));
    }

}
