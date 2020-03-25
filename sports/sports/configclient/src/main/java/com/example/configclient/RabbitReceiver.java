package com.example.configclient;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RabbitReceiver {
    private static final String QUEUE_NAME = "queue_demo";
    private static final String IP_ADDRESS = "localhost";
    private static final int PORT = 5672;

    public static void main(String[] args) {
        Address[] addresses = new Address[]{new Address(IP_ADDRESS, PORT)};
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("chuzhenbo");
        factory.setPassword("chuzhenbo");
        //这里的连接方式与生产者的demo略有不同，注意辨别区别
        //创建连接
        try {
            Connection connection = factory.newConnection(addresses);
            //创建信道
            final Channel channel = connection.createChannel();
            //设置客户端最多接受未被ack的消息的个数
            channel.basicQos(64);

            Consumer consumer = new DefaultConsumer(channel){

                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    super.handleDelivery(consumerTag, envelope, properties, body);
                    System.out.println(new String(body));
                    channel.basicAck(envelope.getDeliveryTag(),true);
                }
            };
            channel.basicConsume(QUEUE_NAME,consumer);


            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            channel.close();
            connection.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
