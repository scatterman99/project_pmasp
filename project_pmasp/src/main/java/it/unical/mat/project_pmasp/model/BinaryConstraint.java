package it.unical.mat.project_pmasp.model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("binaryConstraint")
public class BinaryConstraint {
	@Param(0)
	private String constraint;
	
	@Param(1)
	private String activity;
	
	@Param(2)
	private String activity2;

	public BinaryConstraint() {
		super();
	}

	public BinaryConstraint(String constraint, String activity, String activity2) {
		super();
		this.constraint = constraint;
		this.activity = activity;
		this.activity2 = activity2;
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

	public String getActivity2() {
		return activity2;
	}

	public void setActivity2(String activity2) {
		this.activity2 = activity2;
	}

	
}
