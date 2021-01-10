package com.cyberone.cams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cyberone.cams.CamsWebCrawlerApplication.WorkerThread;

class FileDeleteScheduler extends TimerTask {
	
	private final Logger logger = LoggerFactory.getLogger(FileDeleteScheduler.class);

	private WorkerThread worker;
	
	public FileDeleteScheduler(WorkerThread worker) {
		this.worker = worker;
	}
	
	public void run() {
		System.out.println("start FileDeleteScheduler()");
		logger.debug("FileDeleteScheduler run()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("account_id", "F9RiomQB0m5O46ybT773");
		paramMap.put("kinds", "url");

		
		List<Map<String, String>> objectMaps = new ArrayList<Map<String, String>>();
		Map<String, String> hMap = new HashMap<String, String>();
		hMap.put("_id", "112233445566778899");
		hMap.put("host", "http://www.kcg.go.kr/kcg/main.do");
		objectMaps.add(hMap);

		hMap = new HashMap<String, String>();
		hMap.put("_id", "998877665544332211");
		hMap.put("host", "https://edu.kcga.go.kr/main0.jsp");
		objectMaps.add(hMap);
		
		
		try {
			//List<Map<String, Object>> objectMaps = objectRepository.findObjectList(paramMap);
			for (Map<String, String> object : objectMaps) {

				String objectId = (String)object.get("_id");
				String host = (String)object.get("host");
				
				worker.addQueue(object);
				

				/*
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	logger.debug("{} : {}", objectId, host);
		            	webBrowserPanel.setObjectId(objectId);
		            	webBrowserPanel.navigate(host);
		            }
		        });
				*/
				
				
				for (int i = 0; i < 5; i++) {
					Integer nNo = new Integer(i);	
					SwingUtilities.invokeAndWait(new Runnable() {
			            public void run() {
			            	logger.debug(nNo + ":==============================================================");
			            	try { Thread.sleep(1000); } catch (Exception e) {}
			            }
			        });
				}
				
				logger.debug("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				//break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
