package it.unical.mat.project_pmasp.view;

import java.util.ArrayList;
import java.util.List;

import com.fxgraph.graph.Graph;
import com.fxgraph.graph.ICell;
import com.fxgraph.layout.Layout;

import it.unical.mat.project_pmasp.model.ActivityNode;
import it.unical.mat.project_pmasp.model.GraphModelHandler;

public class StandardLayout implements Layout {

	@Override
	public void execute(Graph graph) {
		List<ICell> cells = graph.getModel().getAllCells();
		ArrayList<ActivityNode> activityNodes = GraphModelHandler.getInstance().getActivityNodes();
		for(ICell cell : cells) {
			ActivityCell aCell = (ActivityCell) cell;
			for(ActivityNode a : activityNodes)
				if(a.getActivity().getName().equals(aCell.getActivityName().getText())) {
					graph.getGraphic(cell).relocate(a.getX(), a.getY());
				}
		}
	}

}
