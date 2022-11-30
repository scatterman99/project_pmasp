package it.unical.mat.project_pmasp;

import it.unical.mat.project_pmasp.view.GraphView;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SceneHandler {

	private static SceneHandler instance = null;
	private Stage modelStage = null;
	private Stage logStage = null;
	private int currentTraceId;

	private SceneHandler() {

	}

	public static SceneHandler getInstance() {
		if (instance == null)
			instance = new SceneHandler();
		return instance;
	}

	public void init(Stage primaryStage) throws Exception {
		Scene scene = loadScene("MainMenu.fxml", 1024, 680);
		setAndShow(primaryStage, scene, "PMASP", false);
		modelStage = primaryStage;
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent t) {
				Platform.exit();
				System.exit(0);
			}
		});
	}
	
	public void goToOption(String fxml, String title) throws Exception {
		Scene scene = loadScene(fxml, 500, 300);
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(modelStage);
		setAndShow(stage, scene, title, false);
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent t) {
				GraphView.getInstance().resetBoolean();
		        stage.close();
			}
		});
	}
	
	public void goToSolution() throws Exception {
		Scene scene = loadScene("Solution.fxml", 640, 400);
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(modelStage);
		setAndShow(stage, scene, "Solution", true);
	}
	
	public void goToTrace() throws Exception {
		Scene scene = loadScene("Trace.fxml", 640, 440);
		Stage stage = new Stage();
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(modelStage);
		setAndShow(stage, scene, "Trace", false);
	}
	
	public void goToLog() throws Exception {
		if(logStage == null) {
			Scene scene = loadScene("LogVisualization.fxml", 640, 440);
			System.out.println("ok");
			logStage = new Stage();
			setAndShow(logStage, scene, "View Log", false);
		}
	}

	private Scene loadScene(String view, int x, int y) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/it/unical/mat/project_pmasp/view/" + view));
		Parent root = (Parent) loader.load();
		return new Scene(root, x, y);
	}

	private void setAndShow(Stage stage, Scene scene, String title, boolean wait) throws Exception {
		stage.setScene(scene);
		stage.setTitle(title);
		stage.setResizable(false);
		if(wait)
			stage.showAndWait();
		else
			stage.show();
	}

	public Stage getModelStage() {
		return modelStage;
	}

	public void setModelStage(Stage modelStage) {
		this.modelStage = modelStage;
	}

	public int getCurrentTraceId() {
		return currentTraceId;
	}

	public void setCurrentTraceId(int currentTraceId) {
		this.currentTraceId = currentTraceId;
	}

	public Stage getLogStage() {
		return logStage;
	}

	public void setLogStage(Stage logStage) {
		this.logStage = logStage;
	}

}
