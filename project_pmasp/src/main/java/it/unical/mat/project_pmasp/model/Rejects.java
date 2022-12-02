package it.unical.mat.project_pmasp.model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("rejects")
public class Rejects {
	
	@Param(0)
	private int traceId;
	

	public Rejects() {
		super();
	}

	public Rejects(int traceId) {
		super();
		this.traceId = traceId;
	}

	public int getTraceId() {
		return traceId;
	}

	public void setTraceId(int traceId) {
		this.traceId = traceId;
	}
	
	public TraceAccepted getTraceAccepted() {
		return new TraceAccepted(traceId, false);
	}
	
}
