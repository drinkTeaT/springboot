package com.learn.rabbitmq.hr.system.message;

import com.learn.rabbitmq.hr.connstrategy.ConnStrategy;
import com.learn.rabbitmq.hr.connstrategy.ProductStrategyImpl;
import com.learn.rabbitmq.hr.system.HRSystemA;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

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
            receiveChannel.queueDeclare("receive", false, false, false, null);
            String receive = receiveChannel.basicConsume("receive", true, new DefaultConsumer(receiveChannel) {
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope,
                                           AMQP.BasicProperties properties, byte[] body) throws UnsupportedEncodingException {
                    String message = null;
                    message = new String(body, "UTF-8");
                    System.out.println("get " + message);
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MessageSysAImpl().mission();
    }
}
