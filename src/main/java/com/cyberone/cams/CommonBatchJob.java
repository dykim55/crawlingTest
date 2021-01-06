package com.cyberone.cams; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component 
public class CommonBatchJob { 
    
    private final Logger logger = LoggerFactory.getLogger(CommonBatchJob.class);
    
    private long lLastTime;
    private long millis;    

    @Autowired
    WebBrowserPanel webBrowserPanel;
    
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void trainRsvJob() { 

        try {
            logger.debug("trainRsvJob Start...");
            lLastTime = System.currentTimeMillis();
            
            logger.debug(webBrowserPanel.getResourceLocation());
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            millis = System.currentTimeMillis() - lLastTime;
            logger.debug("trainRsvJob End... [소요시간: " + millis + "]");
        }
    }

}
