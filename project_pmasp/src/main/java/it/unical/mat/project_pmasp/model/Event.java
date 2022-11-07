package it.unical.mat.project_pmasp.model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("trace")
public class Event {
	@Param(0)
	private int traceId;
	
	@Param(1)
	private int eventId;
	
	@Param(2)
	private String event;

	public Event() {
		super();
	}

	public Event(int traceId, int eventId, String event) {
		super();
		this.traceId = traceId;
		this.eventId = eventId;
		this.event = event;
	}

	public int getTraceId() {
		return traceId;
	}

	public void setTraceId(int traceId) {
		this.traceId = traceId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}
	
	public EventProperty getEventProperty() {
		return new EventProperty(traceId, eventId, event.replace("\"", ""));
	}
}
