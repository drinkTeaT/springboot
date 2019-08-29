package com.learn.rabbitmq.diy;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：客户端消费者
 * @Author： Administrator
 * @Date： 2019-05-01 8:23
 **/
public class ClientConsumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //    建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPassword("root");
        factory.setUsername("root");
        factory.setPort(5251);
        Connection connection = factory.newConnection();
    }
}
