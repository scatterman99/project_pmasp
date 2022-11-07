package it.unical.mat.project_pmasp.model;

import java.util.ArrayList;

public class ActivityNode {
	private Activity activity;
	private ArrayList<String> unaryConstraints;
	private double x;
	private double y;

	public ActivityNode(Activity activity) {
		super();
		this.activity = activity;
		this.unaryConstraints = new ArrayList<>();
		this.x = 0;
		this.y = 0;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ArrayList<String> getUnaryConstraints() {
		return unaryConstraints;
	}

	public void setUnaryConstraints(ArrayList<String> unaryConstraints) {
		this.unaryConstraints = unaryConstraints;
	}

	public double getX() {
		return x;
	}

	public void setX(double d) {
		this.x = d;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
