package it.unical.mat.project_pmasp.view;

import java.util.ArrayList;

import org.abego.treelayout.Configuration.Location;

import com.fxgraph.cells.RectangleCell;
import com.fxgraph.cells.TriangleCell;
import com.fxgraph.edges.AbstractEdge;
import com.fxgraph.edges.CorneredEdge;
import com.fxgraph.edges.CorneredLoopEdge;
import com.fxgraph.edges.Edge;
import com.fxgraph.edges.CorneredLoopEdge.Position;
import com.fxgraph.edges.DoubleCorneredEdge;
import com.fxgraph.graph.Graph;
import com.fxgraph.graph.ICell;
import com.fxgraph.graph.Model;
import com.fxgraph.layout.AbegoTreeLayout;

import it.unical.mat.project_pmasp.controller.ActivityController;
import it.unical.mat.project_pmasp.enums.EdgeTypes;
import it.unical.mat.project_pmasp.model.ActivityNode;
import it.unical.mat.project_pmasp.model.ConstraintEdge;
import it.unical.mat.project_pmasp.model.GraphModelHandler;
import javafx.geometry.Orientation;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

public class GraphView {

	private BorderPane sBorderPane;
	private ArrayList<ActivityCell> activityCells;

	private Graph graph;

	private boolean canRemoveActivity;
	private boolean canAddRemoveUnaryConstraint;
	private boolean canAddRemoveBinaryConstraint;
	private boolean canChangeEdgeLayout;
	private boolean canClick;
	private String selectedActivity;
	private String selectedActivity2;

	private static GraphView instance = null;

	private GraphView() {
	}

	public static GraphView getInstance() {
		if (instance == null)
			instance = new GraphView();
		return instance;
	}

	public void init(BorderPane sBorderPane) {
		this.sBorderPane = sBorderPane;
		resetGraph();
		/*
		 * AbegoTreeLayout layout = new AbegoTreeLayout(200, 200, Location.Left);
		 * graph.layout(layout);
		 */
	}

	public void updateGraph() {
		Model model = graph.getModel();
		graph.beginUpdate();
		ArrayList<ActivityNode> activityNodes = GraphModelHandler.getInstance().getActivityNodes();
		activityCells = new ArrayList<>();
		for (ActivityNode a : activityNodes) {
			ActivityCell cell = new ActivityCell(a.getActivity().getName(),
					new ActivityController(a.getActivity().getName()));
			for (String uc : a.getUnaryConstraints())
				cell.addConstraint(uc);
			activityCells.add(cell);
			model.addCell(cell);
			// cell.getXAnchor(graph).add(444.0);
			// cell.getYAnchor(graph).add(a.getY());
			System.out.println("misch");
		}
		for (ActivityCell ac : activityCells)
			for (ActivityCell ac2 : activityCells)
				addBinaryConstraints(ac, ac2, model);
		graph.endUpdate();
		StandardLayout layout = new StandardLayout();
		graph.layout(layout);
		if (canRemoveActivity)
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.RED);
		if (canAddRemoveUnaryConstraint)
			for (ActivityCell ac : activityCells)
				if (ac.getActivityName().getText().equals(selectedActivity))
					ac.setColor(Color.GREEN);
				else
					ac.setColor(Color.YELLOW);
		if (canAddRemoveBinaryConstraint)
			for (ActivityCell ac : activityCells)
				if (ac.getActivityName().getText().equals(selectedActivity2))
					ac.setColor(Color.LIGHTGREEN);
				else if (ac.getActivityName().getText().equals(selectedActivity))
					ac.setColor(Color.GREEN);
				else
					ac.setColor(Color.YELLOW);
		if(canChangeEdgeLayout)
			for (ActivityCell ac : activityCells)
				if (ac.getActivityName().getText().equals(selectedActivity2))
					ac.setColor(Color.LIGHTBLUE);
				else if (ac.getActivityName().getText().equals(selectedActivity))
					ac.setColor(Color.BLUE);
				else
					ac.setColor(Color.YELLOW);
	}

	private void addBinaryConstraints(ActivityCell ac, ActivityCell ac2, Model model) {
		ConstraintEdge edge = GraphModelHandler.getInstance().getConstraintEdge(ac.getActivityName().getText(),
				ac2.getActivityName().getText());
		if (edge == null)
			return;
		StringBuilder binaryConstraints = new StringBuilder();
		for (String bc : edge.getBinaryConstraints()) {
			binaryConstraints.append(bc);
			binaryConstraints.append("\n");
		}
		switch (edge.getEdgeType()) {
		case EdgeTypes.NORMAL:
			Edge e = new Edge(ac, ac2, true);
			e.textProperty().set(binaryConstraints.toString());
			model.addEdge(e);
			break;
		case EdgeTypes.CORNERED:
			CorneredEdge ce = new CorneredEdge(ac, ac2, true, edge.getOrientation());
			ce.textProperty().set(binaryConstraints.toString());
			model.addEdge(ce);
			break;
		case EdgeTypes.DOUBLE_CORNERED:
			DoubleCorneredEdge dce = new DoubleCorneredEdge(ac, ac2, true, edge.getOrientation());
			dce.textProperty().set(binaryConstraints.toString());
			model.addEdge(dce);
			break;
		default:
			CorneredLoopEdge cle = new CorneredLoopEdge(ac2, edge.getPosition());
			cle.textProperty().set(binaryConstraints.toString());
			model.addEdge(cle);
		}

	}

	public void updateCellPosition() {
		for (ActivityCell a : activityCells)
			for (ActivityNode n : GraphModelHandler.getInstance().getActivityNodes())
				if (a.getActivityName().getText().equals(n.getActivity().getName())) {
					System.out.println(a.getXAnchor(graph).get());
					System.out.println(a.getYAnchor(graph).get());
					n.setX(a.getXAnchor(graph).get() - 60.0);
					n.setY(a.getYAnchor(graph).get() - 60.0);
				}
	}

	public void addActivityCell(String activity) {
		updateCellPosition();
		GraphModelHandler.getInstance().addActivityNode(activity);
		updateGraph();
	}

	public void removeActivityCell(String activity) {
		updateCellPosition();
		GraphModelHandler.getInstance().removeActivityNode(activity);
		updateGraph();
	}

	public void addUnaryConstraint(String activity, String constraint) {
		updateCellPosition();
		GraphModelHandler.getInstance().addUnaryConstraint(activity, constraint);
		updateGraph();
	}

	public void addUnaryConstraint(String constraint) {
		updateCellPosition();
		GraphModelHandler.getInstance().addUnaryConstraint(selectedActivity, constraint);
		updateGraph();
	}

	public void removeUnaryConstraint(String constraint) {
		updateCellPosition();
		GraphModelHandler.getInstance().removeUnaryConstraint(selectedActivity, constraint);
		updateGraph();
	}

	public void addBinaryConstraint(String constraint) {
		updateCellPosition();
		GraphModelHandler.getInstance().addBinaryConstraint(selectedActivity, selectedActivity2, constraint);
		updateGraph();
	}

	public void removeBinaryConstraint(String constraint) {
		updateCellPosition();
		GraphModelHandler.getInstance().removeBinaryConstraint(selectedActivity, selectedActivity2, constraint);
		updateGraph();
	}

	public void resetGraph() {
		activityCells = new ArrayList<>();
		if(graph != null)
			this.sBorderPane.getChildren().remove(graph.getCanvas());
		resetBoolean();
		graph = new Graph();
		graph.getViewportGestures().setPanButton(MouseButton.SECONDARY);
		graph.getNodeGestures().setDragButton(MouseButton.PRIMARY);
		this.sBorderPane.getChildren().add(graph.getCanvas());
	}

	public void readyToRemoveActivity() {
		if (!canRemoveActivity) {
			canRemoveActivity = true;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.RED);
		} else {
			canRemoveActivity = false;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.CORAL);
		}
	}

	public void readyToAddRemoveUnaryConstraint() {
		if (!canAddRemoveUnaryConstraint) {
			canAddRemoveUnaryConstraint = true;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.YELLOW);
		} else {
			canAddRemoveUnaryConstraint = false;
			canClick = true;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.CORAL);
		}
	}

	public void readyToAddRemoveBinaryConstraint() {
		if (!canAddRemoveBinaryConstraint) {
			canAddRemoveBinaryConstraint = true;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.YELLOW);
		} else {
			canAddRemoveBinaryConstraint = false;
			canClick = true;
			this.selectedActivity = null;
			this.selectedActivity2 = null;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.CORAL);
		}
	}

	public void readyToChangeEdgeLayout() {
		if (!canChangeEdgeLayout) {
			canChangeEdgeLayout = true;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.YELLOW);
		} else {
			canChangeEdgeLayout = false;
			canClick = true;
			this.selectedActivity = null;
			this.selectedActivity2 = null;
			for (ActivityCell ac : activityCells)
				ac.setColor(Color.CORAL);
		}
	}

	public boolean isCanRemoveActivity() {
		return canRemoveActivity;
	}

	public boolean isCanAddRemoveUnaryConstraint() {
		return canAddRemoveUnaryConstraint;
	}

	public boolean isCanAddRemoveBinaryConstraint() {
		return canAddRemoveBinaryConstraint;
	}

	public void resetBoolean() {
		canRemoveActivity = false;
		canAddRemoveUnaryConstraint = false;
		canAddRemoveBinaryConstraint = false;
		canChangeEdgeLayout = false;
		canClick = true;
		selectedActivity = null;
		selectedActivity2 = null;
		for (ActivityCell ac : activityCells)
			ac.setColor(Color.CORAL);
	}

	public void setSelectedActivity(String selectedActivity) {
		this.selectedActivity = selectedActivity;
		for (ActivityCell ac : activityCells)
			if (ac.getActivityName().getText().equals(selectedActivity))
				if (canAddRemoveBinaryConstraint || canAddRemoveUnaryConstraint)
					ac.setColor(Color.GREEN);
				else
					ac.setColor(Color.BLUE);
	}

	public String getSelectedActivity() {
		return selectedActivity;
	}

	public String getSelectedActivity2() {
		return selectedActivity2;
	}

	public void setSelectedActivity2(String selectedActivity2) {
		this.selectedActivity2 = selectedActivity2;
		for (ActivityCell ac : activityCells)
			if (ac.getActivityName().getText().equals(selectedActivity2))
				if (canAddRemoveBinaryConstraint)
					ac.setColor(Color.LIGHTGREEN);
				else
					ac.setColor(Color.LIGHTBLUE);
	}

	public boolean isCanClick() {
		return canClick;
	}

	public void setCanClick(boolean canClick) {
		this.canClick = canClick;
	}

	public boolean isCanChangeEdgeLayout() {
		return canChangeEdgeLayout;
	}

}
