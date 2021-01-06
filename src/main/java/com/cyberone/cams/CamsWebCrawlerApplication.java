package com.cyberone.cams;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.Timer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import chrriis.dj.nativeswing.swtimpl.NativeInterface;

@SpringBootApplication
@EnableScheduling
@EnableAsync
public class CamsWebCrawlerApplication extends JFrame {

	private static final long serialVersionUID = 2831544235615090763L;

	private final Logger logger = LoggerFactory.getLogger(CamsWebCrawlerApplication.class);
	
	@Autowired
    WebBrowserPanel webBrowserPanel;
	
	@Autowired
	private ObjectRepository objectRepository;

	public static void main(String[] args) {
		SpringApplication.run(CamsWebCrawlerApplication.class, args);
		
    	NativeInterface.open();
    	
    	ConfigurableApplicationContext ctx = new SpringApplicationBuilder(CamsWebCrawlerApplication.class)
                .headless(false).run(args);

        EventQueue.invokeLater(() -> {
        	ctx.getBean(CamsWebCrawlerApplication.class).initUI();
        	ctx.getBean(CamsWebCrawlerApplication.class).setTitle("Cams Web Crawler");
        	ctx.getBean(CamsWebCrawlerApplication.class).setSize(1024, 800);
        	ctx.getBean(CamsWebCrawlerApplication.class).setLocationRelativeTo(null);
        	ctx.getBean(CamsWebCrawlerApplication.class).setDefaultCloseOperation(EXIT_ON_CLOSE);
            ctx.getBean(CamsWebCrawlerApplication.class).setVisible(true);
        });
        
        NativeInterface.runEventPump();
		
	}

    public void initUI() {
    	webBrowserPanel = new WebBrowserPanel(objectRepository);
        
    	Container pane = getContentPane();
        pane.add(webBrowserPanel, BorderLayout.CENTER);
        
        int delay = 10000;
        Timer timer = new Timer( delay, e -> {
        	//logger.debug(webBrowserPanel.getResourceLocation());
        	
        	webBrowserPanel.startWebCrawling();

        	
        });
        timer.start();
    }
	
	public class WorkerThread implements Runnable {
		
	    public WorkerThread() {
	    }

	    @Override
	    public void run() {
	    	
			try {
			} catch (Exception e) {
			} finally {
			}
			
	    }

	} //end WorkerThread

}
