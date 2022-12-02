package it.unical.mat.project_pmasp.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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

public class LogHandler {

	private static LogHandler instance = null;

	private String currentLog;
	private ArrayList<EventProperty> events;

	private LogHandler() {
		events = new ArrayList<>();
	}

	public static LogHandler getInstance() {
		if (instance == null)
			instance = new LogHandler();
		return instance;
	}

	public void loadXesFile(String absolutePath) {
		ProcessBuilder pb = new ProcessBuilder();
		String command = "python3 executable//xes2lp.py " + absolutePath + " -o log.lp";
		pb.command("cmd.exe", "/c", command);
		try {
			Process process = pb.start();
			int exitVal = process.waitFor();

			if (exitVal == 0) {
				loadLpFile("log.lp");
				Files.delete(Paths.get("log.lp"));
			} else {
				throw new Exception();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void loadLpFile(String absolutePath) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(absolutePath));
			StringBuilder sb = new StringBuilder();
			while (br.ready()) {
				String str = br.readLine();
				sb.append(str);
				sb.append("\n");
			}
			currentLog = sb.toString();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadTraces() {
		DesktopHandler handler = new DesktopHandler(new DLV2DesktopService("executable/dlv2_windows_64.exe"));

		try {
			ASPMapper.getInstance().registerClass(Event.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}
		
		events = new ArrayList<>();

		InputProgram ip = new ASPInputProgram();
		ip.addProgram(LogHandler.getInstance().getCurrentLog());

		handler.addProgram(ip);

		Output o = handler.startSync();

		AnswerSets answersets = (AnswerSets) o;
		for (AnswerSet a : answersets.getAnswersets()) {
			try {
				for (Object obj : a.getAtoms()) {
					if (obj instanceof Event) {
						Event ev = (Event) obj;
						events.add(ev.getEventProperty());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Collections.sort(events, new Comparator<EventProperty>() {
			@Override
			public int compare(EventProperty e1, EventProperty e2) {
				if(e1.getTraceIdProperty().get() == e2.getTraceIdProperty().get())
					return e1.getEventIdProperty().get() - e2.getEventIdProperty().get();
				return e1.getTraceIdProperty().get() - e2.getTraceIdProperty().get();
			}
		});
	}
	
	public ObservableList<EventProperty> getEventPropertyArray(int i1, int i2) {
		ArrayList<EventProperty> eventPropertyArray = new ArrayList<>();
		for(EventProperty e : events)
			if(e.getTraceIdProperty().get() >= i1 && e.getTraceIdProperty().get() <= i2)
				eventPropertyArray.add(e);
		return (ObservableList<EventProperty>) FXCollections.observableList(eventPropertyArray);
	}
	
	public ObservableList<EventProperty> getEventPropertyArray() {
		return (ObservableList<EventProperty>) FXCollections.observableList(events);
	}

	public String getCurrentLog() {
		return currentLog;
	}

	public void setCurrentLog(String currentLog) {
		this.currentLog = currentLog;
	}

}
