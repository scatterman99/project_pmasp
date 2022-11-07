package it.unical.mat.project_pmasp.controller;

import it.unical.mat.project_pmasp.SceneHandler;
import it.unical.mat.project_pmasp.view.AddRemoveOption;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

public class ActivityController implements EventHandler<MouseEvent> {

	private String activityName;

	public ActivityController(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public void handle(MouseEvent event) {
		if (GraphView.getInstance().isCanClick()) {
			if (GraphView.getInstance().isCanRemoveActivity()) {
				GraphView.getInstance().removeActivityCell(activityName);
				System.out.println(activityName + " rimossa");
			}
			if (GraphView.getInstance().isCanAddRemoveUnaryConstraint()) {
				GraphView.getInstance().setSelectedActivity(activityName);
				ButtonType t = AddRemoveOption.addRemoveAlert("Unary");
				GraphView.getInstance().setCanClick(false);
				if (t.getButtonData() == ButtonData.YES)
					try {
						SceneHandler.getInstance().goToOption("AddUnaryConstraint.fxml", "Add unary constraint");
					} catch (Exception e) {
						e.printStackTrace();
					}
				else if (t.getButtonData() == ButtonData.NO)
					try {
						SceneHandler.getInstance().goToOption("RemoveUnaryConstraint.fxml", "Remove unary constraint");
					} catch (Exception e) {
						e.printStackTrace();
					}
				else {
					GraphView.getInstance().setSelectedActivity(null);
					GraphView.getInstance().readyToAddRemoveUnaryConstraint();
				}
			}
			if (GraphView.getInstance().isCanAddRemoveBinaryConstraint()) {
				if (GraphView.getInstance().getSelectedActivity() != null
						&& GraphView.getInstance().getSelectedActivity2() == null)
					GraphView.getInstance().setSelectedActivity2(activityName);
				if (GraphView.getInstance().getSelectedActivity() == null)
					GraphView.getInstance().setSelectedActivity(activityName);
				if (GraphView.getInstance().getSelectedActivity() != null
						&& GraphView.getInstance().getSelectedActivity2() != null) {
					ButtonType t = AddRemoveOption.addRemoveAlert("Binary");
					GraphView.getInstance().setCanClick(false);
					if (t.getButtonData() == ButtonData.YES)
						try {
							SceneHandler.getInstance().goToOption("AddBinaryConstraint.fxml", "Add binary constraint");
						} catch (Exception e) {
							e.printStackTrace();
						}
					else if (t.getButtonData() == ButtonData.NO)
						try {
							SceneHandler.getInstance().goToOption("RemoveBinaryConstraint.fxml",
									"Remove binary constraint");
						} catch (Exception e) {
							e.printStackTrace();
						}
					else {
						GraphView.getInstance().resetBoolean();
					}
				}
			}
			if (GraphView.getInstance().isCanChangeEdgeLayout()) {
				if (GraphView.getInstance().getSelectedActivity() != null
						&& GraphView.getInstance().getSelectedActivity2() == null)
					GraphView.getInstance().setSelectedActivity2(activityName);
				if (GraphView.getInstance().getSelectedActivity() == null)
					GraphView.getInstance().setSelectedActivity(activityName);
				if (GraphView.getInstance().getSelectedActivity() != null
						&& GraphView.getInstance().getSelectedActivity2() != null) {
					try {
						SceneHandler.getInstance().goToOption("ChangeEdgeLayout.fxml", "Change Edge Layout");
						GraphView.getInstance().setCanClick(false);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
