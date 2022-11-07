package it.unical.mat.project_pmasp.view;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class Alerts {
	public static void showError(String errorType) {
		Alert alert = new Alert(AlertType.ERROR, errorType);
		alert.show();
	}
	
	public static void about() {
		Alert alert = new Alert(AlertType.NONE, "PMASP: Compliance Task Executor based on ASP. Created by Domenico Brunetti.", ButtonType.OK);
		alert.show();
	}
}
