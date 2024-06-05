package mBean;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
public class AvgTimeClicking implements AvgTimeClickingMBean, Serializable {
    private long countOfClicks = 0L;
    private long lastClickTime = System.currentTimeMillis();
    private long sumOfClickTime = 0L;
    private long avgTime = -1;


    @Override
    public void updateAvgTime() {
        countOfClicks++;
        long timeNow = System.currentTimeMillis();
        sumOfClickTime += timeNow-lastClickTime;
        lastClickTime = timeNow;
        avgTime = (countOfClicks > 1) ? sumOfClickTime / (countOfClicks - 1) : -1;
    }

    @Override
    public long getAvgTime() {
        return avgTime;
    }
}
