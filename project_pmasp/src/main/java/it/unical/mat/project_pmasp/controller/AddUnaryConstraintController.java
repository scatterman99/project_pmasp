package it.unical.mat.project_pmasp.controller;

import java.util.ArrayList;

import it.unical.mat.project_pmasp.enums.UnaryConstraints;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AddUnaryConstraintController {

	@FXML
	private ChoiceBox<String> constraintChoice;

	@FXML
	private void initialize() {
		ArrayList<String> unaryConstraints = new ArrayList<>();
		unaryConstraints.add(UnaryConstraints.ABSENCE);
		unaryConstraints.add(UnaryConstraints.AT_LEAST_1);
		unaryConstraints.add(UnaryConstraints.AT_LEAST_2);
		unaryConstraints.add(UnaryConstraints.AT_LEAST_3);
		unaryConstraints.add(UnaryConstraints.AT_MOST_1);
		unaryConstraints.add(UnaryConstraints.AT_MOST_2);
		unaryConstraints.add(UnaryConstraints.AT_MOST_3);
		unaryConstraints.add(UnaryConstraints.EXACTLY_1);
		unaryConstraints.add(UnaryConstraints.EXACTLY_2);
		unaryConstraints.add(UnaryConstraints.EXACTLY_3);
		unaryConstraints.add(UnaryConstraints.INIT);
		unaryConstraints.add(UnaryConstraints.END);
		constraintChoice.setItems((ObservableList<String>) FXCollections.observableList(unaryConstraints));
	}

	@FXML
	void addConstraintPressed(MouseEvent event) {
		if (constraintChoice.getSelectionModel().getSelectedItem() != null)
			GraphView.getInstance().addUnaryConstraint(constraintChoice.getSelectionModel().getSelectedItem());
	}

	@FXML
	void cancelPressed(MouseEvent event) {
		GraphView.getInstance().resetBoolean();
		Stage stage = (Stage) constraintChoice.getScene().getWindow();
        stage.close();
	}

}
