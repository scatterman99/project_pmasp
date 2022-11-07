package it.unical.mat.project_pmasp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import it.unical.mat.project_pmasp.enums.ErrorMessages;
import it.unical.mat.project_pmasp.view.Alerts;

public class LpModelHandler {

	private static LpModelHandler instance = null;

	private ArrayList<UnaryConstraint> unaryConstraints;
	private ArrayList<BinaryConstraint> binaryConstraints;
	private ArrayList<CellBean> cells;
	private ArrayList<EdgeBean> edges;

	private LpModelHandler() {
		reset();
	}

	public static LpModelHandler getInstance() {
		if (instance == null)
			instance = new LpModelHandler();
		return instance;
	}

	public void loadLpModelFile(String absolutePath) {
		reset();
		DesktopHandler handler = new DesktopHandler(new DLV2DesktopService("executable/dlv2_windows_64.exe"));

		try {
			ASPMapper.getInstance().registerClass(UnaryConstraint.class);
			ASPMapper.getInstance().registerClass(BinaryConstraint.class);
			ASPMapper.getInstance().registerClass(CellBean.class);
			ASPMapper.getInstance().registerClass(EdgeBean.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}

		InputProgram ip = new ASPInputProgram();
		ip.addFilesPath(absolutePath);

		handler.addProgram(ip);

		Output o = handler.startSync();

		AnswerSets answersets = (AnswerSets) o;
		for (AnswerSet a : answersets.getAnswersets()) {
			try {
				for (Object obj : a.getAtoms()) {
					if (obj instanceof UnaryConstraint) {
						UnaryConstraint con = (UnaryConstraint) obj;
						if(!ActivityHandler.getInstance().isValidActivity(con.getActivity().replace("\"","")))
							throw new Exception("1");
						unaryConstraints.add(con);
					}
					if (obj instanceof BinaryConstraint) {
						BinaryConstraint con = (BinaryConstraint) obj;
						if(!ActivityHandler.getInstance().isValidActivity(con.getActivity().replace("\"","")))
							throw new Exception("1");
						if(!ActivityHandler.getInstance().isValidActivity(con.getActivity2().replace("\"","")))
							throw new Exception("1");
						binaryConstraints.add(con);
					}
					if (obj instanceof CellBean) {
						CellBean cell = (CellBean) obj;
						if(!ActivityHandler.getInstance().isValidActivity(cell.getActivity().replace("\"","")))
							throw new Exception("1");
						cells.add(cell);
					}
					if (obj instanceof EdgeBean) {
						EdgeBean edge = (EdgeBean) obj;
						if(!ActivityHandler.getInstance().isValidActivity(edge.getActivity().replace("\"","")))
							throw new Exception("1");
						if(!ActivityHandler.getInstance().isValidActivity(edge.getActivity2().replace("\"","")))
							throw new Exception("1");
						edges.add(edge);
					}
				}
			} catch (Exception e) {
				Alerts.showError(e.getMessage().equals("1") ? ErrorMessages.LOAD_LPM_ERROR_ACTIVITY : ErrorMessages.LOAD_LPM_ERROR);
				reset();
				return;
			}
		}
		try {
			if(edges.isEmpty() && cells.isEmpty() && binaryConstraints.isEmpty() && unaryConstraints.isEmpty())
				throw new Exception();
		} catch (Exception e) {
			Alerts.showError(ErrorMessages.LOAD_LPM_ERROR);
		}
	}

	public ArrayList<UnaryConstraint> getUnaryConstraints() {
		return unaryConstraints;
	}

	public ArrayList<BinaryConstraint> getBinaryConstraints() {
		return binaryConstraints;
	}

	public ArrayList<CellBean> getCells() {
		return cells;
	}

	public ArrayList<EdgeBean> getEdges() {
		return edges;
	}

	private void reset() {
		unaryConstraints = new ArrayList<>();
		binaryConstraints = new ArrayList<>();
		cells = new ArrayList<>();
		edges = new ArrayList<>();
	}

}
