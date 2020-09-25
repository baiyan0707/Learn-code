package blog.baiyan.github.kafka;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author bai
 * @Description kafka消费方
 * @Date 2020/7/12 4:06 PM
 * @github https://github.com/baiyan0707
 */
public class ConsumerCreator {
    public static Consumer<String, String> createConsumer() {
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER_LIST);
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID_CONFIG);
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new KafkaConsumer<>(properties);
    }

    public static void main(String[] args) {
        final String topic = "test-topic";
        Consumer<String, String> consumer = ConsumerCreator.createConsumer();
        // 循环消费消息
        while (true) {
            //subscribe topic and consume message
            consumer.subscribe(Collections.singletonList(topic));

            ConsumerRecords<String, String> consumerRecords =
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println("Consumer consume message:" + consumerRecord.value());
            }
        }
    }
}
