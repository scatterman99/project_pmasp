package it.unical.mat.project_pmasp.model;

import java.util.ArrayList;

import com.fxgraph.edges.CorneredLoopEdge.Position;

import it.unical.mat.project_pmasp.enums.EdgeTypes;
import it.unical.mat.project_pmasp.view.GraphView;
import javafx.geometry.Orientation;

public class GraphModelHandler {
	private ArrayList<ActivityNode> activityNodes;
	private ArrayList<ConstraintEdge> constraintEdges;

	private static GraphModelHandler instance = null;

	private GraphModelHandler() {
		reset();
	}

	public static GraphModelHandler getInstance() {
		if (instance == null)
			instance = new GraphModelHandler();
		return instance;
	}

	public void addActivityNode(String activity) {
		for (ActivityNode a : activityNodes)
			if (a.getActivity().getName().equals(activity))
				return;
		activityNodes.add(new ActivityNode(new Activity(activity)));
	}

	public void removeActivityNode(String activity) {
		ActivityNode toRemove = null;
		for (ActivityNode a : activityNodes)
			if (a.getActivity().getName().equals(activity))
				toRemove = a;
		for (int i = 0; i < constraintEdges.size(); i++)
			if (constraintEdges.get(i).getSource().getName().equals(activity)
					|| constraintEdges.get(i).getDestination().getName().equals(activity)) {
				constraintEdges.remove(constraintEdges.get(i));
				i--;
			}
		activityNodes.remove(toRemove);
	}

	public void addUnaryConstraint(String activity, String constraint) {
		for (ActivityNode a : activityNodes)
			if (a.getActivity().getName().equals(activity) && !a.getUnaryConstraints().contains(constraint))
				a.getUnaryConstraints().add(constraint);
	}

	public void removeUnaryConstraint(String activity, String constraint) {
		for (ActivityNode a : activityNodes)
			if (a.getActivity().getName().equals(activity))
				a.getUnaryConstraints().remove(constraint);
	}

	public void addBinaryConstraint(String source, String destination, String constraint) {
		for (ConstraintEdge e : constraintEdges)
			if (e.getSource().getName().equals(source) && e.getDestination().getName().equals(destination)) {
				if (!e.getBinaryConstraints().contains(constraint))
					e.getBinaryConstraints().add(constraint);
				return;
			}
		ConstraintEdge ce;
		if (!source.equals(destination))
			ce = new ConstraintEdge(new Activity(source), new Activity(destination), EdgeTypes.NORMAL, null, null);
		else
			ce = new ConstraintEdge(new Activity(source), new Activity(destination), EdgeTypes.CORNERED_LOOP, null,
					Position.TOP);
		ce.getBinaryConstraints().add(constraint);
		constraintEdges.add(ce);
	}

	public void removeBinaryConstraint(String source, String destination, String constraint) {
		for (int i = 0; i < constraintEdges.size(); i++)
			if (constraintEdges.get(i).getSource().getName().equals(source)
					&& constraintEdges.get(i).getDestination().getName().equals(destination)) {
				constraintEdges.get(i).getBinaryConstraints().remove(constraint);
				if (constraintEdges.get(i).getBinaryConstraints().isEmpty())
					constraintEdges.remove(constraintEdges.get(i));
			}
	}

	public String generateModelFile() {
		StringBuilder model = new StringBuilder();
		for (ActivityNode a : activityNodes)
			for (String constraint : a.getUnaryConstraints()) {
				String lowercaseConstraint = constraint.toLowerCase();
				model.append("model(");
				model.append(lowercaseConstraint);
				model.append(",\"");
				model.append(a.getActivity().getName());
				model.append("\").\n");
			}
		for (ConstraintEdge e : constraintEdges)
			for (String constraint : e.getBinaryConstraints()) {
				String lowercaseConstraint = constraint.toLowerCase();
				model.append("model(");
				model.append(lowercaseConstraint);
				model.append(",\"");
				model.append(e.getSource().getName());
				model.append("\",\"");
				model.append(e.getDestination().getName());
				model.append("\").\n");
			}
		return model.toString();
	}

	public void loadGraph() {
		reset();
		GraphView.getInstance().resetGraph();
		for (CellBean cb : LpModelHandler.getInstance().getCells())
			activityNodes.add(cb.getActivityNode());
		for (UnaryConstraint uc : LpModelHandler.getInstance().getUnaryConstraints())
			for (ActivityNode a : activityNodes) {
				String activityName = uc.getActivity().replace("\"", "");
				if (activityName.equals(a.getActivity().getName()))
					a.getUnaryConstraints().add(uc.getConstraint().replace("\"", ""));
			}
		for (EdgeBean eb : LpModelHandler.getInstance().getEdges())
			constraintEdges.add(eb.getConstraintEdge());
		for (BinaryConstraint bc : LpModelHandler.getInstance().getBinaryConstraints()) {
			String source = bc.getActivity().replace("\"", "");
			String destination = bc.getActivity2().replace("\"", "");
			String constraint = bc.getConstraint().replace("\"", "");
			addBinaryConstraint(source, destination, constraint);
		}
	}

	public String exportModel() {
		StringBuilder model = new StringBuilder();
		for (ActivityNode a : activityNodes) {
			model.append("cell(\"");
			model.append(a.getActivity().getName());
			model.append("\",\"");
			model.append(a.getX());
			model.append("\",\"");
			model.append(a.getY());
			model.append("\").\n");
			for (String constraint : a.getUnaryConstraints()) {
				model.append("unaryConstraint(\"");
				model.append(constraint);
				model.append("\",\"");
				model.append(a.getActivity().getName());
				model.append("\").\n");
			}
		}
		for (ConstraintEdge e : constraintEdges) {
			model.append("edge(\"");
			model.append(e.getSource().getName());
			model.append("\",\"");
			model.append(e.getDestination().getName());
			model.append("\",");
			model.append(e.getEdgeType());
			model.append(",");
			model.append(buildOrientation(e));
			model.append(",");
			model.append(buildPosition(e));
			model.append(").\n");
			for (String constraint : e.getBinaryConstraints()) {
				model.append("binaryConstraint(\"");
				model.append(constraint);
				model.append("\",\"");
				model.append(e.getSource().getName());
				model.append("\",\"");
				model.append(e.getDestination().getName());
				model.append("\").\n");
			}
		}
		return model.toString();
	}

	private String buildOrientation(ConstraintEdge e) {
		if (e.getEdgeType() == EdgeTypes.NORMAL || e.getEdgeType() == EdgeTypes.CORNERED_LOOP)
			return "none";
		if (e.getOrientation().equals(Orientation.HORIZONTAL))
			return "horizontal";
		else if (e.getOrientation().equals(Orientation.VERTICAL))
			return "vertical";
		return "none";
	}

	private String buildPosition(ConstraintEdge e) {
		if (e.getEdgeType() != EdgeTypes.CORNERED_LOOP)
			return "none";
		if (e.getPosition().equals(Position.BOTTOM))
			return "bottom";
		else if (e.getPosition().equals(Position.TOP))
			return "top";
		else if (e.getPosition().equals(Position.LEFT))
			return "left";
		else if (e.getPosition().equals(Position.RIGHT))
			return "right";
		return "none";
	}

	public ArrayList<Activity> getActivities() {
		return ActivityHandler.getInstance().getActivities();
	}

	public void reset() {
		activityNodes = new ArrayList<>();
		constraintEdges = new ArrayList<>();
	}

	public ArrayList<ActivityNode> getActivityNodes() {
		return activityNodes;
	}

	public ArrayList<String> getBinaryConstraints(String source, String destination) {
		for (ConstraintEdge e : constraintEdges)
			if (e.getSource().getName().equals(source) && e.getDestination().getName().equals(destination))
				return e.getBinaryConstraints();
		return null;
	}

	public ConstraintEdge getConstraintEdge(String source, String destination) {
		for (ConstraintEdge e : constraintEdges)
			if (e.getSource().getName().equals(source) && e.getDestination().getName().equals(destination))
				return e;
		return null;
	}

	public ArrayList<ConstraintEdge> getConstraintEdges() {
		return constraintEdges;
	}

}
