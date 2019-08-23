package com.geekerstar.rabbitmq.quickstart;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //1.创建一个ConnectionFactory,并进行配置
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("10.211.55.10");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");

        //2.通过连接工厂创建连接
        Connection connection = connectionFactory.newConnection();

        //3.通过connection创建一个Channel
        Channel channel = connection.createChannel();

        //4.声明（创建）一个队列
        String queueName = "test001";
        channel.queueDeclare(queueName,true,false,false,null);

        //5.创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //6.设置channel
        channel.basicConsume(queueName,true,queueingConsumer);

        while(true){
            //7.获取消息
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String  msg = new String(delivery.getBody());
            System.out.println("消费端："+msg);
            //Envelope envelope = delivery.getEnvelope();

        }


    }
}
