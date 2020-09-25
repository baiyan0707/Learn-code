package blog.baiyan.github.kafka;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author bai
 * @Description kafka生产方
 * @Date 2020/7/12 4:05 PM
 * @github https://github.com/baiyan0707
 */
public class ProducerCreator {
    public static Producer<String, String> createProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.BROKER_LIST);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, KafkaConstants.CLIENT_ID);
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(properties);
    }

    /**
     * 生产者发送消息
     */
    public static void main(String[] args) {

        final String topic = "test-topic";
        Producer<String, String> producer = ProducerCreator.createProducer();
        ProducerRecord<String, String> record = new ProducerRecord<>(topic, "hello, Kafka!");
        try {
            //send message
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Record sent to partition " + metadata.partition()
                    + " with offset " + metadata.offset());
        } catch (ExecutionException | InterruptedException e) {
            System.out.println("Error in sending record");
            e.printStackTrace();
        }
        producer.close();
    }
}

