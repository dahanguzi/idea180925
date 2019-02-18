package com.atguigu.gmall.gmallserviceutil.producer;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQTextMessage;

import javax.jms.*;

public class ProducerTest {
    public static void main(String[] args) throws JMSException {
        //创建工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.136.128:61616");

        //创建连接
        Connection connection = connectionFactory.createConnection();

        //开启连接
        connection.start();

        //创建session会话对象
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        //创建队列
        Queue queue = session.createQueue("Atguigu");

        //创建消息对象的产生者
        MessageProducer producer = session.createProducer(queue);

        //创建消息对象
        ActiveMQTextMessage activeMQTextMessage = new ActiveMQTextMessage();
        activeMQTextMessage.setText("中华人民共和国");

        //发送消息
        producer.send(activeMQTextMessage);

        producer.close();
        session.close();
        connection.close();
    }
}
