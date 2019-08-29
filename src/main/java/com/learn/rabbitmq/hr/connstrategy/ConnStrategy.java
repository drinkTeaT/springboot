package com.learn.rabbitmq.hr.connstrategy;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-08-28 22:05
 **/
public interface ConnStrategy {
    Connection getConnection();
}
