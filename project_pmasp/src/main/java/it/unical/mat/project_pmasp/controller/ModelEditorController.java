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
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import it.unical.mat.project_pmasp.view.ActivityCell;
import it.unical.mat.project_pmasp.view.AddRemoveOption;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class ModelEditorController {

	@FXML
	private BorderPane sBorderPane;

	@FXML
	private void initialize() {

		GraphView.getInstance().init(sBorderPane);

		/*
		 * Graph graph = new Graph();
		 * 
		 * // Add content to graph
		 * 
		 * // Layout nodes
		 * 
		 * // Configure interaction buttons and behavior
		 * graph.getViewportGestures().setPanButton(MouseButton.SECONDARY);
		 * graph.getNodeGestures().setDragButton(MouseButton.PRIMARY);
		 * 
		 * // Display the graph sBorderPane.getChildren().add(graph.getCanvas());
		 * 
		 * populateGraph(graph);
		 * 
		 * AbegoTreeLayout layout = new AbegoTreeLayout(200, 200, Location.Top);
		 * graph.layout(layout);
		 */
	}

	private void populateGraph(Graph graph) {
		/*
		 * final Model model = graph.getModel(); graph.beginUpdate(); final ICell cellA
		 * = new RectangleCell(); final ICell cellB = new RectangleCell(); final ICell
		 * cellC = new RectangleCell(); final ICell cellD = new RectangleCell(); final
		 * ICell cellE = new RectangleCell(); final ICell cellF = new
		 * ActivityCell("Sepsis", new ActivityController("Sepsis")); final ICell cellG =
		 * new TriangleCell();
		 * 
		 * model.addCell(cellA); model.addCell(cellB); model.addCell(cellC);
		 * model.addCell(cellD); model.addCell(cellE); model.addCell(cellF);
		 * model.addCell(cellG);
		 * 
		 * final Edge edgeAB = new Edge(cellF, cellB, true);
		 * edgeAB.textProperty().set("Directed Edge"); model.addEdge(edgeAB);
		 * 
		 * final CorneredEdge edgeAC = new CorneredEdge(cellA, cellC, true,
		 * Orientation.HORIZONTAL); edgeAC.textProperty().set("Directed CorneredEdge");
		 * model.addEdge(edgeAC);
		 * 
		 * final DoubleCorneredEdge edgeBE = new DoubleCorneredEdge(cellB, cellE, true,
		 * Orientation.VERTICAL);
		 * edgeBE.textProperty().set("Directed DoubleCorneredEdge");
		 * model.addEdge(edgeBE);
		 * 
		 * 
		 * final Edge edgeCF = new Edge(cellC, cellF, true);
		 * edgeCF.textProperty().set("Directed Edge"); model.addEdge(edgeCF);
		 * 
		 * final CorneredLoopEdge loopFTop = new CorneredLoopEdge(cellF, Position.TOP);
		 * loopFTop.textProperty().set("Loop top"); model.addEdge(loopFTop);
		 * 
		 * model.addEdge(cellC, cellG);
		 * 
		 * model.addEdge(cellB, cellD);
		 * 
		 * graph.endUpdate();
		 */

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
	void clearItemPressed(ActionEvent event) throws Exception {
		GraphView.getInstance().resetGraph();
		GraphModelHandler.getInstance().reset();
		closeModelEditor();
		//SceneHandler.getInstance().startModelEditor();
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
	void guideItemPressed(ActionEvent event) {

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
	void resetLayoutItemPressed(ActionEvent event) {

	}

	@FXML
	void showLpModelItemPressed(ActionEvent event) {
		System.out.println(GraphModelHandler.getInstance().generateModelFile());
	}

	private void closeModelEditor() {
		Stage stage = (Stage) sBorderPane.getScene().getWindow();
		stage.close();
	}
}
