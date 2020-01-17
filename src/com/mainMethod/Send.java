package com.mainMethod;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.util.MqUtil;

/**
 * @author yu.wenhua
 * @desc
 * @date 2020/1/16 20:18
 */
public class Send {
    private final static String QUEUE_NAME = "mq1";
    public void sendMsgToMQ() throws Exception{
        // 获取到连接以及mq通道
        Connection connection = MqUtil.getConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        for (int i = 0; i < 50; i++) {
            // 消息内容
            String message = "rhgfjghjghfjghjghjghfjghyrtyrtfghfgn" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
            Thread.sleep(i * 10);
        }

        channel.close();
        connection.close();
    }

}
