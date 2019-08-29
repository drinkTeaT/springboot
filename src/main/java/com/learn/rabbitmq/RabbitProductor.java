package com.learn.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**
 * @Description：生产者代码
 * @Author： Administrator
 * @Date： 2019-04-29 22:36
 **/
public class RabbitProductor {
    //设置消息队列的名称
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws java.io.IOException, TimeoutException {

        /**
         * 创建一个到RabbitMQ Server 的连接
         * 连接抽象出套接字连接，并为我们处理协议版本协商和身份验证等。
         * 在这里，我们连接到本地机器上的代理 - 因此是本地主机。
         * 如果我们想连接到另一台机器上的代理，我们只需在此指定其名称或IP地址。
         * */
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        /**
         * 接下来我们创建一个Channel 对象，这是大部分用于完成任务的API驻留的地方。
         * 要想发送出去，我们必须声明一个队列来执行发送,那么我们可以将消息发布到队列中：
         * */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        //声明一个队列是幂等的 - 只有当它不存在时才会被创建。
        //消息内容是一个字节数组，所以你可以编码任何你喜欢的地方。
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        //最后我们关闭这些连接对象
        channel.close();
        connection.close();

    }
}
