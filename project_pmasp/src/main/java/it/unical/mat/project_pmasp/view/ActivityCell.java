package it.unical.mat.project_pmasp.view;

import com.fxgraph.cells.AbstractCell;
import com.fxgraph.cells.CellGestures;
import com.fxgraph.graph.Graph;

import it.unical.mat.project_pmasp.controller.ActivityController;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ActivityCell extends AbstractCell {
	
	private Text activityName;
	private Text unaryConstraints;
	private Rectangle view = new Rectangle(120, 120);
	private Pane pane = new Pane(view);
	private ActivityController event;

	public ActivityCell(String activityName, ActivityController activityController) {
		super();
		this.activityName = new Text(activityName);
		this.event = activityController;
		unaryConstraints = new Text();
	}

	@Override
	public Region getGraphic(Graph graph) {
		
		view.setStroke(Color.CORAL);
		view.setFill(Color.CORAL);

		Text text = new Text("Activity");
		text.setStyle("-fx-font-weight: bold");
		text.setLayoutX(4);
		text.setLayoutY(14);
		pane.getChildren().add(text);
		activityName.setLayoutX(4);
		activityName.setLayoutY(30);
		pane.getChildren().add(activityName);
		Text text3 = new Text("Constraints");
		text3.setStyle("-fx-font-weight: bold");
		text3.setLayoutX(4);
		text3.setLayoutY(50);
		pane.getChildren().add(text3);
		unaryConstraints.setLayoutX(4);
		unaryConstraints.setLayoutY(66);
		pane.getChildren().add(unaryConstraints);

		pane.setPrefSize(120, 120);
		view.widthProperty().bind(pane.prefWidthProperty());
		view.heightProperty().bind(pane.prefHeightProperty());

		view.setOnMousePressed(event);
		text.setOnMousePressed(event);
		activityName.setOnMousePressed(event);
		text3.setOnMousePressed(event);
		unaryConstraints.setOnMousePressed(event);

		//CellGestures.makeResizable(graph, pane);
		return pane;
	}

	public Text getActivityName() {
		return activityName;
	}

	public void setActivityName(Text activityName) {
		this.activityName = activityName;
	}
	
	public void setColor(Color color) {
		view.setStroke(color);
		view.setFill(color);
	}

	public void addConstraint(String constraint) {
		String oldConstraints = unaryConstraints.getText();
		if(!oldConstraints.contains(constraint + "\n"))
			oldConstraints += constraint + "\n";
		unaryConstraints.setText(oldConstraints);
	}

	public void removeConstraint(String constraint) {
		String oldConstraints = unaryConstraints.getText();
		String newConstraints = "";
		if(oldConstraints.contains(constraint + "\n"))
			newConstraints = oldConstraints.replace(constraint + "\n", "");
		unaryConstraints.setText(newConstraints);
	}

}
