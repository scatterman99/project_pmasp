package it.unical.mat.project_pmasp.model;

public class TraceAccepted {
	private int id;
	private boolean accepted;
	
	public TraceAccepted() {
		super();
	}


	public TraceAccepted(int id, boolean accepted) {
		super();
		this.id = id;
		this.accepted = accepted;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isAccepted() {
		return accepted;
	}


	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}


	public TraceAcceptedProperty getTraceAcceptedProperty() {
		return new TraceAcceptedProperty(id, accepted ? "ACCEPTED" : "REJECTED");
	}
	
	
	
	
}
