package com.cyberone.cams;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;

@SpringBootApplication
public class CamsWebCrawlerApplication extends JFrame {

	private static final long serialVersionUID = 2831544235615090763L;

	private final Logger logger = LoggerFactory.getLogger(CamsWebCrawlerApplication.class);
	
	@Autowired
    WebBrowserPanel webBrowserPanel;
	
	@Autowired
	private ObjectRepository objectRepository;

	public static void main(String[] args) {
		//SpringApplication.run(CamsWebCrawlerApplication.class, args);
		
		System.out.println("start main()");
		
    	NativeInterface.open();
    	System.out.println("start main() 1");
    	
    	UIUtils.setPreferredLookAndFeel();
    	System.out.println("start main() 2");
    	
    	ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CamsWebCrawlerApplication.class)
                .headless(false).run(args);

    	System.out.println("start main() 3");
    	
        EventQueue.invokeLater(() -> {
        	
        	System.out.println("start main() 4");
        	
        	ctx.getBean(CamsWebCrawlerApplication.class).initUI();
        	ctx.getBean(CamsWebCrawlerApplication.class).setTitle("Cams Web Crawler");
        	ctx.getBean(CamsWebCrawlerApplication.class).setSize(1400, 800);
        	ctx.getBean(CamsWebCrawlerApplication.class).setLocationRelativeTo(null);
        	ctx.getBean(CamsWebCrawlerApplication.class).setDefaultCloseOperation(EXIT_ON_CLOSE);
            ctx.getBean(CamsWebCrawlerApplication.class).setVisible(true);
        });
        
        NativeInterface.runEventPump();
		
        System.out.println("end main()");
	}

    public void initUI() {
    	System.out.println("start initUI()");
    	webBrowserPanel = new WebBrowserPanel(getContentPane());

    	/*
        try {
        	SwingUtilities.invokeLater(new WorkerThread(webBrowserPanel));
        } catch (Exception e) {
		} finally {
		}
        */
    	
        Scheduler scheduler = new Scheduler(objectRepository, webBrowserPanel); 
        scheduler.start();
        
        /*
        int delay = 10000;
        Timer timer = new Timer( delay, e -> {
        	//logger.debug(webBrowserPanel.getResourceLocation());
        	webBrowserPanel.startWebCrawling();
        });
        timer.start();
        */
    }
	
	public class WorkerThread implements Runnable {
		
		WebBrowserPanel webBrowserPanel;
		
	    public WorkerThread(WebBrowserPanel webBrowserPanel) {
	    	this.webBrowserPanel = webBrowserPanel;
	    }

	    @Override
	    public void run() {
	    	
			try {

				logger.debug("WorkerThread.run() start!!!");
				
				SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		            	webBrowserPanel.navigate("https://naver.com");
		            }
		        });

				int delay = 5000;
		        Timer timer = new Timer( delay, e -> {
		        	SwingUtilities.invokeLater(new Runnable() {
			            public void run() {
			            	webBrowserPanel.navigate("https://naver.com");
			            }
			        });		        
		        });
		        
		        timer.setRepeats(false);
		        timer.start();
				
				logger.debug("WorkerThread.run() end!!!");
				
			} catch (Exception e) {
			} finally {
			}
			
	    }

	} //end WorkerThread

	public class EmptyThread implements Runnable {
		
	    public EmptyThread() {
	    }

	    @Override
	    public void run() {
	    	
			try {
				logger.debug("EmptyThread.run() start!!!");

				Thread.sleep(5000);

				logger.debug("EmptyThread.run() end!!!");
				
			} catch (Exception e) {
			} finally {
			}
			
	    }

	} //end WorkerThread
	
}
