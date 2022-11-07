package it.unical.mat.project_pmasp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TraceAcceptedProperty {
	private IntegerProperty traceNumber;
	private StringProperty solution;
	
	public TraceAcceptedProperty(Integer traceNumber, String solution) {
		getTraceNumberProperty().set(traceNumber);
		getSolutionProperty().set(solution);
	}

	public IntegerProperty getTraceNumberProperty() {
		if (traceNumber == null)
			traceNumber = new SimpleIntegerProperty(this, "traceNumber");
		return traceNumber;
	}
	
	public StringProperty getSolutionProperty() {
		if (solution == null)
			solution = new SimpleStringProperty(this, "solution");
		return solution;
	}
}
