package it.unical.mat.project_pmasp.model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("unaryConstraint")
public class UnaryConstraint {
	@Param(0)
	private String constraint;
	
	@Param(1)
	private String activity;

	public UnaryConstraint() {
		super();
	}

	public UnaryConstraint(String constraint, String activity) {
		super();
		this.constraint = constraint;
		this.activity = activity;
	}

	public String getConstraint() {
		return constraint;
	}

	public void setConstraint(String constraint) {
		this.constraint = constraint;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}	
	
}
