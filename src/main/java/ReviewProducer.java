import java.util.Properties;
import java.util.Random;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class ReviewProducer {

    private final static String TOPIC = "restaurant.reviews";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092,localhost:9093,localhost:9094";

    public void run() {
        Random ran = new Random();
        Producer<Integer, String> producer = setUpProducer();
        try {
            while (true) {
                producer.send(new ProducerRecord<Integer, String>(TOPIC, "Test Review #" + Math.random()));
                waitForSeconds(ran.nextInt(6));
            }
        } finally {
            producer.flush();
            producer.close();
        }
    }

    private Producer<Integer, String> setUpProducer() {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        properties.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaExampleProducer");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<Integer, String>(properties);
    }

    private void waitForSeconds(int seconds) {
        try
        {
            Thread.sleep(1000 * seconds);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}