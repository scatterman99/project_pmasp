package it.unical.mat.project_pmasp.model;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;

@Id("cell")
public class CellBean {
	
	@Param(0)
	private String activity;
	
	@Param(1)
	private String x;
	
	@Param(2)
	private String y;

	public CellBean() {
		super();
	}

	public CellBean(String activity, String x, String y) {
		super();
		this.activity = activity;
		this.x = x;
		this.y = y;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	public ActivityNode getActivityNode() {
		String activity2 = activity.replace("\"", "");
		ActivityNode an = new ActivityNode(new Activity(activity2));
		String x2 = x.replace("\"", "");
		String y2 = y.replace("\"", "");
		an.setX(Double.parseDouble(x2));
		an.setY(Double.parseDouble(y2));
		return an;
	}
	
}
