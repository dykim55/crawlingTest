package com.cyberone.cams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class FileDeleteScheduler extends TimerTask {
	
	private final Logger logger = LoggerFactory.getLogger(FileDeleteScheduler.class);

	private ObjectRepository objectRepository;
	private WebBrowserPanel webBrowserPanel;
		
	public FileDeleteScheduler(ObjectRepository objectRepository, WebBrowserPanel webBrowserPanel) {
		this.objectRepository = objectRepository;
		this.webBrowserPanel = webBrowserPanel;
	}
	
	public void run() {
		System.out.println("start FileDeleteScheduler()");
		logger.debug("FileDeleteScheduler run()");
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("account_id", "F9RiomQB0m5O46ybT773");
		paramMap.put("kinds", "url");

		try {
			List<Map<String, Object>> objectMaps = objectRepository.findObjectList(paramMap);
			for (Map<String, Object> object : objectMaps) {

				String objectId = (String)object.get("_id");
				String host = (String)object.get("host");

				logger.debug("{} : {}", objectId, host);
				
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	webBrowserPanel.setObjectId(objectId);
		            	webBrowserPanel.navigate("http://www.kcg.go.kr/kcg/main.do");
		            }
		        });
				
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
