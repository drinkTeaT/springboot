package com.learn.rabbitmq.hr.system.message;

import com.learn.rabbitmq.hr.connstrategy.ConnStrategy;
import com.learn.rabbitmq.hr.connstrategy.ProductStrategyImpl;
import com.learn.rabbitmq.hr.system.HRSystemA;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

/**
 * @Description：发送信息
 * @Author： Administrator
 * @Date： 2019-08-28 22:31
 **/
public class MessageSysAImpl implements HRSystemA {
    @Override
    public void mission() {
        ConnStrategy conn = new ProductStrategyImpl();
        Connection connection = conn.getConnection();
        // 先接收
        try {
            Channel receiveChannel = connection.createChannel();
            AMQP.Queue.DeclareOk declareOk = receiveChannel.queueDeclare("receive", false, false, false, null);
            System.out.println(declareOk.getMessageCount());
            String consumerTag = receiveChannel.basicConsume("receive", false, new DefaultConsumer(receiveChannel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) {
                    String message = new String(body, StandardCharsets.UTF_8);
                    System.out.println("consumerTag " + consumerTag + " get " + message);
                }
            });
            System.out.println(consumerTag);
            receiveChannel.close();
            connection.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSysAImpl().mission();
    }
}
