package mBean;

import javax.management.MBeanNotificationInfo;

public interface PointCounterMBean {
    void updatePointCount();
    void updateCorrectPointCount();

    long getCorrectPointCount();
    long getPointCount();

    void setPointCount(long pointCount);
    void  setCorrectPointCount(long correctPointCount);

    void makeNewNotification();

    MBeanNotificationInfo[] getNotificationInfo();
}
