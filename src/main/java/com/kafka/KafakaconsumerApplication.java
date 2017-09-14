package com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Properties;

@SpringBootApplication
public class KafakaconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafakaconsumerApplication.class, args);

		 String topic = "lxw1234.com";
		 Properties props = new Properties();
		 props.put("bootstrap.servers", "192.168.36.129:22:9092");
		 props.put("group.id", "test");
		 props.put("enable.auto.commit", "true");
		 props.put("auto.commit.interval.ms", "1000");
		 props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
		 props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
			KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
			consumer.subscribe(Arrays.asList(topic));
		 while (true) {
		 ConsumerRecords<String, String> records = consumer.poll(100);
		 for (ConsumerRecord<String, String> record : records){
		 System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
		 }
     }

	}
}
