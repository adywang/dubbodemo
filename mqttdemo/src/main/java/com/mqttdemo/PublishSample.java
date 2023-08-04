package com.mqttdemo;

import com.alibaba.fastjson2.JSON;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class PublishSample {
    public static void main(String[] args) throws MqttException {
        for (int i = 0; i < 1; i++) {
            String broker = "tcp://192.168.0.210:12345";
//        ,tcp://192.168.0.211:1883,tcp://192.168.0.212:188
//            String topic = "demo/test";
            String topic="local_remote_demo";
//        String topic = "$share/remote/topic/ingress";
//        String username = "emqx";
//        String password = "emqx";
            String clientid = "publish_client";
//            String content = "{Hello MQTT！！！"+i+"}";
            Map map=new HashMap();
            map.put("userName","admin");
            map.put("password","pass123456");
            map.put("id",i);
            String content= JSON.toJSONString(map);
            int qos = 0;

            try {
                MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
                // 连接参数
                MqttConnectOptions options = new MqttConnectOptions();
//            options.setServerURIs(new String[]{"tcp://192.168.0.210:1883","tcp://192.168.0.211:1883","tcp://192.168.0.211:1883"});
                // 设置用户名和密码
//            options.setUserName(username);
//            options.setPassword(password.toCharArray());

                options.setConnectionTimeout(60);
                options.setKeepAliveInterval(60);
                options.setWill("will/topic", "生产者下线".getBytes(StandardCharsets.UTF_8), 0, false);
                // 连接
                client.connect(options);
                // 创建消息并设置 QoS
                MqttMessage message = new MqttMessage(content.getBytes());
                message.setQos(qos);
                //是否保留消息
//            message.setRetained(true);

                // 发布消息
                client.publish(topic, message);
                System.out.println("Message published");
                System.out.println("topic: " + topic);
                System.out.println("message content: " + content);
                // 关闭连接
                client.disconnect();
                // 关闭客户端
                client.close();
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
