package it.unical.mat.project_pmasp.model;

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

public class ActivityHandler {

	private static ActivityHandler instance = null;
	
	private ArrayList<Activity> activities;

	private ActivityHandler() {
		reset();
	}

	public void reset() {
		activities = new ArrayList<>();
	}

	public static ActivityHandler getInstance() {
		if (instance == null)
			instance = new ActivityHandler();
		return instance;
	}
	
	public void loadActivities() {
		reset();
		DesktopHandler handler = new DesktopHandler(new DLV2DesktopService("executable/dlv2_windows_64.exe"));

		try {
			ASPMapper.getInstance().registerClass(Activity.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e1) {
			e1.printStackTrace();
		}
		
		System.out.println("carico attività");

		InputProgram ip = new ASPInputProgram();
		ip.addProgram(LogHandler.getInstance().getCurrentLog());
		ip.addFilesPath("encodings/base.lp");
		ip.addFilesPath("encodings/showactivity.lp");

		handler.addProgram(ip);

		Output o = handler.startSync();

		AnswerSets answersets = (AnswerSets) o;
		for (AnswerSet a : answersets.getAnswersets()) {
			try {
				for (Object obj : a.getAtoms()) {
					if (!(obj instanceof Activity))
						continue;
					Activity act = (Activity) obj;
					String newAct = act.getName().replace("\"", "");
					System.out.println(act.getName());
					activities.add(new Activity(newAct));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}
	
	public boolean isValidActivity(String activity) {
		for(Activity a : activities) {
			System.out.println(a.getName());
			if(a.getName().equals(activity))
				return true;
		}
		return false;
	}

}
