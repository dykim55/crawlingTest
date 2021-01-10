package com.cyberone.cams;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import chrriis.dj.nativeswing.swtimpl.NativeComponent;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowserWindow;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserAdapter;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowOpeningEvent;
import chrriis.dj.nativeswing.swtimpl.components.WebBrowserWindowWillOpenEvent;

public class WebBrowserPanel {

	private static final String LS = System.getProperty("line.separator");
	
	private final Logger logger = LoggerFactory.getLogger(WebBrowserPanel.class);

	private JWebBrowser webBrowser = new JWebBrowser();
	
	private String objectId;
	
	private boolean complete = true;
	
	public WebBrowserPanel(Container pane) {
		
		System.out.println("start WebBrowserPanel()");
		
    	JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(webBrowser, BorderLayout.CENTER);
		
        pane.add(contentPane, BorderLayout.CENTER);
        
        webBrowser.addWebBrowserListener(new WebBrowserAdapter() {
        	
        	@Override
        	public void windowWillOpen(WebBrowserWindowWillOpenEvent e) {
        		logger.debug("windowWillOpen!!!");
        		JWebBrowser newBrowser = e.getNewWebBrowser();
        		SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        newBrowser.getWebBrowserWindow().dispose();
                    }
                });        		
        	}

        	@Override
        	public void windowOpening(WebBrowserWindowOpeningEvent e) {
        		logger.debug("windowOpening!!!");
        	}
        	
        	@Override
        	public void loadingProgressChanged(WebBrowserEvent e) {
        		//logger.debug(""+webBrowser.getLoadingProgress());
        		if (webBrowser.getLoadingProgress() == 100) {
        			//logger.debug("complete==============");
        			complete = true;
        			
        			/*
        		    Timer timer = new Timer(2000, new ActionListener() {
        		    	@Override
        		    	public void actionPerformed( ActionEvent e ) {
        		    	*/	
        		    		logger.debug("actionPerformed!!!");
        		    		
        		    		String result = (String)webBrowser.executeJavascriptWithResult(
        		    				"var width = 0;" + LS +
        		    				"var height = 0;" + LS +
        		    				"if(document.documentElement) {" + LS +
        		    				"  width = Math.max(width, document.documentElement.scrollWidth);" + LS +
        		    				"  height = Math.max(height, document.documentElement.scrollHeight);" + LS +
        		    				"}" + LS +
        		    				//"if(self.innerWidth) {" + LS +
        		    				//"  width = Math.max(width, self.innerWidth);" + LS +
        		    				//"  height = Math.max(height, self.innerHeight);" + LS +
        		    				//"}" + LS +
        		    				"if(document.body.scrollWidth) {" + LS +
        		    				"  width = Math.max(width, document.body.scrollWidth);" + LS +
        		    				"  height = Math.max(height, document.body.scrollHeight);" + LS +
        		    				"}" + LS +
        		    				"return width + '/' + height;");

        		    		// This may happen from time to time so we have to fail gracefully.
        		    		int index = result == null? -1: result.indexOf("/");
        		    		if(index < 0) {
        		    			logger.debug("An error occurred while capturing the full-page");
        		    		} else {
								NativeComponent nativeComponent = webBrowser.getNativeComponent();
								Dimension originalSize = nativeComponent.getSize();
								Dimension imageSize = new Dimension(Integer.parseInt(result.substring(0, index)), Integer.parseInt(result.substring(index + 1)));
								
								imageSize.width = Math.max(originalSize.width, imageSize.width);
								imageSize.height = Math.max(originalSize.height, imageSize.height);
								nativeComponent.setSize(imageSize);
								BufferedImage image = new BufferedImage(imageSize.width, imageSize.height, BufferedImage.TYPE_INT_RGB);
								nativeComponent.paintComponent(image);
								nativeComponent.setSize(originalSize);
        		            
								try {
									//File webImage = new File("/CAMS/web_crawler/" + objectId + ".png");
									File webImage = new File("C:/Temp/" + objectId + ".png");
									ImageIO.write(image, "png", webImage);
								} catch (Exception ex) {
									ex.printStackTrace();
								}
        		    		} 
        		    		
        		    	/*	
        		    	}
        		    });	
        		    timer.setRepeats(false);
        		    timer.start();
        		     */
        			
        			//logger.debug(webBrowser.getStatusText());
        			//logger.debug(e.getWebBrowser().getHTMLContent());
		        	//loadComplete=true;
        			
    				//Runnable worker = new WorkerThread();
    				//executor.execute(worker);
        			
        		}
        	}
        });
		
	}

	public void startWebCrawling() {

		try {
			webBrowser.navigate("https://www.naver.com");
			
			/*
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("account_id", "F9RiomQB0m5O46ybT773");
			paramMap.put("kinds", "url");
			
			List<Map<String, Object>> objectMaps = objectRepository.findObjectList(paramMap);
			for (Map<String, Object> object : objectMaps) {

		        	
				logger.debug((String)object.get("host"));
				webBrowser.navigate((String)object.get("host"));
		        	
				break;
			}
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void navigate(String objectId, String resourceLocation) {
		complete = false;
		setObjectId(objectId);
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	logger.debug("#### " + resourceLocation);
            	webBrowser.navigate(resourceLocation);
            }
        });
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

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}
	
	public boolean isComplete() {
		return complete;
	}
	
}
