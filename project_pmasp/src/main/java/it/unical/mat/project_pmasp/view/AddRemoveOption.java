package it.unical.mat.project_pmasp.view;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class AddRemoveOption {
	public static ButtonType  addRemoveAlert(String constraintType) {
		ButtonType add = new ButtonType("Add " + constraintType + " Constraint", ButtonData.YES);
		ButtonType remove = new ButtonType("Remove " + constraintType + " Constraint", ButtonData.NO);
		Alert alert = new Alert(AlertType.NONE, "Select an option.", add, remove, ButtonType.CANCEL);
		alert.showAndWait();
		return alert.getResult();
		
	}
}
