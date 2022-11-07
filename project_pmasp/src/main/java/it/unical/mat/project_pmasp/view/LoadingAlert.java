package it.unical.mat.project_pmasp.view;

import it.unical.mat.project_pmasp.model.LogHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class LoadingAlert {
	private Alert alert;
	
	public LoadingAlert() {
		alert = new Alert(AlertType.NONE, "Loading, please wait.");
	}
	
	public void show() {
		alert.show();
	}
	
	public void close() {
		System.out.println("hide");
		alert.close();
	}
}
