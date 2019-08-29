package com.learn.rabbitmq.hr.system.message;

import com.learn.rabbitmq.hr.connstrategy.ConnStrategy;
import com.learn.rabbitmq.hr.connstrategy.ConsumeStrategyImpl;
import com.learn.rabbitmq.hr.connstrategy.ProductStrategyImpl;
import com.learn.rabbitmq.hr.system.HRSystemB;
import com.rabbitmq.client.AMQP;
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
            channel.queueDeclare("receive", false, false, false, null);
            channel.exchangeDeclare("test", "direct", false);
            channel.queueBind("receive", "test", "routeKey");
            String value = "Hello World!";
            channel.basicPublish("test", "routeKey", null, value.getBytes());
            System.out.println("Send " + value);
            channel.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSysBImpl().mission();
    }
}
