package mBean;

import javax.management.MBeanNotificationInfo;

public interface PointCounterMBean {
    void updatePointCount();
    void updateCorrectPointCount();

    long getCorrectPointCount();
    long getPointCount();
    MBeanNotificationInfo[] getNotificationInfo();
}
