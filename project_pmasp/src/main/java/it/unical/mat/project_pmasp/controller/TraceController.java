package it.unical.mat.project_pmasp.controller;

import it.unical.mat.project_pmasp.SceneHandler;
import it.unical.mat.project_pmasp.model.EventProperty;
import it.unical.mat.project_pmasp.model.LogHandler;
import it.unical.mat.project_pmasp.model.Solver;
import it.unical.mat.project_pmasp.model.TraceAcceptedProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TraceController {

    @FXML
    private TableColumn<EventProperty, String> event;

    @FXML
    private TableColumn<EventProperty, Integer> eventId;

    @FXML
    private TableView<EventProperty> table;

    @FXML
    private TableColumn<EventProperty, Integer> traceId;
    
    @FXML
    private void initialize() {
    	event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
    	eventId.setCellValueFactory(cellData -> cellData.getValue().getEventIdProperty().asObject());
		traceId.setCellValueFactory(cellData -> cellData.getValue().getTraceIdProperty().asObject());
		int i1 = SceneHandler.getInstance().getCurrentTraceId();
		ObservableList<EventProperty> eventPropertyArray = LogHandler.getInstance().getEventPropertyArray(i1, i1);
		table.setItems(eventPropertyArray);
    }

    @FXML
    void closeButtonPressed(MouseEvent event) {
    	Stage stage = (Stage) table.getScene().getWindow();
        stage.close();
    }

}
