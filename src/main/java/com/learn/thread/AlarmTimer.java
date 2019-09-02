package com.learn.thread;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Description：当时间的秒数到59发出又过了一分钟的警告
 * Author：tacbin
 * Date:2019-08-31 11:34
 **/
public class AlarmTimer {

    public static void main(String[] args) {
        new AlarmTimer().setPeriod();
    }

    public void setPeriod() {
        TimerTask alarmTask = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime localDate = LocalDateTime.now();
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我来搞事情了 " + localDate.toString());
            }
        };
        Timer timer = new Timer();
        timer.schedule(alarmTask, 0, 1000 * 5);
    }
}
