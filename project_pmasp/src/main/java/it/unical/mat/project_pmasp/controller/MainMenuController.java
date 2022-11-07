package it.unical.mat.project_pmasp.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

import org.abego.treelayout.Configuration.Location;

import com.fxgraph.cells.RectangleCell;
import com.fxgraph.cells.TriangleCell;
import com.fxgraph.edges.CorneredEdge;
import com.fxgraph.edges.CorneredLoopEdge;
import com.fxgraph.edges.DoubleCorneredEdge;
import com.fxgraph.edges.Edge;
import com.fxgraph.edges.CorneredLoopEdge.Position;
import com.fxgraph.graph.Graph;
import com.fxgraph.graph.ICell;
import com.fxgraph.graph.Model;
import com.fxgraph.layout.AbegoTreeLayout;

import it.unical.mat.project_pmasp.SceneHandler;
import it.unical.mat.project_pmasp.enums.ErrorMessages;
import it.unical.mat.project_pmasp.model.ActivityHandler;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.model.LogHandler;
import it.unical.mat.project_pmasp.model.LpModelHandler;
import it.unical.mat.project_pmasp.model.Solver;
import it.unical.mat.project_pmasp.view.ActivityCell;
import it.unical.mat.project_pmasp.view.AddRemoveOption;
import it.unical.mat.project_pmasp.view.Alerts;
import it.unical.mat.project_pmasp.view.GraphView;
import it.unical.mat.project_pmasp.view.LoadingAlert;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainMenuController {

	 @FXML
	    private Button addActivityButton;

	    @FXML
	    private MenuItem addActivityItem;

	    @FXML
	    private MenuItem addRemoveBinaryItem;

	    @FXML
	    private MenuItem addRemoveUnaryItem;

	    @FXML
	    private Button binaryConstraintButton;

	    @FXML
	    private MenuItem changeEdgeLayoutItem;

	    @FXML
	    private MenuItem clearModelItem;

	    @FXML
	    private Button edgeLayoutButton;

	    @FXML
	    private MenuItem openLogItem;

	    @FXML
	    private Button openModelButton;

	    @FXML
	    private MenuItem openModelItem;

	    @FXML
	    private Button removeActivityButton;

	    @FXML
	    private MenuItem removeActivityItem;

	    @FXML
	    private BorderPane sBorderPane;

	    @FXML
	    private Button saveModelButton;

	    @FXML
	    private MenuItem saveModelItem;

	    @FXML
	    private Button unaryConstraintButton;


	@FXML
	private void initialize() {
		disableItemsAndButtons(true);
		GraphView.getInstance().init(sBorderPane);
	}

	private void disableItemsAndButtons(boolean condition) {
		addActivityButton.setDisable(condition);
		addActivityItem.setDisable(condition);
		addRemoveBinaryItem.setDisable(condition);
		addRemoveUnaryItem.setDisable(condition);
		binaryConstraintButton.setDisable(condition);
		changeEdgeLayoutItem.setDisable(condition);
		clearModelItem.setDisable(condition);
		edgeLayoutButton.setDisable(condition);
		openModelItem.setDisable(condition);
		openModelButton.setDisable(condition);
		removeActivityButton.setDisable(condition);
		removeActivityItem.setDisable(condition);
		sBorderPane.setDisable(condition);
		saveModelItem.setDisable(condition);
		saveModelButton.setDisable(condition);
		unaryConstraintButton.setDisable(condition);
	}

	@FXML
	void addActivityButtonPressed(MouseEvent event) throws Exception {
		GraphView.getInstance().resetBoolean();
		SceneHandler.getInstance().goToOption("AddActivity.fxml", "Add activity");
	}

	@FXML
	void addActivityItemPressed(ActionEvent event) throws Exception {
		GraphView.getInstance().resetBoolean();
		SceneHandler.getInstance().goToOption("AddActivity.fxml", "Add activity");
	}

	@FXML
	void addRemoveBinaryButtonPressed(MouseEvent event) throws Exception {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToAddRemoveBinaryConstraint();
	}

	@FXML
	void addRemoveBinaryItemPressed(ActionEvent event) {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToAddRemoveBinaryConstraint();
	}

	@FXML
	void addRemoveUnaryButtonPressed(MouseEvent event) throws Exception {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToAddRemoveUnaryConstraint();
	}

	@FXML
	void addRemoveUnaryItemPressed(ActionEvent event) throws Exception {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToAddRemoveUnaryConstraint();
	}

	@FXML
	void clearModelItemPressed(ActionEvent event) throws Exception {
		resetGraph();
	}

	@FXML
	void clearAllItemPressed(ActionEvent event) {
		resetGraph();
		LogHandler.getInstance().setCurrentLog(null);
		closeLogView();
		disableItemsAndButtons(true);
	}

	private void closeLogView() {
		if(SceneHandler.getInstance().getLogStage() != null)
			SceneHandler.getInstance().getLogStage().close();
		SceneHandler.getInstance().setLogStage(null);
	}

	@FXML
	void openLogButtonPressed(MouseEvent event) {
		File f = loadFile(".xes File", "*.xes");
		if (f != null) {
			closeLogView();
			resetGraph();
			LogHandler.getInstance().setCurrentLog(null);
			LogHandler.getInstance().loadXesFile(f.getAbsolutePath());
			ActivityHandler.getInstance().loadActivities();
			disableItemsAndButtons(false);
			System.out.println(LogHandler.getInstance().getCurrentLog());
			if(LogHandler.getInstance().getCurrentLog() == null || ActivityHandler.getInstance().getActivities() == null) {
				Alerts.showError(ErrorMessages.LOAD_XES_ERROR);
				resetGraph();
				LogHandler.getInstance().setCurrentLog(null);
				closeLogView();
				disableItemsAndButtons(true);
			}
		}
	}

	private File loadFile(String description, String format) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter(description, format));
		File f = fc.showOpenDialog(null);
		return f;
	}

	@FXML
	void openLogItemPressed(ActionEvent event) {
		File f = loadFile(".xes File", "*.xes");
		if (f != null) {
			resetGraph();
			LogHandler.getInstance().setCurrentLog(null);
			LogHandler.getInstance().loadXesFile(f.getAbsolutePath());
			ActivityHandler.getInstance().loadActivities();
			disableItemsAndButtons(false);
			System.out.println(LogHandler.getInstance().getCurrentLog()); //debug
			if(LogHandler.getInstance().getCurrentLog() == null || ActivityHandler.getInstance().getActivities() == null) {
				Alerts.showError(ErrorMessages.LOAD_XES_ERROR);
				resetGraph();
				LogHandler.getInstance().setCurrentLog(null);
				closeLogView();
				disableItemsAndButtons(true);
			}
		}
	}

	@FXML
	void openModelButtonPressed(MouseEvent event) {
		File f = loadFile(".lp Model File", "*.lpm");
		//controllare corrispondenza modello-log
		if (f != null) {
			LpModelHandler.getInstance().loadLpModelFile(f.getAbsolutePath());
		}
		GraphModelHandler.getInstance().loadGraph();
		GraphView.getInstance().updateGraph();
	}

	@FXML
	void openModelItemPressed(ActionEvent event) {
		File f = loadFile(".lp Model File", "*.lpm");
		//controllare corrispondenza modello-log
		if (f != null) {
			LpModelHandler.getInstance().loadLpModelFile(f.getAbsolutePath());
		}
		GraphModelHandler.getInstance().loadGraph();
		GraphView.getInstance().updateGraph();
	}

	@FXML
	void changeEdgeLayoutButtonPressed(MouseEvent event) {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		GraphView.getInstance().readyToChangeEdgeLayout();
	}
	
	@FXML
	void changeEdgeLayoutItemPressed(MouseEvent event) {
		if (GraphView.getInstance().isCanRemoveActivity())
			GraphView.getInstance().readyToRemoveActivity();
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		GraphView.getInstance().readyToChangeEdgeLayout();
	}

	private File saveFile(String description, String format) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter(description, format));
		File f = fc.showSaveDialog(null);
		return f;
	}

	@FXML
	void exportItemPressed(ActionEvent event) {
		GraphView.getInstance().updateCellPosition();
		File f = saveFile(".lp Model File", "*.lpm");
		try {
			if (Files.exists(f.toPath()))
				Files.delete(f.toPath());
			Files.createFile(f.toPath());
			Files.writeString(f.toPath(), GraphModelHandler.getInstance().exportModel(), StandardOpenOption.APPEND);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(GraphModelHandler.getInstance().exportModel());
	}

	@FXML
	void aboutItemPressed(ActionEvent event) {
		Alerts.about();
	}

	@FXML
	void quitItemPressed(ActionEvent event) {
		closeModelEditor();
	}

	@FXML
	void removeActivityButtonPressed(MouseEvent event) {
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToRemoveActivity();
	}

	@FXML
	void removeActivityItemPressed(ActionEvent event) {
		if (GraphView.getInstance().isCanAddRemoveUnaryConstraint())
			GraphView.getInstance().readyToAddRemoveUnaryConstraint();
		if (GraphView.getInstance().isCanAddRemoveBinaryConstraint())
			GraphView.getInstance().readyToAddRemoveBinaryConstraint();
		if (GraphView.getInstance().isCanChangeEdgeLayout())
			GraphView.getInstance().readyToChangeEdgeLayout();
		GraphView.getInstance().readyToRemoveActivity();
	}

	@FXML
	void solveButtonPressed(MouseEvent event) throws Exception {
		SceneHandler.getInstance().goToSolution();
	}

	@FXML
	void solveItemPressed(ActionEvent event) throws Exception {
		SceneHandler.getInstance().goToSolution();
	}

	private void closeModelEditor() {
		Stage stage = (Stage) sBorderPane.getScene().getWindow();
		stage.close();
	}

	@FXML
	void saveModelButtonPressed(MouseEvent event) {
		GraphView.getInstance().updateCellPosition();
		File f = saveFile(".lp Model File", "*.lpm");
		if(f != null) {
			try {
				if (Files.exists(f.toPath()))
					Files.delete(f.toPath());
				Files.createFile(f.toPath());
				Files.writeString(f.toPath(), GraphModelHandler.getInstance().exportModel(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(GraphModelHandler.getInstance().exportModel());
	}

	@FXML
	void saveModelItemPressed(ActionEvent event) {
		GraphView.getInstance().updateCellPosition();
		File f = saveFile(".lp Model File", "*.lpm");
		if(f != null) {
			try {
				if (Files.exists(f.toPath()))
					Files.delete(f.toPath());
				Files.createFile(f.toPath());
				Files.writeString(f.toPath(), GraphModelHandler.getInstance().exportModel(), StandardOpenOption.APPEND);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println(GraphModelHandler.getInstance().exportModel());
	}

	@FXML
	void showLogButtonPressed(MouseEvent event) throws Exception {
		SceneHandler.getInstance().goToLog();
	}

	@FXML
	void showLogItemPressed(ActionEvent event) throws Exception {
		SceneHandler.getInstance().goToLog();
	}
	
	private void resetGraph() {
		GraphView.getInstance().resetGraph();
		GraphModelHandler.getInstance().reset();
	}
}
