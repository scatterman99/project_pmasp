package it.unical.mat.project_pmasp.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Solver {

	private static Solver instance = null;
	private ArrayList<TraceAccepted> acceptedTraces;

	private Solver() {
		acceptedTraces = new ArrayList<>();
	}

	public static Solver getInstance() {
		if (instance == null)
			instance = new Solver();
		return instance;
	}

	public void solve() {
		acceptedTraces = new ArrayList<>();
		DesktopHandler handler = new DesktopHandler(new DLV2DesktopService("executable/dlv2_windows_64.exe"));
		
		try {
			ASPMapper.getInstance().registerClass(Accepts.class);
			ASPMapper.getInstance().registerClass(Rejects.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}

		InputProgram ip = new ASPInputProgram();
		String currentLog = LogHandler.getInstance().getCurrentLog();
		String modelFile = GraphModelHandler.getInstance().generateModelFile();
		if (currentLog != null)
			ip.addProgram(currentLog);
		if (modelFile != null)
			ip.addProgram(modelFile);
		ip.addFilesPath("encodings/base.lp");
		ip.addFilesPath("encodings/conformance.lp");
		ip.addFilesPath("encodings/templates.lp");

		handler.addProgram(ip);

		Output o = handler.startSync();

		System.out.println(o.getOutput());
		
		AnswerSets answersets = (AnswerSets) o;
		for (AnswerSet a : answersets.getAnswersets()) {
			try {
				for (Object obj : a.getAtoms()) {
					if (obj instanceof Accepts) {
						Accepts accepts = (Accepts) obj;
						acceptedTraces.add(accepts.getTraceAccepted());
					}
					else if (obj instanceof Rejects) {
						Rejects rejects = (Rejects) obj;
						acceptedTraces.add(rejects.getTraceAccepted());
					}			
				}
				Collections.sort(acceptedTraces, new Comparator<TraceAccepted>() {
					@Override
					public int compare(TraceAccepted o1, TraceAccepted o2) {
						return o1.getId() - o2.getId();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ObservableList<TraceAcceptedProperty> getTraceAcceptedPropertyArray() {
		ArrayList<TraceAcceptedProperty> traceAcceptedPropertyArray = new ArrayList<>();
		for(TraceAccepted at : acceptedTraces)
			traceAcceptedPropertyArray.add(at.getTraceAcceptedProperty());
		return (ObservableList<TraceAcceptedProperty>) FXCollections.observableList(traceAcceptedPropertyArray);
	}
	
	public ObservableList<TraceAcceptedProperty> getTraceAcceptedPropertyArray(int i1, int i2) {
		ArrayList<TraceAcceptedProperty> traceAcceptedPropertyArray = new ArrayList<>();
		for(int i = i1 - 1; i < i2;i++) {
			TraceAccepted at = acceptedTraces.get(i);
			traceAcceptedPropertyArray.add(at.getTraceAcceptedProperty());
		}
		return (ObservableList<TraceAcceptedProperty>) FXCollections.observableList(traceAcceptedPropertyArray);
	}
	

}
