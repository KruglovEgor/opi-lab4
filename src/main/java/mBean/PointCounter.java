package mBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

@Named
@ApplicationScoped
public class PointCounter implements PointCounterMBean {
    private long pointCounter = 0L;
    private long correctPointCounter = 0L;

    public  PointCounter(){}


    @Override
    public void updatePointCount() {
        pointCounter++;
    }

    @Override
    public void updateCorrectPointCount() {
        correctPointCounter++;
    }

    @Override
    public long getCorrectPointCount() {
        return correctPointCounter;
    }

    @Override
    public long getPointCount() {
        return pointCounter;
    }

    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
        String name = AttributeChangeNotification.class.getName();
        String description = "Miss notification";
        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[] { info };
    }

}
