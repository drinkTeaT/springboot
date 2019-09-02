package com.learn.rabbitmq.hr.system.message;

import com.learn.rabbitmq.hr.connstrategy.ConnStrategy;
import com.learn.rabbitmq.hr.connstrategy.ConsumeStrategyImpl;
import com.learn.rabbitmq.hr.system.HRSystemB;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Description：
 * @Author： Administrator
 * @Date： 2019-08-28 22:32
 **/
public class MessageSysBImpl implements HRSystemB {
    @Override
    public void mission() {
        ConnStrategy conn = new ConsumeStrategyImpl();
        Connection connection = conn.getConnection();
        try {
            Channel channel = connection.createChannel();
            // 声明队列
            channel.queueDeclare("receive", false, false, false, null);
            channel.queueDeclare("1111111", false, false, false, null);
            // 声明交换器
            channel.exchangeDeclare("gggg", "topic", false, true, null);
            channel.exchangeDeclare("test", "topic", false);
            // 交换器绑定队列
            channel.queueBind("receive", "test", "*.receive.*");
            channel.queueBind("1111111", "test", "routeKey1.#");
            // 传输的消息
            String value = "Hello World!";
            // 发送消息
            channel.basicPublish("test", "routeKey", null, value.getBytes());
            System.out.println("Send " + value);
            channel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSysBImpl().mission();
    }
}
