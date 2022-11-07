package it.unical.mat.project_pmasp;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneHandler.getInstance().init(primaryStage);
	}

}
