package com.learn.rabbitmq.hr.system;

import com.learn.rabbitmq.hr.connstrategy.ConnStrategy;
import com.learn.rabbitmq.hr.connstrategy.ConsumeStrategyImpl;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-08-28 22:02
 **/
public interface HRSystemA {
    void mission();
}