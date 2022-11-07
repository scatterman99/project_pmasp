package it.unical.mat.project_pmasp.model;

import com.fxgraph.edges.CorneredLoopEdge.Position;

import it.unical.mat.embasp.languages.Id;
import it.unical.mat.embasp.languages.Param;
import javafx.geometry.Orientation;

@Id("edge")
public class EdgeBean {

	@Param(0)
	private String activity;

	@Param(1)
	private String activity2;

	@Param(2)
	private int style;

	@Param(3)
	private String orientation;

	@Param(4)
	private String position;

	public EdgeBean() {
		super();
	}

	public EdgeBean(String activity, String activity2, int style, String orientation, String position) {
		super();
		this.activity = activity;
		this.activity2 = activity2;
		this.style = style;
		this.orientation = orientation;
		this.position = position;
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

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public ConstraintEdge getConstraintEdge() {
		ConstraintEdge ce = new ConstraintEdge(new Activity(activity.replace("\"", "")), new Activity(activity2.replace("\"", "")), style, null, null);
		if(!orientation.equals("none")) {
			if(orientation.equals("horizontal"))
				ce.setOrientation(Orientation.HORIZONTAL);
			else
				ce.setOrientation(Orientation.VERTICAL);
		}
		if(!position.equals("none")) {
			if(position.equals("top"))
				ce.setPosition(Position.TOP);
			else if(position.equals("bottom"))
				ce.setPosition(Position.BOTTOM);
			else if(position.equals("left"))
				ce.setPosition(Position.LEFT);
			else
				ce.setPosition(Position.RIGHT);
		}
		return ce;
	}
}
