package com.cyberone.cams;

import java.util.Calendar;
import java.util.Timer;

import com.cyberone.cams.CamsWebCrawlerApplication.WorkerThread;

public class Scheduler {

	private Timer timer;
	private FileDeleteScheduler fileDeleteScheduler; 
	private WorkerThread worker;
	
	public Scheduler(WorkerThread worker) {
		this.worker = worker;
		
		timer = new Timer(); 
		fileDeleteScheduler = new FileDeleteScheduler(worker); 
	} 
	
	public void start() { 
		Calendar cal = Calendar.getInstance(); 
		timer.scheduleAtFixedRate(fileDeleteScheduler, cal.getTime(), 30000); 
	}

}
