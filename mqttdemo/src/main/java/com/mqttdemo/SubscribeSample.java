package com.mqttdemo;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.atomic.AtomicInteger;

public class SubscribeSample {
    public static void main(String[] args) {
        String broker = "tcp://192.168.0.210:12345";
        String topic = "demo/test";
//        String topic="mqtt/+";
//        String topic="$SYS/#";
        String username = "test";
        String password = "1qaz@WSX3edc";
        String clientid =MqttClient.generateClientId();
        int qos = 0;
        AtomicInteger retryCount = new AtomicInteger(0);
        try {
            MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
            // 连接参数
            MqttConnectOptions options = new MqttConnectOptions();
//            options.setServerURIs(new String[]{"tcp://192.168.0.210:1883","tcp://192.168.0.211:1883","tcp://192.168.0.211:1883"});
            options.setUserName(username);
            options.setPassword(password.toCharArray());
            options.setConnectionTimeout(60);
            options.setKeepAliveInterval(60);
            // 设置回调
            client.setCallback(new MqttCallback() {
                public void connectionLost(Throwable cause) {
                    System.out.println("connectionLost: " + cause.getMessage());
                    while (true) {
                        try {
                            retryCount.getAndIncrement();
                            Thread.sleep(1000);
                            System.out.println("尝试连接服务器第" + retryCount.get() + "次");
                            client.connect(options);
                            System.out.println("尝试连接服务器成功");
                            retryCount.set(0);
                            break;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        client.subscribe(topic, qos);
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }

                public void messageArrived(String topic, MqttMessage message) {
                    System.out.println("topic: " + topic);
                    System.out.println("Qos: " + message.getQos());
                    System.out.println("message content: " + new String(message.getPayload()));
                    System.out.println("\n");
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                    String clientId = token.getClient().getClientId();
                    System.out.println(clientId);
                    System.out.println("deliveryComplete---------" + token.isComplete());
                }
            });
            options.setWill("will/topic", "我下线了".getBytes(StandardCharsets.UTF_8), 0, false);
            client.connect(options);
            try {
                client.subscribe(topic, qos);
            } catch (MqttException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
