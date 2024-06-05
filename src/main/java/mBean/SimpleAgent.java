package mBean;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.ejb.Singleton;
import javax.management.*;
import java.lang.management.ManagementFactory;

@Singleton
@Startup
public class SimpleAgent {


    @Inject
    private PointCounter pointCounter;

    public SimpleAgent(){}

    @PostConstruct
    public void startAgent(){
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName;
        try {
            objectName = new ObjectName("SimpleAgent:type=PointCounter");
            if (!server.isRegistered(objectName)) {
                server.registerMBean(pointCounter, objectName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void logSimpleAgentStarted() {
        System.out.println("SimpleAgent.logSimpleAgentStarted");
    }

    public void startup(@Observes @Initialized(ApplicationScoped.class) Object context) {
        SimpleAgent a = new SimpleAgent();
        a.logSimpleAgentStarted();
    }
}