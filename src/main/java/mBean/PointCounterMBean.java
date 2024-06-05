package mBean;

import javax.management.MBeanNotificationInfo;

public interface PointCounterMBean {
    void updatePointCount();
    void updateCorrectPointCount();

    long getCorrectPointCount();
    long getPointCount();

    void refreshPointCount();
    void  refreshCorrectPointCount();

    void makeNewNotification();

    MBeanNotificationInfo[] getNotificationInfo();
}
