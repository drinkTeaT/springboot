package com.learn.rabbitmq.diy;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：手写生产者
 * @Author： Administrator
 * @Date： 2019-04-30 22:41
 **/
public class ClientProducer {
    public static void main(String[] args) throws IOException, TimeoutException {
        //    建立连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPassword("root");
        factory.setUsername("root");
        factory.setPort(5251);
        Connection connection = factory.newConnection();
        // 创建信道
        Channel channel = connection.createChannel();
        String queueName = channel.queueDeclare().getQueue();
        channel.exchangeDeclare("woExchange", "direct", true);
        channel.queueBind(queueName, "woExchange", "wowoKey");
        // 发送信息
        channel.basicPublish("woExchange", "wowoKey", true, MessageProperties.TEXT_PLAIN, "hello".getBytes());
    }


}
