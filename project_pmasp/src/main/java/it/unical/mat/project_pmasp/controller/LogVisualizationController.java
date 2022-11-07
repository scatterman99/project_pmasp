package it.unical.mat.project_pmasp.controller;

import it.unical.mat.project_pmasp.SceneHandler;
import it.unical.mat.project_pmasp.model.LogHandler;
import it.unical.mat.project_pmasp.model.EventProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LogVisualizationController {

	@FXML
    private TableColumn<EventProperty, String> event;

    @FXML
    private TableColumn<EventProperty, Integer> eventId;

    @FXML
    private TableView<EventProperty> table;

    @FXML
    private TableColumn<EventProperty, Integer> traceId;

    @FXML
    private TextField traceLeftIntervalField;

    @FXML
    private TextField traceRightIntervalField;
    
    @FXML
    public void initialize() {
    	reset();
    }

    @FXML
    void closeButtonPressed(MouseEvent event) {
    	Stage stage = (Stage) table.getScene().getWindow();
    	SceneHandler.getInstance().setLogStage(null);
        stage.close();
    }

    @FXML
    void resetButtonPressed(MouseEvent event) {
    	reset();
    }

    private void reset() {
    	LogHandler.getInstance().loadTraces();
    	event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
    	eventId.setCellValueFactory(cellData -> cellData.getValue().getEventIdProperty().asObject());
		traceId.setCellValueFactory(cellData -> cellData.getValue().getTraceIdProperty().asObject());
		ObservableList<EventProperty> eventPropertyArray = LogHandler.getInstance().getEventPropertyArray();
		if(eventPropertyArray != null)
			table.setItems(eventPropertyArray);
	}

	@FXML
    void searchButtonPressed(MouseEvent event) {
		try {
			int i1 = Integer.parseInt(traceLeftIntervalField.getText());
			int i2 = Integer.parseInt(traceRightIntervalField.getText());
			if(i1 <= i2)
				reset(i1,i2);
			else
				System.out.println("Errore intervallo non valido");
				
		} catch (Exception e) {
			System.out.println("Errore intervallo non valido");
		}
    }

	private void reset(int i1, int i2) {
		event.setCellValueFactory(cellData -> cellData.getValue().getEventProperty());
    	eventId.setCellValueFactory(cellData -> cellData.getValue().getEventIdProperty().asObject());
		traceId.setCellValueFactory(cellData -> cellData.getValue().getTraceIdProperty().asObject());
		ObservableList<EventProperty> eventPropertyArray = LogHandler.getInstance().getEventPropertyArray(i1, i2);
		table.setItems(eventPropertyArray);
	}

}
