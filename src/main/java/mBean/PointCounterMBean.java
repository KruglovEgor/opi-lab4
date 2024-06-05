package mBean;

import javax.management.MBeanNotificationInfo;

public interface PointCounterMBean {
    void updatePointCount();
    void updateCorrectPointCount();

    long getCorrectPointCount();
    long getPointCount();

    void makeNewNotification();

    MBeanNotificationInfo[] getNotificationInfo();
}
