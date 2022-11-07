package it.unical.mat.project_pmasp.model;

import java.util.ArrayList;

import com.fxgraph.edges.CorneredLoopEdge.Position;

import javafx.geometry.Orientation;

public class ConstraintEdge {
	private Activity source;
	private Activity destination;
	private ArrayList<String> binaryConstraints;
	private int edgeType;
	private Orientation orientation;
	private Position position;

	public ConstraintEdge(Activity source, Activity destination, int edgeType, Orientation orientation, Position position) {
		super();
		this.source = source;
		this.destination = destination;
		this.binaryConstraints = new ArrayList<>();
		this.edgeType = edgeType;
		this.orientation = orientation;
		this.position = position;
	}

	public Activity getSource() {
		return source;
	}

	public void setSource(Activity source) {
		this.source = source;
	}

	public Activity getDestination() {
		return destination;
	}

	public void setDestination(Activity destination) {
		this.destination = destination;
	}

	public ArrayList<String> getBinaryConstraints() {
		return binaryConstraints;
	}

	public void setBinaryConstraints(ArrayList<String> binaryConstraints) {
		this.binaryConstraints = binaryConstraints;
	}

	public int getEdgeType() {
		return edgeType;
	}

	public void setEdgeType(int edgeType) {
		this.edgeType = edgeType;
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	
}
