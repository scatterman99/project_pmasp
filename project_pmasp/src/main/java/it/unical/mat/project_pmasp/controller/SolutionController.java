package it.unical.mat.project_pmasp.controller;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import it.unical.mat.project_pmasp.SceneHandler;
import it.unical.mat.project_pmasp.model.LogHandler;
import it.unical.mat.project_pmasp.model.Solver;
import it.unical.mat.project_pmasp.model.TraceAcceptedProperty;
import javafx.application.Platform;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SolutionController {
	
    @FXML
    private TableColumn<TraceAcceptedProperty, String> solution;

    @FXML
    private TableView<TraceAcceptedProperty> table;

    @FXML
    private TableColumn<TraceAcceptedProperty, Integer> traceNumber;

    @FXML
    private TextField traceNumberField;
    
    @FXML
    private TextField traceLeftIntervalField;

    @FXML
    private TextField traceRightIntervalField;
    
    @FXML
    private void initialize() {
    	Solver.getInstance().solve();
    	reset();
    }
    
    private void reset() {
    	solution.setCellValueFactory(cellData -> cellData.getValue().getSolutionProperty());
		traceNumber.setCellValueFactory(cellData -> cellData.getValue().getTraceNumberProperty().asObject());
		ObservableList<TraceAcceptedProperty> traceAcceptedPropertyArray = Solver.getInstance().getTraceAcceptedPropertyArray();
		table.setItems(traceAcceptedPropertyArray);
		traceLeftIntervalField.setText("" + 1);
		traceRightIntervalField.setText("" + (traceAcceptedPropertyArray.isEmpty() ? 1 : traceAcceptedPropertyArray.size()));
    }

    @FXML
    void closeButtonPressed(MouseEvent event) {
    	Stage stage = (Stage) table.getScene().getWindow();
        stage.close();
    }

    @FXML
    void searchIntervalButtonPressed(MouseEvent event) {
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
    	solution.setCellValueFactory(cellData -> cellData.getValue().getSolutionProperty());
		traceNumber.setCellValueFactory(cellData -> cellData.getValue().getTraceNumberProperty().asObject());
		ObservableList<TraceAcceptedProperty> traceAcceptedPropertyArray = Solver.getInstance().getTraceAcceptedPropertyArray(i1, i2);
		table.setItems(traceAcceptedPropertyArray);
	}

	@FXML
    void searchNumberButtonPressed(MouseEvent event) {
		try {
			int i1 = Integer.parseInt(traceNumberField.getText());
			reset(i1,i1);
				
		} catch (Exception e) {
			System.out.println("Errore intervallo non valido");
		}
    }

    @FXML
    void tablePressed(MouseEvent event) throws Exception {
    	if(event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) 
			if(table.getSelectionModel().getSelectedItem() != null) {
				TraceAcceptedProperty p = table.getSelectionModel().getSelectedItem();
				SceneHandler.getInstance().setCurrentTraceId(p.getTraceNumberProperty().get());
				LogHandler.getInstance().loadTraces();
				SceneHandler.getInstance().goToTrace((Stage) table.getScene().getWindow());
			}
    }
    
    @FXML
    void resetButtonPressed(MouseEvent event) {
    	reset();
    }

}
