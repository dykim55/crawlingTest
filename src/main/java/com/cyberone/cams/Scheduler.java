package com.cyberone.cams;

import java.util.Calendar;
import java.util.Timer;

public class Scheduler {

	private Timer timer;
	private FileDeleteScheduler fileDeleteScheduler; 
	
	private ObjectRepository objectRepository;
	private WebBrowserPanel webBrowserPanel;
	
	public Scheduler(ObjectRepository objectRepository, WebBrowserPanel webBrowserPanel) { 
		this.objectRepository = objectRepository;
		this.webBrowserPanel = webBrowserPanel;
		
		timer = new Timer(); 
		fileDeleteScheduler = new FileDeleteScheduler(objectRepository, webBrowserPanel); 
	} 
	
	public void start() { 
		Calendar cal = Calendar.getInstance(); 
		timer.scheduleAtFixedRate(fileDeleteScheduler, cal.getTime(), 30000); 
	}

}
