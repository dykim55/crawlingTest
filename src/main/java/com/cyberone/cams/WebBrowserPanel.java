package com.cyberone.cams;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;

@Service
public class WebBrowserPanel extends JPanel {

	private static final long serialVersionUID = 3293984816682598200L;

	private final Logger logger = LoggerFactory.getLogger(WebBrowserPanel.class);

	private JWebBrowser webBrowser = new JWebBrowser();
	
	private ObjectRepository objectRepository;

	public WebBrowserPanel(ObjectRepository objectRepository) {
		
		this.objectRepository = objectRepository;
		
		this.setLayout(new BorderLayout());
		this.add(webBrowser, BorderLayout.CENTER);
		
        webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
        	@Override
        	public void loadingProgressChanged(WebBrowserEvent e) {
        		logger.debug(""+webBrowser.getLoadingProgress());
        		if (webBrowser.getLoadingProgress() == 100) {
        			logger.debug("complete==============");
        			//logger.debug(webBrowser.getStatusText());
        			//logger.debug(e.getWebBrowser().getHTMLContent());
		        	//loadComplete=true;
        			
    				//Runnable worker = new WorkerThread();
    				//executor.execute(worker);
        			
        		}
        	}
        });
		
	}

	public List<Map<String, Object>> findObjectList() throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("account_id", "F9RiomQB0m5O46ybT773");
		paramMap.put("kinds", "url");

		return objectRepository.findObjectList(paramMap);
	}
	
	public void startWebCrawling() {

		try {
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("account_id", "F9RiomQB0m5O46ybT773");
			paramMap.put("kinds", "url");
			
			List<Map<String, Object>> objectMaps = objectRepository.findObjectList(paramMap);
			for (Map<String, Object> object : objectMaps) {

		        	
				logger.debug((String)object.get("host"));
				webBrowser.navigate((String)object.get("host"));
		        	
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean navigate(String resourceLocation) {
		return webBrowser.navigate(resourceLocation);
	}
	
	public String getResourceLocation() {
		return webBrowser.getResourceLocation();
	}
	
	public JWebBrowser getWebBrowser() {
		return webBrowser;
	}

	public void setWebBrowser(JWebBrowser webBrowser) {
		this.webBrowser = webBrowser;
	}
	
	
	
}
