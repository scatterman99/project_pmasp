package it.unical.mat.project_pmasp.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EventProperty {
	private IntegerProperty traceId;
	private IntegerProperty eventId;
	private StringProperty event;
	
	public EventProperty(Integer traceId, Integer eventId, String event) {
		getTraceIdProperty().set(traceId);
		getEventIdProperty().set(eventId);
		getEventProperty().set(event);
	}

	public IntegerProperty getTraceIdProperty() {
		if (traceId == null)
			traceId = new SimpleIntegerProperty(this, "traceId");
		return traceId;
	}
	
	public IntegerProperty getEventIdProperty() {
		if (eventId == null)
			eventId = new SimpleIntegerProperty(this, "eventId");
		return eventId;
	}
	
	public StringProperty getEventProperty() {
		if (event == null)
			event = new SimpleStringProperty(this, "event");
		return event;
	}
}
