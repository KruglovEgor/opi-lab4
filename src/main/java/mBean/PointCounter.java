package mBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

@Named
@ApplicationScoped
public class PointCounter extends NotificationBroadcasterSupport implements PointCounterMBean, Serializable {
    private long pointCounter = 0L;
    private long correctPointCounter = 0L;
    private long sequenceNumber = 0L;

    public  PointCounter(){}


    @Override
    public void updatePointCount() {pointCounter++;}

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
    public void makeNewNotification() {
        Notification notification = new Notification("Certain number of points", getClass().getSimpleName(), sequenceNumber++, System.currentTimeMillis(), "Your number of points mod 15 == 0");
        sendNotification(notification);
    }

//    @Override
//    public MBeanNotificationInfo[] getNotificationInfo() {
//        String[] types = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
//        String name = AttributeChangeNotification.class.getName();
//        String description = "No notification";
//        MBeanNotificationInfo info = new MBeanNotificationInfo(types, name, description);
//        return new MBeanNotificationInfo[] { info };
//    }

}
